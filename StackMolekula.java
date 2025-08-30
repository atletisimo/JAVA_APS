import java.util.*;
public class MolekulaVoda {
public static void main(String args[]) {
	Scanner input=new Scanner(System.in);
	ArrayStack<Character>vodorod=new ArrayStack<Character>(100);
	ArrayStack<Character>kislorod=new ArrayStack<Character>(100);
	String elementi=input.nextLine();//HHOHHOHHOHHHHHOHOHOOHOOHHH
	
	int moleculeCount=0;
for(int i=0;i<elementi.length();i++) {
	char atom=elementi.charAt(i);
	if(atom=='H') {
		vodorod.push(atom);
	}else if(atom=='O') {
		kislorod.push(atom);
	}
}
	if(vodorod.size()>=2&&kislorod.size()>=1) {
		vodorod.pop();
		vodorod.pop();
		kislorod.pop();
		moleculeCount++;
	}
	
System.out.println(moleculeCount);
if(!vodorod.isEmpty()) {
	System.out.println("H");
}
if(!kislorod.isEmpty()) {
	System.out.println("O");
}
}
}
