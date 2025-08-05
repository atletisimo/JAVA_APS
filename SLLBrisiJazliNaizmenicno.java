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
            // Чекор 1: Остави `counter` јазли,Помини counter јазли, т.е. остави ги (не ги бриши).
            for (int i = 0; i < counter && jazol != null; i++) {//Може да се случи jazol да стане null (ако сме дошле до крајот на листата).
//Затоа, пред да направиме нешто со jazol, како на пример lista.delete(jazol);, мораме да провериме дали тој уште постои, за да не добиеме NullPointerException.
                prev = jazol;
                jazol = jazol.succ;
            }

            // Чекор 2: Избриши следниот (ако постои)
            if (jazol != null) {
                lista.delete(jazol);
                //пошто е избришан, jazol не постои повеќе — не можеш да користиш jazol = jazol.succ!
                jazol = prev.succ; // продолжи од следниот
              
//бидејќи prev сè уште е во листата, а следниот по prev е новиот jazol, односно оној после избришаниот.
            }

            counter++;
        }

        if (lista.getFirst() == null)
            System.out.println("Prazna lista");
        else
            System.out.println(lista);
    }
}
//Во еднострана листа немаме покажувач наназад. 
//Кога подоцна ќе треба да избришеме некој јазол, мора да знаеме кој е јазолот пред него, за да ги сврземе остатокот од листата (prev.succ = jazol.succ).
//Првиот while
/*
while (jazol != null)?
Ова е главната while-петља. Таа се користи за да се движиме низ сите елементи од листата. Значи:
Додека има уште јазли за проверка (jazol != null), циклусот продолжува.
Ако jazol е null, тогаш сме на крајот на листата и треба да прекинеме.
n=7
1 → 2 → 3 → 4 → 5 → 6 → 7

// prev = jazol;//1
    jazol = jazol.succ;    // jazol = 2
ако (jazol!=null)
го бришеме,значи 2 ја бришеме
// delete 2
    jazol = prev.succ;           // jazol = 3,сега на претходникот,следеникот ќе биде моменталниот јазол
    1 → 3 → 4 → 5 → 6 → 7


ВТОРА ИТЕРАЦИЈА
for (int i = 0; i < 2 && jazol != null; i++) {
    prev = jazol;          // prev = 3
    jazol = jazol.succ;    // jazol = 4
    ---
    prev = 4
    jazol = 5
}
Сега:

prev = 4

jazol = 5


if (jazol != null) {
    lista.delete(jazol);     // delete 5
    jazol = prev.succ;       // jazol = 6
}
1 → 3 → 4 → 6 → 7

ТРЕТА ИТЕРАЦИЈА 
for (int i = 0; i < 3 && jazol != null; i++) {
    prev = jazol;        // prev = 6
    jazol = jazol.succ;  // jazol = 7
    ---
    prev = 7
    jazol = null
}
Сега сме на крајот.

Edit
if (jazol != null) {   // jazol = null -> не влегува тука
}
🚫 Ништо не се брише.

✅ Финален резултат:
Листата:
1 → 3 → 4 → 6 → 7
*/
