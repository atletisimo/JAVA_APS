public class StackDvojniZagradi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String izraz = scanner.nextLine();//((a+(b)))+(c+d)


        ArrayStack<Character> stack = new ArrayStack<Character>(100);
        boolean dupli = false;//pretpostavuvame deka nemame najdeno dupli

        for (int i = 0; i < izraz.length(); i++) {
            char c = izraz.charAt(i);

            if (c == ')') {//ние гледаме во изразот дали имаме ) ако имаме 
            	//затворена заграда треба да провериме соодветен случај
                int count = 0;//го иницијализираме секогаш на 0 кога ќе наидеме на )
                //за да провериме дали меѓу неа има број,знак или отоврена заграда

                // Вади сè додека не најде отворена заграда
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();//ако стекот не е празен и не е ) вади го од стек
                    count++;//count се зголемува ако вадиме од стек 
                    //нешто што не е (
                }

                if (!stack.isEmpty()) {
                    stack.pop(); // ја вади '('
                }

                // Ако нема ништо меѓу заградите, значи дупли загради
                if (count == 0) {
                    dupli = true;
                    break;
                }
            } else {
                stack.push(c); // стави буква, знак, или '('
            }
        }

        if (dupli) {
            System.out.println("Najdeni se dupli zagradi");
        } else {
            System.out.println("/");
        }
    }
}
