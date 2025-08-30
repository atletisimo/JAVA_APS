/*
 * Принтер

Во една компанија постои споделен принтер на кој се пуштаат документи за принтање од повеќе канцеларии.
 Ваша задача е да имплементирате решение кое ќе овозможи додавање
на нов документ за принтање во принтерот, извршување на печатење на 
одреден број на страници, како и приказ на состојбата на документите.

Влез: На влез прво е даден број N- број на команди кои стигнуваат до принтерот. Потоа во секој од редовите може да има една од три команди:

ADD document broj_strani - додава документ за печатење, со одреден број на сраници
PRINT broj_strani - команда до принтерот да испечати одреден број на страници
STATUS - приказ на статусот на секоја страница- дали чека за печатење или е веќе испечатена

Излез: Секоја наредба Status повикува приказ на состојбата на документите, како што е дадено на пример излезот

Пример:
Влез:

10
ADD Dogovor 3
STATUS
ADD Spisok 2
STATUS
PRINT 2
STATUS
PRINT 2
STATUS
PRINT 1
STATUS

 */
import java.util.*;

public class StackPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        Stack<String> names = new Stack<>();
        Stack<Integer> pages = new Stack<>();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            if (parts[0].equals("ADD")) {
                String name = parts[1];
                int numPages = Integer.parseInt(parts[2]);
                names.push(name);
                pages.push(numPages);

            } else if (parts[0].equals("PRINT")) {
                int pagesToPrint = Integer.parseInt(parts[1]);
                Stack<String> tempNames = new Stack<>();
                Stack<Integer> tempPages = new Stack<>();

                // Префрламе во времен stack за да почнеме од најстарите
                while (!names.isEmpty()) {
                    tempNames.push(names.pop());
                    tempPages.push(pages.pop());
                }

                while (!tempNames.isEmpty() && pagesToPrint > 0) {
                    String name = tempNames.pop();
                    int remaining = tempPages.pop();

                    if (remaining <= pagesToPrint) {
                        pagesToPrint -= remaining;
                        remaining = 0;
                    } else {
                        remaining -= pagesToPrint;
                        pagesToPrint = 0;
                    }

                    names.push(name);
                    pages.push(remaining);
                }
            } else if (parts[0].equals("STATUS")) {
                System.out.println("Current status:");

                // Печатење од дното кон врвот за да се задржи редослед
                for (int i = 0; i < names.size(); i++) {
                    String name = names.get(i);
                    int remainingPages = pages.get(i);
                    int totalPages = remainingPages + (pagesToPrinted(names, pages, i));
                    for (int j = 0; j < totalPages; j++) {
                        if (j < totalPages - remainingPages) {
                            System.out.println(name + " printed");
                        } else {
                            System.out.println(name + " waiting");
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    // Помошна функција да се пресмета колку страници се отпечатени за документот на позиција i
    private static int pagesToPrinted(Stack<String> names, Stack<Integer> pages, int index) {
        int total = 0;
        for (int j = 0; j < index; j++) {
            if (names.get(j).equals(names.get(index))) {
                total += pages.get(j);
            }
        }
        return total;
    }
}
