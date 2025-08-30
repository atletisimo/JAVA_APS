import java.util.*;
public class TancoviDvojki {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        LinkedStack<String> maleL = new LinkedStack<String>();
        LinkedStack<String>femaleL =new LinkedStack<String>();
        LinkedStack<String> maleS = new LinkedStack<String>();
        LinkedStack<String> femaleS = new LinkedStack<String>();
        LinkedStack<String> maleO = new LinkedStack<String>();
        LinkedStack<String> femaleO = new LinkedStack<String>();

        List<String> pairs = new ArrayList<String>();

        for (int i = 0; i < input.length(); i += 2) {
            String group = String.valueOf(input.charAt(i));//ili so konkatenacija,za da pretvoram char vo String
            // L, S, O
            String gender = input.charAt(i + 1) + ""; // M или Z

            if (group.equals("L")) {
                if (gender.equals("M")) {
                    if (!femaleL.isEmpty()) {
                        String partner = femaleL.pop();
                        pairs.add("(" + group + "M," + partner + ")");
                    } else {
                        maleL.push(group + "M");
                    }
                } else {
                    if (!maleL.isEmpty()) {
                        String partner = maleL.pop();
                        pairs.add("(" + partner + "," + group + "Z)");
                    } else {
                        femaleL.push(group + "Z");
                    }
                }
            } else if (group.equals("S")) {
                if (gender.equals("M")) {
                    if (!femaleS.isEmpty()) {
                        String partner = femaleS.pop();
                        pairs.add("(" + group + "M," + partner + ")");
                    } else {
                        maleS.push(group + "M");
                    }
                } else {
                    if (!maleS.isEmpty()) {
                        String partner = maleS.pop();
                        pairs.add("(" + partner + "," + group + "Z)");
                    } else {
                        femaleS.push(group + "Z");
                    }
                }
            } else if (group.equals("O")) {
                if (gender.equals("M")) {
                    if (!femaleO.isEmpty()) {
                        String partner = femaleO.pop();
                        pairs.add("(" + group + "M," + partner + ")");
                    } else {
                        maleO.push(group + "M");
                    }
                } else {
                    if (!maleO.isEmpty()) {
                        String partner = maleO.pop();
                        pairs.add("(" + partner + "," + group + "Z)");
                    } else {
                        femaleO.push(group + "Z");
                    }
                }
            }
        }

        // Испис на бројот на парови
        System.out.println(pairs.size());
        // Испис на самите парови
        for (String pair : pairs) {
            System.out.println(pair);
        }

        // Испис на оние што останале без партнер (по услов во примерот)
        printRemaining("L", maleL, femaleL);
        printRemaining("S", maleS, femaleS);
        printRemaining("O", maleO, femaleO);
    }

    private static void printRemaining(String group, Stack<String> male, Stack<String> female) {
        while (!male.isEmpty()) {
            System.out.println(male.pop());
        }
        while (!female.isEmpty()) {
            System.out.println(female.pop());
        }
    }
}
