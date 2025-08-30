
import java.util.*;
public class StackMolekulaNaVoda {
public static void main(String [] args) {
	Scanner input=new Scanner(System.in);
	ArrayStack<String>vodorod=new ArrayStack<String>(100);
	ArrayStack<String>kislorod=new ArrayStack<String>(100);
	String molekuli=input.nextLine();//"HHOHHOHHOHHHHHOHOHOOHOOHHH"
	int molekulaCount=0;
	
for(int i=0;i<molekuli.length();i++) {
	char atom=molekuli.charAt(i);
	if(atom=='H') {
		vodorod.push("H");
	}
	else if(atom=='O') {
		kislorod.push("O");
	}
}
//Откако стековите се наполнети
while(vodorod.size()>=2&&kislorod.size()>=1) {
	vodorod.pop();
	vodorod.pop();
	kislorod.pop();//една молекула е веќе формирана,откако се извадени 2 атоми
	//на водород и еден на кислород т.е H2O
	molekulaCount++;
}
//колку такви молекули се креирале и колку останале несврзани
System.out.println(molekulaCount);
if(!vodorod.isEmpty()) {
	System.out.println("H");
}
if(!kislorod.isEmpty()) {
	System.out.println("O");
}
}
}
