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
            //count < n — итерираме само низ оригиналните n елементи, дури и ако додадеме нови на крај. Ова е многу важно за да не се вратиме на елементите што сме ги преместиле.
            SLLNode<String> next = jazol.succ;
            char firstChar = jazol.element.charAt(0);

            if (Character.isUpperCase(firstChar)) {
                lista.insertLast(jazol.element);
                if (prev == null) {//Овој услов проверува дали тековниот јазол (jazol) што го гледаме е првиот елемент во листата.
                    lista.deleteFirst();
                } else {
                    lista.delete(jazol);
                    /*

ко сакаме да го избришеме првиот јазол

lista.delete(jazol) – ако сакаме да избришеме било кој друг јазол

Но, ако се обидеш да повикаш lista.delete(jazol) за првиот јазол без да го знаеш претходниот, нема да знаеш како да го откачиш од листата.

Затоа се користи if (prev == null) – да се детектира ако тековниот јазол е прв во листата, и тогаш да се повика deleteFirst() наместо обичното delete(jazol).

                    */
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
