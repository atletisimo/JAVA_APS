import java.util.*;
interface Queue<E> {
    // Elementi na redicata se objekti od proizvolen tip.
    // Metodi za pristap:
    public boolean isEmpty();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size();
    // Ja vrakja dolzinata na redicata.

    public E peek();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear();
    // Ja prazni redicata.

    public void enqueue(E x);
    // Go dodava x na kraj od redicata.

    public E dequeue();
    // Go otstranuva i vrakja pochetniot element na redicata.
}
class ArrayQueue<E> {
    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Ako length > 0, togash elementite na redicata se zachuvani vo elems[front...rear-1]
    // Ako rear > front, togash vo  elems[front...maxlength-1] i elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    // Konstruktor ...

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size() {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek() {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        // Ja prazni redicata.
        length = 0;
        front = rear = 0;  // arbitrary
    }

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        if (length == elems.length)
            throw new NoSuchElementException();
        elems[rear++] = x;
        if (rear == elems.length) rear = 0;
        length++;
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length) front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}
  

public class QueueKolokviumI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int brAsistenti = input.nextInt();
        input.nextLine(); // прочисти нов ред после бројот

        ArrayQueue<String> asistenti = new ArrayQueue<String>(100);
        for (int i = 0; i < brAsistenti; i++) {
            asistenti.enqueue(input.nextLine());
        }

        int brPredmeti = input.nextInt();
        input.nextLine(); // прочисти нов ред после бројот

        ArrayQueue<String> predmeti = new ArrayQueue<String>(100);
        for (int i = 0; i < brPredmeti; i++) {
            predmeti.enqueue(input.nextLine());
        }

        int brOtsutni = input.nextInt();
        input.nextLine(); // прочисти нов ред

        String[] otsutni = new String[brOtsutni];
        for (int i = 0; i < brOtsutni; i++) {
            otsutni[i] = input.nextLine();
        }

        ArrayQueue<String> finalAsistenti = new ArrayQueue<String>(100);

        // Филтрирање на присутни асистенти
        while (!asistenti.isEmpty()) {
            String current = asistenti.dequeue();
            boolean isOtsuten = false;
            for (int i = 0; i < brOtsutni; i++) {
                if (current.contains(otsutni[i])) {
                    isOtsuten = true;
                    break;
                }
            }
            if (!isOtsuten) {
                finalAsistenti.enqueue(current);
            }
        }

        // Доделување на асистенти по предмети
        while (!predmeti.isEmpty()) {
            String[] razdeliPredmet = predmeti.dequeue().split(" ");
            String imePredmet = razdeliPredmet[0];
            int potrebniAsistenti = Integer.parseInt(razdeliPredmet[1]);

            System.out.println(imePredmet);
            System.out.println(potrebniAsistenti);

            for (int i = 0; i < potrebniAsistenti; i++) {
                if (finalAsistenti.isEmpty()) break; // Ако нема доволно
                System.out.println(finalAsistenti.peek());
                finalAsistenti.enqueue(finalAsistenti.dequeue()); // ротирање
            }
        }
    }
}
