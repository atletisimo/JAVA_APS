import java.util.*;
public class SLLZameniSosedi {
	public static void main(String [] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();//4
		SLL<Integer>lista=new SLL<Integer>();
		for(int i=0;i<n;i++) {
			int element=input.nextInt();
			lista.insertLast(element);//1 6 2 9 3
		}
		SLLNode<Integer>jazol=lista.getFirst();
		while(jazol!=null&&jazol.succ!=null) {
		int temp=jazol.element;//1
			jazol.element=jazol.succ.element;//1 zameni go so 2

			jazol.succ.element=temp;
			
			jazol=jazol.succ.succ;
		}
		System.out.println(lista);
		
	}

}
