/*Пред да започне колоквиумската недела на ФИНКИ се организираат консултации по предметот Алгоритми 
 *и структури на податоци. Бидејќи има голем број на заинтересирани студенти за консултации се 
 *објавува анкета на курсот за да се пријават студентите и тоа има два избора на анкетата (може да се изберат и двата): 
1)	Имам кратки прашања
2)	Ми треба објаснување за некои задачи
3)	И кратки прашања и објаснување за задачи
Асистентката Магдалена ги држи консултациите. Студентите се примаат на консултации според следниот 
редослед: прво се примаат по еден студент од оние кои имаат кратки прашања според редоследот по кој
се пријавиле. Ако нема еден од овие се пушта студенти кои кои имаат прашања и за задачи за да се 
исполни квотата од 1 студент,ама од овој прашува само кратки прашања. Ако се пуштил студент кој има
и прашања за задачи тој се преместува на крај на редицата за задачи. Откако ќе се заврши овој 
студент со кратки прашања, се продолжува со оние кои имаат нејасни задачи. Од овие студенти се 
примаат 1. Ако нема еден од овие се пушта студент кој има прашања и за задачи за да се исполни 
квотата од 1 студент за задачи, ама овој прашува само за задачи, и потоа се преместува на крајот 
на редицата за кратки прашања. Понатаму се продолжува на истиот начин со тоа што за студентите кои
се пријавиле и за задачи и за прашања влегуваат откако ќе се испразни редот со само кратки прашања 
или само со задачи. Студентите кои се пријавиле и за прашања и задачи, откако ќе завршат со прашањата
се преместуваат на крај на редицата за задачи, и обратно. Кој ќе биде конечниот редослед на влегување? 
Влез: Се дава прво бројот на студенти кои се пријавиле за кратки прашања, а потоа се наведуваат 
студентите според редоследот на пријавување за кратки прашања, потоа истото за студентите кои се 
пријавиле само за задачи,па на крај студентите кои се пријавиле и за двете. На излез се печатат 
студентите според редоследот по кој влегле на консултации.
Sample input
4
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
HristinaMihajloska
2
AnastasMishev
VladimirTrajkovik
1
SlobodanKalajdziski
Sample output
IlinkaIvanoska
AnastasMishev
IgorKulev
VladimirTrajkovik
MagdalenaKostoska
SlobodanKalajdziski
HristinaMihajloska
SlobodanKalajdziski
*/


import java.util.*;
public class Konsultacii {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int brZaKratkiPrashanja = sc.nextInt();
        sc.nextLine(); // да ја потроши новата линија
        LinkedQueue<String> zaKratkiPrashanja = new LinkedQueue<>();

        for (int i = 0; i < brZaKratkiPrashanja; i++) {
            zaKratkiPrashanja.enqueue(sc.nextLine());
        }

        int brZaZadachi = sc.nextInt();
        sc.nextLine();
        LinkedQueue<String> zaZadachi = new LinkedQueue<>();

        for (int i = 0; i < brZaZadachi; i++) {
            zaZadachi.enqueue(sc.nextLine());
        }

        int brZaDvete = sc.nextInt();
        sc.nextLine();
        LinkedQueue<String> zaDvete = new LinkedQueue<>();

        for (int i = 0; i < brZaDvete; i++) {
            zaDvete.enqueue(sc.nextLine());
        }

        // ги распоредуваме оние за двете во двете редици
        for (int i = 0; i < brZaDvete; i++) {
            String value = zaDvete.dequeue();
            zaKratkiPrashanja.enqueue(value);
            zaZadachi.enqueue(value);
        }

        LinkedQueue<String> finalRed = new LinkedQueue<>();
        int flag = 1;
        int var = zaKratkiPrashanja.length + zaZadachi.length;

        for (int i = 0; i < var; i++) {
            if (((flag == 1) || zaZadachi.isEmpty()) && !zaKratkiPrashanja.isEmpty()) {
                finalRed.enqueue(zaKratkiPrashanja.dequeue());
                flag = 0;
            }
            if (((flag == 0) || zaKratkiPrashanja.isEmpty()) && !zaZadachi.isEmpty()) {
                finalRed.enqueue(zaZadachi.dequeue());
                flag = 1;
            }
        }

        int finalInt = finalRed.length;
        for (int i = 0; i < finalInt; i++) {
            System.out.println(finalRed.dequeue());
        }
    }
}
