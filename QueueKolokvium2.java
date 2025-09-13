/*
*Се организира прв колоквиум по предметот Алгоритми и структури на податоци. За таа цел 
 *се отвара анкета по предметот на која студентите се пријавуваат. 
Анкетата има дадено 2 избори:
1)	Полагам во било кој термин
2)	Испитот ми се преклопува со Математика
Студентите се поставуваат во термините според редоследите во кои се примени (почнувајќи од
првиот). Сите студенти сакаат да полагаат колку е можно порано па затоа дел од студентите
мамат и во анкетата наведуваат дека истиот ден полагаат и Математика. Асистентите бараат 
список на студенти кои полагаат Математика и добиваат. Потоа се започнува со распределба на
студентите во термини: прво во термините се доделуваат студентите кои се пријавиле дека 
полагаат и Математика (по редоследот по кој се пријавиле), меѓутоа секој од овие студенти
се проверува дали навистина полага и Математика и ако мамел се сместува на крај од 
списокот на студенти кои избрале дека полагаат било кој термин. Потоа се изминуваат 
останатите студенти и се доделуваат во термини.

Влез: Се дава прво капацитетот на студенти по термин (т.е. по колку студенти во еден термин 
може да полагаат). Следно се дава бројот и списокот на студенти кои истиот ден полагаат и 
Математика (според редоследот по кој се пријавиле). Потоа се дава бројот и списокот на 
останатите студенти (според редоследот по кој се пријавиле). На крај се дава број и список
 на студенти кои навистина полагаат Математика. На излез се печати број на термин, па 
 студентите кои полагаат во тој термин.
 
 Sample input
2
4
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
HristinaMihajloska
3
VladimirTrajkovik
SlobodanKalajdziski
AnastasMisev
1
IlinkaIvanoska
Sample output
1
IlinkaIvanoska
VladimirTrajkovik
2
SlobodanKalajdziski
AnastasMisev
3
IgorKulev
MagdalenaKostoska
4
HristinaMihajloska
*/
import java.util.*;
public class QueueKolokvium2 {
	public static void main(String [] args) {
		Scanner input=new Scanner(System.in);
		int kapacitetTermin=input.nextInt();
		int brPrijaveniSoMatematika=input.nextInt();
		input.nextLine();
		LinkedQueue<String>prijaveniMatematika=new LinkedQueue<String>();
		for(int i=0;i<brPrijaveniSoMatematika;i++) {
			prijaveniMatematika.enqueue(input.nextLine());
		}
		int brOstanati=input.nextInt();
		input.nextLine();
		LinkedQueue<String>prijaveniBezMatematika=new LinkedQueue<String>();
		for(int i=0;i<brOstanati;i++) {
			prijaveniBezMatematika.enqueue(input.nextLine());
		}
		int navistinaMatematika=input.nextInt();
		input.nextLine();
		String [] spisokMatematika=new String[navistinaMatematika];
		for(int i=0;i<navistinaMatematika;i++) {
			spisokMatematika[i]=input.nextLine();
		}
		LinkedQueue<String>konecenRaspored=new LinkedQueue<String>();
		
		while(!prijaveniMatematika.isEmpty()) {
			int flag=0;//pretpostavuvame deka ne e prijaven za matematika
			for(int i=0;i<navistinaMatematika;i++) {
				if(prijaveniMatematika.peek().equals(spisokMatematika[i])) {
					flag=1;
					break;
					/*
			 break се користи за да ја прекине for петљата штом најдеме
			  дека студентот е навистина во списокот.

Ако не ставиме break, тогаш for ќе продолжи да проверува и понатаму 
иако веќе сме сигурни дека студентот е на списокот.
break ја прекинува САМО највнатрешната петља → во случајот тоа е for петљата.
Значи, кога ќе најдеме студент во списокот, for веднаш престанува со споредби и излегува од него.

Откако ќе излезе од for, извршувањето продолжува веднаш после for → односно ќе влезе во:
					if(flag==1)
					 */
				}}
				if(flag==1) {//(студентот е во вистинскиот спиcок на Математика):
					konecenRaspored.enqueue(prijaveniMatematika.dequeue());
					//Ги ставаме веднаш кон крајниот распоред
				}
				else {//flag=0,студентот мамел,значи не е во вистинскиот список
					prijaveniBezMatematika.enqueue(prijaveniMatematika.dequeue());
					//Го преместуваме тој студент (кој "мамел" во анкетата) во крајот на редот на студентите кои избрале "било кој термин"
				}}
				/*
			Барањето во spisokMatematika служи да се потврди кои од оние што тврделе дека имаат Математика навистина имаат.
			 Ако не, тие се третираат како „обични“ кандидати (и ги ставаш во групата за било кој термин), но на крајот — по редоследот на пријавување.
				 */	 
				
			
		while(!prijaveniBezMatematika.isEmpty()) {
			konecenRaspored.enqueue(prijaveniBezMatematika.dequeue());
		}
		/*Откако завршивме со проверката на сите кои се пријавиле како „со математика“, 
		 * сега ги додаваме сите во prijaveniBezMatematika
		 * (и оние што почнале таму + тие што беа преместени таму поради мамење) во konechenRaspored.
		 */
		// Печатење по термини
        int term = 1;
        while (!konecenRaspored.isEmpty()) {
            System.out.println(term++);
            for (int j = 0; j < kapacitetTermin && !konecenRaspored.isEmpty(); j++) {
                System.out.println(konecenRaspored.dequeue());
		}
        }}

}
