/*
*Се организира колоквиумска недела на ФИНКИ и за таа цел асистентите се доделуваат за 
 *чување на испити. За таа цел се прави редица од асистентите во која на почеток се 
 *nајмладите асистенти, а на крај се највозрасните. Потоа се даваат предметите и по колку
 *асистенти се потребни за чување на секој предмет.Има некои асистенти кои се отсутни 
 *во тековната колоквиумска недела. Затоа дополнително се дава список кои од асистентите
 *се отсутни. Асистентите се доделуваат на следниот начин: Прво се доделуваат најмладите,
 *а на крај најстарите, со тоа што ако некој асистент е отсутен тој се игнорира во редицата.
 *После секое доделување на предмет асистентот се сместува на крај на редицата (т.е. ако на 
 *секој асистент му се доделил за чување предмет, а има потреба од уште асистенти, повторно 
 *се започнува од најмладите).
Влез: Се дава прво бројот на асистенти и имињата на асистентите од најмлад до најстар. 
Следно се дава бројот на предмети за кои се потребни асистенти, па се наведуваат предметите
и по колку асистенти се потребни за секој предмет. Потоа се дава бројот на асистенти кои се
отсутни и списокот на тековно отсутните асистенти. 
На излез се печати предмет, па асистенти задолжени за чување на тој предмет (за секој од дадените предмети).*/
 
/*Sample input
4
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
HristinaMihajloska
3
APS 3
MIS 1
OOS 2
1
HristinaMihajloska
 
Sample output
APS
3
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
MIS
1
IlinkaIvanoska
OOS
2
IgorKulev
MagdalenaKostoska
*/


public class Asistenti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int brAsistenti = Integer.parseInt(sc.nextLine());
        LinkedQueue<String> asistenti = new LinkedQueue<>();

        for (int i = 0; i < brAsistenti; i++) {
            asistenti.enqueue(sc.nextLine());
        }

        int brPredmeti = Integer.parseInt(sc.nextLine());
        LinkedQueue<String> predmeti = new LinkedQueue<>();

        for (int i = 0; i < brPredmeti; i++) {
            predmeti.enqueue(sc.nextLine());
        }

        int brOtsutniProf = Integer.parseInt(sc.nextLine());
        ArrayList<String> otsutniList = new ArrayList<>();

        for (int i = 0; i < brOtsutniProf; i++) {
            otsutniList.add(sc.nextLine());
        }

        LinkedQueue<String> asistentiFinal = new LinkedQueue<>();

        while (!asistenti.isEmpty()) {
            String curr = asistenti.dequeue();
            if (!otsutniList.contains(curr)) {
                asistentiFinal.enqueue(curr);
            }
        }

        while (!predmeti.isEmpty()) {
            String[] razdeliPredmet = predmeti.dequeue().split(" ");
            String imePredmet = razdeliPredmet[0];
            int potrebniAsistenti = Integer.parseInt(razdeliPredmet[1]);

            System.out.println(imePredmet);
            System.out.println(potrebniAsistenti);

            for (int i = 0; i < potrebniAsistenti; i++) {
                System.out.println(asistentiFinal.peek());
                asistentiFinal.enqueue(asistentiFinal.dequeue());
            }
        }

        sc.close();
    }
}
