public class PalindromeDLLChar {
	public static void main(String [] args) {
	Scanner input=new Scanner(System.in);
	boolean isPalindrome=true;
	//citame broj na elementi
	int n=input.nextInt();//5
	input.nextLine();
	DLL<Character>lista=new DLL<Character>();
	//vnesuvame elementi na listata
	for(int i=0;i<n;i++) {
		lista.insertLast(input.next().charAt(0));
    /*
charAt(0)
next() враќа String, но сакаме да внесеме Character, не String.
charAt(0) ја зема првата буква (карактер) од String-от.
String s = "a";
char c = s.charAt(0);  // c = 'a'
    */
	}
	//krairanje jazli t.e nodes
DLLNode<Character>jazol1=lista.getFirst();
DLLNode<Character>jazol2=lista.getLast();

	//proveruvame dali e palindrom
while(jazol1!=null&&jazol2!=null&&jazol1!=jazol2&&jazol1!=jazol2.pred) {
	if(jazol1.element!=jazol2.element) {
		isPalindrome=false;
		break;
	}
	jazol1=jazol1.succ;
	jazol2=jazol2.pred;
}
	if(isPalindrome) {
		System.out.println("Listata: " +lista+" e palindrom");
	}
	else {
		System.out.println("Listata: " +lista+" ne e palindrom");
	}
}
}
