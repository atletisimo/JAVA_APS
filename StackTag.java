import java.util.*;
import stack_queue.ArrayStack;
import stack_queue.Stack;
public class Tag {
	public static void main(String [] args) {
		Scanner input=new Scanner(System.in);
		
ArrayStack<String>stack=new ArrayStack<String>(100);//создаваме stack кој ќе чува отворени тагови
while(true) {
	String izraz=input.next();
if(izraz.equals("x")) {//ако се внесе х ,циклисот прекинува
	break;
}
if(!izraz.startsWith("end")) {//ако изразот не почнува со end,значи е отворен таг
	stack.push(izraz);//стави го на stack, за подоцна да го споредиме кога ќе дојде отворен таг
}
else {//ако започнува со end значи е затворен таг
	if(stack.isEmpty()) {
		System.out.println("Invalid");
		return;//Ако е празен, немаме соодветен отворен таг → Invalid, завршуваме програмата (return).
	}
	String poslednoOtvoren=stack.pop();
	String ocekuvanZatvaracki="end"+poslednoOtvoren;
	if(!izraz.equals(ocekuvanZatvaracki)) {
		System.out.println("Invalid");
		return;
}
}
}
if(stack.isEmpty()) {
	System.out.println("Valid");
}
else {
	System.out.println("Invalid");
}

	}

}
