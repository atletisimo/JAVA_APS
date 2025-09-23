Разликата меѓу == и .equals() во Java:
1. ==

Проверува дали двете референци покажуваат на ист објект во меморија.

Односно, дали се истата инстанца.

Кај примитивни типови (int, char, double …) тоа е проверка на вредност (зашто тие не се објекти).
Пример:

int a = 5, b = 5;
System.out.println(a == b); // true (вредностите се исти)

Integer x = new Integer(5);
Integer y = new Integer(5);
System.out.println(x == y); // false (различни објекти во меморија)

2. .equals()

Метод што проверува логичка еднаквост (дали вредностите се исти).

Подразбираш дека класата има имплементирано equals() (на пример String, Integer, Double …).
Пример:

Integer x = new Integer(5);
Integer y = new Integer(5);
System.out.println(x.equals(y)); // true (вредностите се исти)
