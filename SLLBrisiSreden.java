package listi;
import java.util.*;
import java.util.Scanner;

public class SLLBrisiSreden {
public static void main(String [] args) {
	 Scanner input = new Scanner(System.in);
     int n = input.nextInt();//8
     SLL<Integer> lista = new SLL<Integer>();
     for (int i = 0; i < n; i++) {
         lista.insertLast(input.nextInt());//3 4 7 6 4 7 3 2
     }
     int brisiN = input.nextInt(); // колку пати да се брише средината //2
     //к циклус 
     // Почнуваме циклус за бришење на средниот јазол 'brisiN' пати
     for(int k=0;k<brisiN;k++) {
    	 int size=lista.size();//// Колку јазли има во листата
    	 if(size==0) break;// Ако листата е празна, прекини го циклусот
    	 
int sredina;
	if(size%2==1) {//ако е непарен
		 // Ако бројот на јазли е непарен, средината е size/2
                // На пример, ако имаме 7 јазли, средината е 3 (нумерирано од 0)
	sredina=size/2;
	}
	else {
		sredina=(size/2)-1;//ако е парен средината ќе биде тој пред него од size-от
	}
	SLLNode<Integer>jazol=lista.getFirst();
	int i=0;
	while(jazol!=null&&i<sredina) {
		jazol=jazol.succ;
		i++;
	}
	        // Ако средниот јазол постои, избриши го
	if(jazol!=null) {
		lista.delete(jazol);
	}
}
SLLNode<Integer>jazol=lista.getFirst();
while (jazol != null) {
    System.out.print(jazol.element + " ");
    jazol = jazol.succ;
}}}

/*
n = 8
Листа: 3 4 7 6 4 7 3 2
brisiN = 2
Итерација 1 (k=0):
size = 8

size е парен, па sredina = (8/2)-1 = 3

Индексирано: 0→3:

0: 3

1: 4

2: 7

3: 6 → среден јазол

Го бришеме јазолот со вредност 6

Новата листа: 3 4 7 4 7 3 2

Итерација 2 (k=1):
size = 7

size е непарен, па sredina = 7/2 = 3 (integer division)

Индексирано: 0→3:

0: 3

1: 4

2: 7

3: 4 → среден јазол

Го бришеме јазолот со вредност 4

Новата листа: 3 4 7 7 3 2
3 4 7 7 3 2



*/




