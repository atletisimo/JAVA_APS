package listi;
import java.util.*;

public class SLLZigZagDelete {
	static void transformZigZag(SLL<Integer> lista) {
		SLLNode<Integer> jazol = lista.getFirst();
		
		while (jazol != null && jazol.succ != null) {
			int a = jazol.element;
			int b = jazol.succ.element;
			
			// Ако и двата се нула, избриши ги и двата
			if (a == 0 && b == 0) {
				lista.delete(jazol);
				lista.delete(jazol.succ);
				jazol = lista.getFirst();  // Почни од почеток
				continue;
			}
			
			// Ако првиот е нула, избриши го и почни од почеток
			if (a == 0) {
				lista.delete(jazol);
				jazol = lista.getFirst();
				continue;
			}
			
			// Ако вториот е нула, избриши го, но остани на истиот јазол за проверка со новиот следен
			if (b == 0) {
				lista.delete(jazol.succ);
				continue;
			}
			
			// Ако два позитивни по ред - избриши го вториот
			if (a > 0 && b > 0) {
				lista.delete(jazol.succ);
				continue;
			}
			
			// Ако два негативни по ред - вметни апсолутна вредност после првиот и премини на новиот јазол
			if (a < 0 && b < 0) {
				//lista.insertAfter(Math.abs(a), jazol);
				//jazol = jazol.succ;  // премини на нововметнатиот јазол
				//continue;
				int apsolutnaPrv=jazol.element*(-1);
				lista.insertAfter(apsolutnaPrv, jazol);
			}
			
			// Ако некој од условите не важи, само премини на следниот јазол
			jazol = jazol.succ;
		}
		
		// Ако на крај остане нула (еден елемент), избриши го
		if (jazol != null && jazol.element == 0) {
			lista.delete(jazol);
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();  // број на јазли
		SLL<Integer> list = new SLL<>();
		
		for (int i = 0; i < n; i++) {
			list.insertLast(input.nextInt());
		}
		
		transformZigZag(list);
		
		// Печатење на листата во формат 1 -> 2 -> 3
		SLLNode<Integer> node = list.getFirst();
		while (node != null) {
			System.out.print(node.element);
			if (node.succ != null) System.out.print(" -> ");
			node = node.succ;
		}
		System.out.println();
	}
}
//4 -3 -6 0 7 7 -2 5

