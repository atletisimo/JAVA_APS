public class DLLPodeliSamoglaski {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        String linija = input.nextLine();  // Пример: "a b c d e"
        String[] bukvi = linija.split(" ");

        DLL<Character> samoglaski = new DLL<>();
        DLL<Character> soglaski = new DLL<>();
        DLL<Character> vlezna = new DLL<>();

        for (String s : bukvi) {
            char b = s.charAt(0);
            vlezna.insertLast(b);
        }

        DLLNode<Character> start = vlezna.getFirst();
        DLLNode<Character> end = vlezna.getLast();

        while (start != null && end != null && start != end && start != end.succ) {

            char bs = start.element;
            if (isSamoglaska(bs)) samoglaski.insertLast(bs);
            else soglaski.insertLast(bs);

            char be = end.element;
            if (isSamoglaska(be)) samoglaski.insertLast(be);
            else soglaski.insertLast(be);

            start = start.succ;
            end = end.pred;
        }

        // Ако има среден елемент (непарен број елементи)
        if (start == end) {
            char b = start.element;
            if (isSamoglaska(b)) samoglaski.insertLast(b);
            else soglaski.insertLast(b);
        }

        System.out.println(samoglaski);
        System.out.println(soglaski);
    }

    static boolean isSamoglaska(char b) {
        return b == 'a' || b == 'e' || b == 'i' || b == 'o' || b == 'u';
    }
}

