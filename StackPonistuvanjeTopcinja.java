import java.util.*;
public class TopcinjaStack {
public static void main(String [] args) {
	Scanner input=new Scanner(System.in);
	String topcinja=input.nextLine();//R+ G- G+ G+ R+ B- B+ R- G+ R- B- B+ B+ R+
	ArrayStack<String>crveni=new ArrayStack<String>(100);
	ArrayStack<String>zeleni=new ArrayStack<String>(100);
	ArrayStack<String>sini=new ArrayStack<String>(100);
	StringBuilder izlez=new StringBuilder();
	String [] t=topcinja.split(" ");//"R+" "G-" "G+" G+ R+ B- B+ R- G+ R- B- B+ B+ R+
	int n=0;
	for(String i:t) {
		 // ПРОВЕРКА: дали стрингот има барем 2 карактери (боја и знак)
//        if (i.length() < 2) {
//            // Игнорирај ако е невалиден внес
//            continue;
//        }
		char boja=i.charAt(0);
		char znak=i.charAt(1);
		ArrayStack<String>stack=null;
	
	if(boja=='R') {
		stack=crveni;
	}
	else if(boja=='G') {
	stack=zeleni;
	
}
	else if (boja=='B') {
		stack=sini;
	}
	if(stack!=null) {
		if(!stack.isEmpty()&&stack.peek().charAt(1)!=znak) {
			stack.pop();
		}
		else {
			stack.push(i);
		}
	}
}
	   while (!crveni.isEmpty()) {
           n++;
           izlez.append(crveni.pop().charAt(1) == '+' ? "R- " : "R+ ");
       }

       while (!zeleni.isEmpty()) {
           n++;
           izlez.append(zeleni.pop().charAt(1) == '+' ? "G- " : "G+ ");
       }

       while (!sini.isEmpty()) {
           n++;
           izlez.append(sini.pop().charAt(1) == '+' ? "B- " : "B+ ");
       }

       // Прво бројот на преостанати топчиња
       System.out.println(n);
       System.out.println(izlez);
   }}
	

