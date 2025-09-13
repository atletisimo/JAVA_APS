import java.util.*;

public class QueueKolokvium2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int kapacitetTermin = input.nextInt();
        int brPrijaveniSoMatematika = input.nextInt();
        input.nextLine();

        LinkedQueue<String> prijaveniMatematika = new LinkedQueue<>();
        for (int i = 0; i < brPrijaveniSoMatematika; i++) {
            prijaveniMatematika.enqueue(input.nextLine());
        }

        int brOstanati = input.nextInt();
        input.nextLine();

        LinkedQueue<String> prijaveniBezMatematika = new LinkedQueue<>();
        for (int i = 0; i < brOstanati; i++) {
            prijaveniBezMatematika.enqueue(input.nextLine());
        }

        int navistinaMatematika = input.nextInt();
        input.nextLine();

        // Наместо String[], користиме ArrayList
        ArrayList<String> spisokMatematika = new ArrayList<>();
        for (int i = 0; i < navistinaMatematika; i++) {
            spisokMatematika.add(input.nextLine());
        }

        LinkedQueue<String> konecenRaspored = new LinkedQueue<>();

        // Прво ги проверуваме студентите што кажале дека имаат Математика
        while (!prijaveniMatematika.isEmpty()) {
            String student = prijaveniMatematika.dequeue();

            if (spisokMatematika.contains(student)) {
                // студентот навистина има Математика
                konecenRaspored.enqueue(student);
            } else {
                // студентот мамел → оди кај „било кој термин“
                prijaveniBezMatematika.enqueue(student);
            }
        }

        // Сите останати студенти (вистински без математика + мамачи)
        while (!prijaveniBezMatematika.isEmpty()) {
            konecenRaspored.enqueue(prijaveniBezMatematika.dequeue());
        }

        // Печатење по термини
        int term = 1;
        while (!konecenRaspored.isEmpty()) {
            System.out.println(term++);
            for (int j = 0; j < kapacitetTermin && !konecenRaspored.isEmpty(); j++) {
                System.out.println(konecenRaspored.dequeue());
            }
        }
    }
}

