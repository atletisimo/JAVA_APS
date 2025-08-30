import java.util.*;
public class StackTancoviDvojki {
public static void main(String [] args) {
	Scanner input=new Scanner(System.in);
	String vlez=input.nextLine();
	ArrayStack<String>maleL=new ArrayStack<String>(100);
	ArrayStack<String>femaleL=new ArrayStack<String>(100);
	ArrayStack<String>maleO=new ArrayStack<String>(100);
	ArrayStack<String>femaleO=new ArrayStack<String>(100);
	ArrayStack<String>maleS=new ArrayStack<String>(100);
	ArrayStack<String>femaleS=new ArrayStack<String>(100);
	
	List<String>pairs=new ArrayList<String>();//List е интерфејс во Java кој претставува редица на елементи
	for(int i=0;i<vlez.length();i+=2) {
		String group=String.valueOf(vlez.charAt(i));
		String gender=String.valueOf(i+1);
	
	if(group.equals("L")) {

		if(gender.equals("M")) {
			if(!femaleL.isEmpty()) {//Ако има слободна женска (!femaleL.isEmpty()), се вади (со pop()) и се прави двојка → pairs.add(...).
				String partner=femaleL.pop();
				pairs.add("(" + partner+ ","+ group+"Z)");
			}
			else {
				maleL.push(group+"M");//Ако нема женска, машкото се чува на стекот maleL (чека партнер).
			}
		}else { // женско,ако е женско (Z):
		    if (!maleL.isEmpty()) {//Ако има слободно машко (!maleL.isEmpty()), се вади и се прави двојка.
		        String partner = maleL.pop();
		        pairs.add("(" + partner + "," + group + "Z)");
		    } else {
		        femaleL.push(group + "Z");//Ако нема машко, женското оди во femaleL (чека партнер).
		    }
		}
	}
	else if (group.equals("S")) {
        if (gender.equals("M")) {
            if (!femaleS.isEmpty()) {
                String partner = femaleS.pop();
                pairs.add("(" + group + "M," + partner + ")");
            } else {
                maleS.push(group + "M");
            }
        } else {
            if (!maleS.isEmpty()) {
                String partner = maleS.pop();
                pairs.add("(" + partner + "," + group + "Z)");
            } else {
                femaleS.push(group + "Z");
            }
        }
    } else if (group.equals("O")) {
        if (gender.equals("M")) {
            if (!femaleO.isEmpty()) {
                String partner = femaleO.pop();
                pairs.add("(" + group + "M," + partner + ")");
            } else {
                maleO.push(group + "M");
            }
        }
        else {
            if (!maleO.isEmpty()) {
                String partner = maleO.pop();
                pairs.add("(" + partner + "," + group + "Z)");
            } else {
                femaleO.push(group + "Z");
            }
        }
    }
}
	

    // Испис на бројот на парови
    System.out.println(pairs.size());
    // Испис на самите парови
    for (String pair : pairs) {
        System.out.println(pair);
    }

    // Испис на оние што останале без партнер (по услов во примерот)
    printRemaining("L", maleL, femaleL);
    printRemaining("S", maleS, femaleS);
    printRemaining("O", maleO, femaleO);
}

private static void printRemaining(String group, Stack<String> male, Stack<String> female) {
    while (!male.isEmpty()) {
        System.out.println(male.pop());
    }
    while (!female.isEmpty()) {
        System.out.println(female.pop());
    }
}
}
