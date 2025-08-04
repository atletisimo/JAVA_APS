package listi;
import java.util.*;
public class SLLParenDuplikati {
	public static void main(String [] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();//11
		SLL<Integer> lista=new SLL<Integer>();
	
		for(int i=0;i<n;i++) {
			lista.insertLast(input.nextInt());
		}
		SLLNode<Integer>jazol=lista.getFirst();
		int counter=0;
		int info=input.nextInt();
		SLLNode<Integer>lastOccurance=null;
		while(jazol!=null) {
			int el;
			if(jazol.element==info) {
				counter++;
				lastOccurance=jazol;
			}
			
			jazol=jazol.succ;
		}
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
