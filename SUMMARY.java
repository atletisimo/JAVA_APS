SLL ЛИСТИ

(SLL<Integer>) користи објект од тип Integer, а не примитивен тип int.
  Integer temp = jazol.element;
  jazol.element е од тип Integer (бидејќи листата е SLL<Integer>),затоа најприродно е да го сместиш во променлива Integer.
    
 Ако напишеме int temp = jazol.element; ?
Тогаш Java ќе направи unboxing (автоматска конверзија) од Integer во int.
Пример:

Integer x = 5;
int y = x;  // автоматски се претвора во int
Ова е дозволено и ќе работи во твојот код.Значи, двете варијанти ќе функционираат.Но проблем е ако jazol.element == null, ќе добиеш NullPointerException,затоа е побезбедно да остане како Integer

STRINGS vs STRINGBUILDER
  Во Java, String е immutable (непроменлив).
Тоа значи дека секојпат кога ќе „додадеш“ нешто на еден String, всушност се креира нов објект во меморија.

  пр:String s = "";
s = s + "A"; // креира нов String
s = s + "B"; // пак креира нов String
s = s + "C"; // пак креира нов String

StringBuilder е mutable (променлив).
Значи, кога користиш append(), тој ја менува внатрешната низа на карактери без да креира нов објект секојпат.

StringBuilder sb = new StringBuilder();
sb.append("A");
sb.append("B");
sb.append("C");
System.out.println(sb.toString()); // ABC

Ако користме обичен String, секој + би создавала нова копија → неефикасно.
Со StringBuilder → сè се собира во еден ист објект и на крај само се печати

  Со StringBuilder:

System.out.println(izlez);

Со обичен String, ќе мора:

String izlez = "";
izlez = izlez + "R- ";
izlez = izlez + "G+ ";


ENHANCED FOR LOOP=FOR EACH
  for (String i : t) {
    ...
}
Се користи кога сакаш да поминеш низ сите елементи од една колекција (array, листа, сет, …).

  пр:String[] t = {"R+", "G-", "G+", "B-"};

for (String i : t) {//t е низата,i е тековниот елемент од таа низа
    System.out.println(i);//Петљата автоматски оди еден по еден низ сите елементи.
}

КЛАСИЧЕН FOR LOOP
  for (int i = 0; i< t.length; i++) {
    String a = t[i];  // земаме елемент по индекс
    System.out.println(a);
}

Разликата

for-each (for (String i : t))

Не мораш сам да работиш со индекс (i).

Не можеш директно да го менуваш индексот или да скокаш преку елементи.

класичен for (for (int j = 0; j < t.length; j++))

Повеќе контрола (можеш да скокнеш некои елементи, да одиш наназад, да користиш i за повеќе намени).

Повеќе код за пишување.

