package listi;
import java.util.*;
public class SLLPomestiNaKraj {
public static void main(String [] args) {
	Scanner input=new Scanner(System.in);
	int n=input.nextInt();
	input.nextLine();
	SLL<String>lista=new SLL<String>();
	for(int i=0;i<n;i++) {
		lista.insertLast(input.nextLine());
		
	}
	int L=input.nextInt();
	SLLNode<String>jazol=lista.getFirst();

	
for(int i=0;i<n;i++) {
		if(jazol.element.length()==L) {
			
	
		lista.delete(jazol);
		lista.insertLast(jazol.element);
		
		}
			
			
		jazol=jazol.succ;
}
	System.out.print(lista);
}
}
