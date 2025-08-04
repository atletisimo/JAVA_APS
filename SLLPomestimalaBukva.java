package listi;

import java.util.Scanner;

public class SLLPomestimalaBukva {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine(); // важно!

        SLL<String> lista = new SLL<>();

        for (int i = 0; i < n; i++) {
            lista.insertLast(input.nextLine());
        }

        SLLNode<String> jazol = lista.getFirst();
        SLLNode<String> prev = null;
        int count = 0;

        while (jazol != null && count < n) {
            SLLNode<String> next = jazol.succ;
            char firstChar = jazol.element.charAt(0);

            if (Character.isUpperCase(firstChar)) {
                lista.insertLast(jazol.element);
                if (prev == null) {
                    lista.deleteFirst();
                } else {
                    lista.delete(jazol);
                }
            } else {
                prev = jazol;
            }

            jazol = next;
            count++;
        }

        System.out.println(lista);
    }
}
