import java.util.*;
public class SLLPalindrome {
public static void main(String [] args) {
	Scanner input=new Scanner(System.in);
	int n=input.nextInt();//6
	SLL<Integer>list=new SLL<Integer>();
	for(int i=0;i<n;i++) {
		list.insertLast(input.nextInt());//1 2 3 2 1
	}
boolean isPalindrome=true;
	SLLNode<Integer>jazol=list.getFirst();
	if(jazol==null) {
		System.out.println("Prazna lista");
		return;}
SLL<Integer>reversedLista=new SLL<Integer>();
while(jazol!=null) {
	reversedLista.insertFirst(jazol.element);
	
	jazol=jazol.succ;
}
jazol=list.getFirst();
SLLNode<Integer>jazol2=reversedLista.getFirst();
while(jazol!=null && jazol2!=null) {
	if(!jazol.element.equals(jazol2.element)) {
	isPalindrome=false;
	break;
}
jazol=jazol.succ;
jazol2=jazol2.succ;

}
if(isPalindrome==true) {
	System.out.println("Listata e palindrom");
}
else {
	System.out.println("Listata ne e palindrom");
}

}}
