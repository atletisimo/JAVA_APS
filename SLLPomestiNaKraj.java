package listi;
import java.util.*;
public class SLLPomestiNaKraj {
public static void main(String [] args) {
	Scanner input=new Scanner(System.in);
	int n=input.nextInt();
	input.nextLine();
	SLL<String>lista=new SLL<String>();
	for(int i=0;i<n;i++) {
		lista.insertLast(input.nextLine());
		
	}
	int L=input.nextInt();
	SLLNode<String>jazol=lista.getFirst();

	
for(int i=0;i<n;i++) {
		if(jazol.element.length()==L) {
			
	
		lista.delete(jazol);
		lista.insertLast(jazol.element);
		
		}
			
			
		jazol=jazol.succ;
}
	System.out.print(lista);
}
}

/*

package listi;

import java.util.*;

public class SLLPomestiNaKraj {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine(); // за чистење на новиот ред

        SLL<String> lista = new SLL<>();

        for (int i = 0; i < n; i++) {
            lista.insertLast(input.nextLine());
        }

        int L = input.nextInt();

        SLLNode<String> jazol = lista.getFirst();
        int i = 0;

        while (i < n && jazol != null) {
            SLLNode<String> next = jazol.succ; // зачувај го следниот јазол

            if (jazol.element.length() == L) {
                String value = jazol.element; // зачувај го елементот
                lista.delete(jazol);          // избриши го тековниот јазол
                lista.insertLast(value);      // додади го на крај
            }

            jazol = next; // продолжи со следниот
            i++;
        }

        System.out.println(lista);
    }
}




*/
