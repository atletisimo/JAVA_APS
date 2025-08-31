import java.util.*;

public class StackUreduvacTekst {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());//или може само int n=input.nextInt();  input.nextLine();

        ArrayStack<String> stack = new ArrayStack<String>(100);

        for (int i = 0; i < n; i++) {
            String izraz = input.nextLine();
            String[] niza = izraz.split(" ");

            String command = niza[0];

            if (command.equals("TYPE")) {
                if (niza.length > 1) {
                    String bukva = niza[1];
                    stack.push(bukva);
                }
            } else if (command.equals("UNDO")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (command.equals("SHOW")) {
                // покажи целиот текст (не само последниот знак)
                ArrayStack<String> temp = new ArrayStack<String>(100);
                StringBuilder sb = new StringBuilder();

                // префрли во темп стек за да го добиеш редоследот
                while (!stack.isEmpty()) {
                    temp.push(stack.pop());
                }

                while (!temp.isEmpty()) {
                    String c = temp.pop();
                    sb.append(c);
                    stack.push(c); // врати го назад во оригиналниот стек
                }

                System.out.println(sb.toString());
            }
        }
    }
}

