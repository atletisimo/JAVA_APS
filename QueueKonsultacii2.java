/*
*Кај асистентот Игор се одржуваат консултации по два предмети АСП и ММС во еден термин. Бидејќи по
 *АПС колоквиумот е следниот ден, Игор им рекол на студентите кои шточекаат дека прво ќе ги услужи 
 *студентите по АПС, а после студентите по ММС. Студентите се подготвиле со прашања и прашањата за 
 *АПС можат да бидат од тип А, B, C или D.Асистентот им напоменал на студентите по АПС, ако дојде 
 *некој студент и праша прашање од тип X (X e A,B,C или D) и веднаш после него дојде студент со прашање
 *од тип X(т.е. со прашање од ист тип), вториот студент ќе биде ставен на крајот од редот и истовремено
 *ќе биде пуштен еден студент од другата редица за ММС (ако таа редица не е празна). Генерално, ако 
 *последното одговорено прашање по АПС е од тип X, и дојде студент со прашање од тип X, тој се 
 *преместува на крајот од редот и се пушта еден студент од другата редица за ММС (ако таа редица не е празна).
Влез: Се дава прво бројот на студенти кои се пријавиле за консултации АПС, а потоа се наведуваат 
студентите според редоследот на пријавување и се дава за кој тип прашање се пријавиле (A, B, C или D)
Следно се дава бројот на студенти кои се пријавиле за консултации ММС, а потоа се наведуваат студентите
 според редоследот на пријавување. 
 На излез се печатат студентите според редоследот по кој влегле на консултации.
 
  Sample input
3
IlinkaIvanoska A
MagdalenaKostoska A
HristinaMihajloska B
1
IgorKulev
  Sample output
IlinkaIvanoska
IgorKulev
HristinaMihajloska
MagdalenaKostoska
*/
public class Konsultacii {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedQueue<String> prashanjaAPS = new LinkedQueue<>();
        LinkedQueue<String> prashanjaMMC = new LinkedQueue<>();

        int brZaAps = sc.nextInt();
        sc.nextLine(); // да ја фати новата линија
        for (int i = 0; i < brZaAps; i++) {
            prashanjaAPS.enqueue(sc.nextLine());
        }

        int brZaMmc = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < brZaMmc; i++) {
            prashanjaMMC.enqueue(sc.nextLine());
        }

        int brFinal = brZaAps + brZaMmc;
        int flag = 1;//flag = 1 → ред е на студентите од АПС.
        LinkedQueue<String> finalRed = new LinkedQueue<>();//finalRed — редицата во која ги прибираме студентите по редоследот како што влегуваат
        String previousTip = "";//го чува типот на последното одговорено прашање од АПС (A/B/C/D). Почетно е "" (празен) затоа што пред старт немало претходно прашање.

        for (int i = 0; i < brFinal; i++) {
            if (((flag == 1) || prashanjaMMC.isEmpty()) && (!prashanjaAPS.isEmpty())) {
                String[] parts = prashanjaAPS.peek().split(" ");//гледаме (без да ја тргнеме) првата ставка во редот на АПС.
                String name = parts[0];
                String tip = parts[1];
                if (previousTip.equals(tip) && (!prashanjaMMC.isEmpty())) {//Ова проверува дали типот на ова прашање е ИСТ како типот на последно одговореното прашање и дали има барем еден студент во ММС.
                    prashanjaAPS.enqueue(prashanjaAPS.dequeue());
                    flag = 0;//flag = 0 → ред е на студентите од ММС.
                    previousTip = tip;
                } else {
                    finalRed.enqueue(name);
                    prashanjaAPS.dequeue();
                    previousTip = tip;
                }
            }
            if (((flag == 0) || prashanjaAPS.isEmpty()) && !prashanjaMMC.isEmpty()) {
                finalRed.enqueue(prashanjaMMC.dequeue());
                flag = 1;
            }
        }

        int var = finalRed.length;
        for (int i = 0; i < var; i++) {
            System.out.println(finalRed.dequeue());
        }
    }
}
