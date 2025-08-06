package listi;
import java.util.*;
public class SLLParenDuplikati {
	public static void main(String [] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();// Број на елементи, пример: 11
		SLL<Integer> lista=new SLL<Integer>();
	
		for(int i=0;i<n;i++) {
			lista.insertLast(input.nextInt());
		}
		SLLNode<Integer>jazol=lista.getFirst();
		int counter=0;
		int info=input.nextInt();// Елементот што го проверуваме, пример: 2
		SLLNode<Integer>lastOccurance=null;
		// Проаѓање низ листата за броење на појави на info и чување на последната појава
		while(jazol!=null) {
			int el;
			if(jazol.element==info) {
				counter++;
				lastOccurance=jazol;// Секојпат кога го најдеме, го ажурираме
			}
			
			jazol=jazol.succ;
		}
				// Ако бројот на појави е НЕПАРЕН, ја бришеме последната појава
		if(counter%2!=0&&lastOccurance!=null) {
			lista.delete(lastOccurance);
		}
		jazol=lista.getFirst();
		while(jazol!=null) {
		System.out.print(jazol.element+" ");
			
			jazol=jazol.succ;
		}//1 2 5 7 9 12 2 4 1 2 8
	}

}
