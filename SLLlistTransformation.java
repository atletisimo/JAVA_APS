package listi;
import java.util.*;
public class SLLListTransformation {
public static void main(String [] args) {
	Scanner input=new Scanner(System.in);
	int n=input.nextInt();//14
	SLL<Integer>lista=new SLL<Integer>();
	SLL<Integer>parni=new SLL<Integer>();
	SLL<Integer>neparni=new SLL<Integer>();
	for(int i=0;i<n;i++) {
		lista.insertLast(input.nextInt());
		//1 5 2 3 0 6 4 3 7 9 1 4 6 8
	}
	SLLNode<Integer>jazol=lista.getFirst();
	while(jazol!=null) {
	if(jazol.element%2==0) {
		parni.insertLast(jazol.element);
	}
	else {
		neparni.insertLast(jazol.element);
	}
		jazol=jazol.succ;
	}
	SLLNode<Integer>jazolParen=parni.getFirst();
	SLLNode<Integer>jazolNeparen=neparni.getFirst();
	while(jazolNeparen!=null) {
		if(jazolNeparen.succ==null) {
			System.out.print(jazolNeparen.element);
	}
		else {
			
			System.out.print(jazolNeparen.element+"->");//neparni
		}
		jazolNeparen=jazolNeparen.succ;
	}
	System.out.println();
	while(jazolParen!=null) {
		if(jazolParen.succ==null) {
			System.out.print(jazolParen.element);
			
	}
		else {
			System.out.print(jazolParen.element+"->");//neparni
		}
		jazolParen=jazolParen.succ;
	}


	
}
}
