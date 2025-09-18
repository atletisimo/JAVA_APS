import java.util.*;

public class IzbrishiPosleden {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1️⃣ Читање на бројот на елементи во листата
        int n = sc.nextInt();

        // 2️⃣ Креирање на празна еднонасочна листа
        SLL<Integer> lista = new SLL<Integer>();

        // 3️⃣ Читање на сите елементи и додавање на крај на листата
        for(int i = 0; i < n; i++) {
            int el = sc.nextInt();
            lista.insertLast(el);
        }

        // 4️⃣ Читање на бројот кој треба да се избрише (последното појавување)
        int todelete = sc.nextInt();

        // 5️⃣ Помошен покажувач за обиколување на листата
        SLLNode<Integer> node = lista.getFirst();

        // 6️⃣ Помошен јазол за зачувување на последниот јазол кој треба да се избрише
        SLLNode<Integer> brisi = null;

        // 7️⃣ Циклус за наоѓање на последното појавување на бројот
        while(node != null) {
            if(node.element == todelete) {
                // Ако тековниот јазол има вредност todelete
                // го зачувуваме во brisi. Ако има повеќе појавувања, секое ја заменува претходната
                brisi = node;
            }
            // Поместуваме се на следниот јазол
            node = node.succ;
        }

        // 8️⃣ Ако најдовме јазол за бришење, го повикуваме delete
        if(brisi != null) {
            lista.delete(brisi);
        }

        // 9️⃣ Испечатување на резултантната листа
        System.out.println(lista.toString());
    }
}
