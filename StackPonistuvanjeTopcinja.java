public class Topcinja {
    public static String ponistiTopcinja(String[] vlez) {
        ArrayStack<String> crveni = new ArrayStack<String>(100);
        ArrayStack<String> zeleni = new ArrayStack<String>(100);
        ArrayStack<String> sini = new ArrayStack<String>(100);

        String izlez = "";
        int n = 0;

        for (int i = 0; i < vlez.length; i++) {
            String s = vlez[i];

            if (s.charAt(0) == 'R') {
                if (!crveni.isEmpty()) {//Ако стекот е празен, crveni.peek() ќе фрли NoSuchElementException (или слична грешка), бидејќи нема елемент на врвот,затоа 
                  //мора да се направи оваа проверка,//bidejki ne mozeme peek() da pravime ako stack-ot e prazen ke frli NoSuchElementException bidejki nema element na vrvot i zatoa mora ovaa proverka da se napravi
                    if (crveni.peek().equals(s))
                        crveni.push(s);
                    else
                        crveni.pop();
                } else crveni.push(s);// Стекот е празен → немаме претходно топче од иста боја → нема што да се поништи → новото топче го додаваме во стекот.
            }//Ако стекот не е празен, тогаш можеме да го споредиме врвното топче со новото:



            if (s.charAt(0) == 'G') {
                if (!zeleni.isEmpty()) {
                    if (zeleni.peek().equals(s))
                        zeleni.push(s);
                    else
                        zeleni.pop();
                } else zeleni.push(s);
            }

            if (s.charAt(0) == 'B') {
                if (!sini.isEmpty()) {
                    if (sini.peek().equals(s))
                        sini.push(s);
                    else
                        sini.pop();
                } else sini.push(s);
            }
        }

        while (!crveni.isEmpty()) {
            n++;
            if (crveni.pop().charAt(1) == '+')
                izlez += "R- ";
            else
                izlez += "R+ ";
        }

        while (!zeleni.isEmpty()) {
            n++;
            if (zeleni.pop().charAt(1) == '+')
                izlez += "G- ";
            else
                izlez += "G+ ";
        }

        while (!sini.isEmpty()) {
            n++;
            if (sini.pop().charAt(1) == '+')
                izlez += "B- ";
            else
                izlez += "B+ ";
        }

        System.out.println(n);
        return izlez;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine(); // чита цел ред
        String[] vlez = line.split(" "); // ги дели топчињата

        System.out.println(ponistiTopcinja(vlez));
    }
}
