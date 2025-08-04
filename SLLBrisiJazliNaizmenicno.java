package listi;
import java.util.*;

public class SLLBrisiJazliNaizmenicno {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer> lista = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            lista.insertLast(input.nextInt());
        }

        SLLNode<Integer> jazol = lista.getFirst();
        SLLNode<Integer> prev = null;
        int counter = 1;

        while (jazol != null) {
            // Чекор 1: Остави `counter` јазли
            for (int i = 0; i < counter && jazol != null; i++) {
                prev = jazol;
                jazol = jazol.succ;
            }

            // Чекор 2: Избриши следниот (ако постои)
            if (jazol != null) {
                lista.delete(jazol);
                jazol = prev.succ; // продолжи од следниот
            }

            counter++;
        }

        if (lista.getFirst() == null)
            System.out.println("Prazna lista");
        else
            System.out.println(lista);
    }
}
