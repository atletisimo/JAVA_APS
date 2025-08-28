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
