package ispit_august;
import java.util.*;

public class StackTopcinja {
public static void main(String [] args) {
	ArrayStack<String>crveni=new ArrayStack<String>(100);
	ArrayStack<String> zeleni=new ArrayStack<String>(100);
	ArrayStack<String>sini=new ArrayStack<String>(100);
	Scanner input=new Scanner(System.in);
	String topcinja=input.nextLine();//R+ G- G+ G+ R+ B- B+ R- G+ R- B- B+ B+ R+
	StringBuilder izlez=new StringBuilder();
	String [] t=topcinja.split(" ");//"R+" "G-" "G+" "G+" "R+" B- B+ R- G+ R- B- B+ B+ R+
	int n=0;
	for(String i:t) {
		 // ПРОВЕРКА: дали стрингот има барем 2 карактери (боја и знак)
//		if(i.length()<2) {//игнорирај ако е невалиден влез
//			continue;
//		}
		char boja=i.charAt(0);
		char znak=i.charAt(1);
		
		//ЛОГИКА ЗА ЦРВЕНИ
		if(boja=='R') {
			if(!crveni.isEmpty()&&crveni.peek().charAt(1)!=znak) {//ако стекот crveni не 
				//е празен и кога ѕиркаме на врвот од стекот не е исто со знакот т.е се
				//знаците споротивни 
				crveni.pop();
				
			}
			else {
				crveni.push(i);
			}
			
		}
		
		//ЛОГИКА ЗА ЗЕЛЕНИ
		if(boja=='G') {
			if(!zeleni.isEmpty()&&zeleni.peek().charAt(1)!=znak) {//ако стекот zeleni не 
				//е празен и кога ѕиркаме на врвот од стекот не е исто со знакот т.е се
				//знаците споротивни 
				zeleni.pop();
				
			}
			else {
				zeleni.push(i);
			}
			
		}
		
		// ЛОГИКА ЗА СИНИ
		if(boja=='B') {
			if(!sini.isEmpty()&&sini.peek().charAt(1)!=znak) {//ако стекот sini не 
				//е празен и кога ѕиркаме на врвот од стекот не е исто со знакот т.е се
				//знаците споротивни 
				sini.pop();
				
			}
			else {
				sini.push(i);
			}
			
		}

}
	while(!crveni.isEmpty()) {
		n++;
		izlez.append(crveni.pop()+" ");
	}
	while(!sini.isEmpty()) {
		n++;
	izlez.append(sini.pop()+" ");
	
}
while(!zeleni.isEmpty()) {
	n++;
	izlez.append(zeleni.pop()+" ");
}
System.out.println(n);
System.out.println(izlez);
}


}
