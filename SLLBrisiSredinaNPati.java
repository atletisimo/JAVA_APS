package listi;
import java.util.*;
public class SLLBrisiSredinaNPati {
public static void main(String [] args) {
	Scanner input=new Scanner(System.in);
	int n=input.nextInt();//6
	SLL<Integer>list=new SLL<Integer>();//1 3 5 8 9 5

	for(int i=0;i<n;i++) {
		list.insertLast(input.nextInt());
		
	}
	int nPati=input.nextInt();//3
	for(int i=0;i<nPati;i++) {
		int size=list.size();
		int mid=size/2;//3
		SLLNode<Integer>current=list.getFirst();
	for(int j=0;j<mid;j++) {
		current=current.succ;
		
	}
	list.delete(current);
		
	}
	System.out.println(list);

}}
