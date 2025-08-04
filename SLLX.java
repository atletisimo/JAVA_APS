package listi;
import java.util.*;
public class SLLX {
	public static void main(String [] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		SLL<Integer>lista=new SLL<Integer>();
		SLL<Integer>pomali=new SLL<Integer>();
		SLL<Integer>pogolemi=new SLL<Integer>();
	
		for(int i=0;i<n;i++) {
			lista.insertLast(input.nextInt());
		}
		int x=input.nextInt();
		SLLNode<Integer>jazol=lista.getFirst();
		while(jazol!=null) {
			if(jazol.element<=x) {
			pomali.insertLast(jazol.element);}
			else {
				pogolemi.insertLast(jazol.element);
			}
			jazol=jazol.succ;	
			}
			

		
	
		if(pomali.getFirst()==null) {//ako listata e prazna
			System.out.println(pogolemi);
			
		}
		else {
			//da go najdeme krajot na pomalite
			SLLNode<Integer>kraj=pomali.getFirst();
			while(kraj.succ!=null) {
				kraj=kraj.succ;
			}
			kraj.succ=pogolemi.getFirst();
		}
		 System.out.println(pomali);
		
			
		}
	}
