import java.util.*;
public class PalindromeDLL {
	public static void main(String [] args) {
	 boolean isPalindrome=true;
	//vnesuvame br na elementi
	Scanner input=new Scanner(System.in);
	int n=input.nextInt();//6
	DLL<Integer>lista=new DLL<Integer>();
	
for(int i=0;i<n;i++) {
	//vnesuvame elementi vo listata
	lista.insertLast(input.nextInt());	
	}
DLLNode<Integer>jazol1=lista.getFirst();
DLLNode<Integer>jazol2=lista.getLast();

	//proveruvame dali e palindrome
while(jazol1!=null&&jazol2!=null&&jazol1!=jazol2&&jazol2.pred!=jazol1.succ) {
	if(jazol1.element!=jazol2.element) {
		isPalindrome=false;//со equals bidejki koristime Integer t.e objekt e toa ,a
		//vrednost na objecti so equals se sporeduva,primitive se sporeduvaat so == kako na
		//primer int
		break;
	}
	jazol1=jazol1.succ;
	jazol2=jazol2.pred;
}
if(isPalindrome) {
	System.out.println("Listata: " +lista+"  e palindrom");
}
else {
	System.out.println("Listata: " +lista+" ne e palindrom");
}

	}
}
