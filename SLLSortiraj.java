import java.util.*;
public class SLLSortiraj {
public static void main(String [] args) {
	Scanner input=new Scanner(System.in);
	int n=input.nextInt();//5
	SLL<Integer>lista=new SLL<Integer>();
	for(int i=0;i<n;i++) {
		lista.insertLast(input.nextInt());//8 4 3 2
	}

for(int i=0;i<n;i++) {
	SLLNode<Integer>current=lista.getFirst();
while(current!=null&&current.succ!=null) {
	
	if(current.element>current.succ.element) {
		int temp=current.element;
		current.element=current.succ.element;
		current.succ.element=temp;// 
	}

	
	current=current.succ;

	
}
}
SLLNode<Integer> tmp = lista.getFirst();
if (tmp == null) {
    System.out.println("Prazna lista");
} else {
    while (tmp != null) {
        System.out.print(tmp.element);
        if (tmp.succ != null) {
            System.out.print("->");
        }
        tmp = tmp.succ;
    }
    System.out.println();
}
}

}
