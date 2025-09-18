import java.util.*;

public class IzbrishiPrvo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // број на елементи
        SLL<Integer> lista = new SLL<>();

        for(int i = 0; i < n; i++) {
            int el = sc.nextInt();
            lista.insertLast(el);
        }

        int todelete = sc.nextInt(); // број кој треба да се избрише (прво појавување)

        SLLNode<Integer> node = lista.getFirst(); // тековен јазол
        SLLNode<Integer> prev = null; // претходен јазол за бришење

        // Циклус за наоѓање прво појавување
        while(node != null) {
            if(node.element == todelete) {
                // Ако е првиот јазол
                if(prev == null) {
                    lista.delete(node);
                } else {
                    prev.succ = node.succ; // Прескокнуваме го node
                }
                break; // веднаш излегуваме бидејќи избришавме прво појавување
            }
            prev = node;       // зачувуваме претходен
            node = node.succ;  // поместуваме се на следниот
        }

        System.out.println(lista.toString()); // печатиме резултат
    }
}
