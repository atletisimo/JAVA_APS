package listi;
import java.util.*;
import java.util.Scanner;

public class SLLBrisiSreden {
public static void main(String [] args) {
	 Scanner input = new Scanner(System.in);
     int n = input.nextInt();//8
     SLL<Integer> lista = new SLL<Integer>();
     for (int i = 0; i < n; i++) {
         lista.insertLast(input.nextInt());//3 4 7 6 4 7 3 2
     }
     int brisiN = input.nextInt(); // колку пати да се брише средината //2
     //к циклус 
     
     for(int k=0;k<brisiN;k++) {
    	 int size=lista.size();
    	 if(size==0) break;
    	 
int sredina;
	if(size%2==1) {//ако е непарен
	sredina=size/2;
	}
	else {
		sredina=(size/2)-1;//ако е парен средината ќе биде тој пред него од size-от
	}
	SLLNode<Integer>jazol=lista.getFirst();
	int i=0;
	while(jazol!=null&&i<sredina) {
		jazol=jazol.succ;
		i++;
	}
	if(jazol!=null) {
		lista.delete(jazol);
	}
}
SLLNode<Integer>jazol=lista.getFirst();
while (jazol != null) {
    System.out.print(jazol.element + " ");
    jazol = jazol.succ;
}}}
