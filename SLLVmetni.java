package listi;
import java.util.*;
public class SLLVmetni {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL<Integer> lista = new SLL<>();

        // Вчитување на листата
        while (input.hasNextInt()) {
            lista.insertLast(input.nextInt());
        }

        SLLNode<Integer> jazol1 = lista.getFirst();

        while (jazol1 != null) {
            if (jazol1.element % 2 == 0) { // ако i е парен
                SLLNode<Integer> jazol2 = jazol1.succ;
                while (jazol2 != null && jazol2.element % 2 != 0) {
                    jazol2 = jazol2.succ; // барај следен парен
                }
                if (jazol2 != null) {
                    jazol1.element = jazol1.element + jazol2.element;
                    lista.delete(jazol2);
                }
            } else { // ако i е непарен
                SLLNode<Integer> jazol2 = jazol1.succ;
                while (jazol2 != null && jazol2.element % 2 == 0) {
                	jazol2 = jazol2.succ; // барај следен непарен
                }
                if (jazol2 != null) {
                    jazol1.element = jazol1.element - jazol2.element;
                    lista.delete(jazol2);
                }
            }
            jazol1 = jazol1.succ;
        }

        System.out.println(lista);
    }
}
