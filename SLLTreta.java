package listi;
import java.util.*;

public class SLLTreta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        SLL<String> lista = new SLL<String>();
        for (int i = 0; i < n; i++) {
            String element = input.nextLine();
            lista.insertLast(element);
        }

        // Промена на секој трет елемент
        SLLNode<String> jazol = lista.getFirst();
        int counter = 1;

        while (jazol != null) {
            if (counter % 3 == 0) {
                String word = jazol.element;
                if (word.length() > 0) {
                    jazol.element = Character.toUpperCase(word.charAt(0)) + word.substring(1);
                }
            }
            jazol = jazol.succ;
            counter++;
        }

        // Печатење во нормален редослед
        jazol = lista.getFirst();
        while (jazol != null) {
            System.out.print(jazol.element + " ");
            jazol = jazol.succ;
        }
        System.out.println();

        // Сега ја менуваме самата листа со mirror()
        lista.mirror();

        // Печатење во обратен редослед
        jazol = lista.getFirst();
        while (jazol != null) {
            System.out.print(jazol.element + " ");
            jazol = jazol.succ;
        }
        System.out.println();
    }
}

