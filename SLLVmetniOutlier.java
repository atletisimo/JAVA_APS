package listi;
import java.util.*;
public class SLLVmetniOutlier  {
public static void main(String [] args) {
	Scanner input=new Scanner(System.in);
	int n=input.nextInt();//3
	input.nextLine();
	SLL<String> lista=new SLL<String>();
	for(int i=0;i<n;i++) {
		lista.insertLast(input.nextLine());
	}
	
	int L=input.nextInt();//5
	System.out.println(lista);
	SLLNode<String>jazol1=lista.getFirst();
	while(jazol1!=null) {
	
		if(jazol1.element.length()>L) {
			lista.insertBefore("Outlier", jazol1);
		}
		
		jazol1=jazol1.succ;
	}
	System.out.println(lista);
	
}
}
