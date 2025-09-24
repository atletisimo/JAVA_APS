import java.util.*;
public class DLLPomestiPrviK {
public static void main(String [] args) {
	Scanner input=new Scanner(System.in);
	DLL<Integer>lista=new DLL<Integer>();
	DLLNode<Integer>jazol=lista.getFirst();
	int n=input.nextInt();
	for(int i=0;i<n;i++) {
		lista.insertLast(input.nextInt());
	}
	System.out.println(lista);
	int k=input.nextInt();//2

	for(int i=0;i<k;i++) {
		DLLNode<Integer>prv=lista.getFirst();
		int val=prv.element;
		
			lista.delete(prv);
			lista.insertLast(val);
		
		}
	 jazol = lista.getFirst();
     while (jazol != null) {
         System.out.print(jazol.element);
         if (jazol.succ != null) System.out.print("<->");
         jazol = jazol.succ;
}
}
}
