public class StackCheckXML {
public static void main(String [] args) {
	Scanner input=new Scanner(System.in);
	int n=input.nextInt();
	//input.nextLine();
	ArrayStack<String>stack=new ArrayStack<String>(100);
	for(int i=0;i<n;i++) {
		String izraz=input.next();
		if(izraz.startsWith("[/")) {
		if(stack.isEmpty())	{
			System.out.println("0");
			return;
		}
		String tagNameEnd=izraz.substring(2,izraz.length()-1);
		if(!stack.pop().equals(tagNameEnd)) {
			System.out.println("0");
			return ;
		}
		
		}
		if(izraz.startsWith("[")) {
		String tagNameStart=izraz.substring(1,izraz.length()-1);
		stack.push(tagNameStart);
		}
		
	}
	if(stack.isEmpty()) {
		System.out.println("1");
	}else {
		System.out.println("0");
	}
	
}
}
