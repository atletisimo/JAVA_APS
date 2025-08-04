package listi;
import java.util.*;
public class SLLSoberiElementi {
public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	StringBuilder sb1=new StringBuilder();
	StringBuilder sb2=new StringBuilder();
	int n=input.nextInt();
	SLL<Integer>list1=new SLL<Integer>();
	SLL<Integer>list2=new SLL<Integer>();
	for(int i=0;i<n;i++) {
	list1.insertLast(input.nextInt());	
	}
	for(int i=0;i<n;i++) {
		list2.insertLast(input.nextInt());	
		}
	
	SLLNode<Integer>jazol1=list1.getFirst();
	SLLNode<Integer>jazol2=list2.getFirst();
	while(jazol1!=null) {
	sb1.append(jazol1.element);
	jazol1=jazol1.succ;
}
	
	while(jazol2!=null) {
		sb2.append(jazol2.element);
		jazol2=jazol2.succ;
	}

String br1=sb1.toString();
String br2=sb2.toString();
int num1=Integer.parseInt(br1);
int num2=Integer.parseInt(br2);
int sum=num1+num2;
System.out.println(sum);


}}
