import java.util.*;
import java.util.Scanner;

public class MVRBezKlasa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        LinkedQueue<String[]> lichnaRed = new LinkedQueue<>();
        LinkedQueue<String[]> pasoshRed = new LinkedQueue<>();
        LinkedQueue<String[]> vozachkaRed = new LinkedQueue<>();

        for (int i = 0; i < n; i++) {
            String ime = sc.nextLine();
            String licna = sc.nextLine();
            String pasos = sc.nextLine();
            String vozachka = sc.nextLine();

            String[] gragjanin = new String[]{ime, licna, pasos, vozachka};

            if (licna.equals("1")) {
                lichnaRed.enqueue(gragjanin);
            } else if (pasos.equals("1")) {
                pasoshRed.enqueue(gragjanin);
            } else {
                vozachkaRed.enqueue(gragjanin);
            }
        }

        while (!lichnaRed.isEmpty()) {
            String[] g = lichnaRed.dequeue();
            if (g[2].equals("1")) {
                pasoshRed.enqueue(g);
            } else if (g[3].equals("1")) {
                vozachkaRed.enqueue(g);
            } else {
                System.out.println(g[0]);
            }
        }

        while (!pasoshRed.isEmpty()) {
            String[] g = pasoshRed.dequeue();
            if (g[3].equals("1")) {
                vozachkaRed.enqueue(g);
            } else {
                System.out.println(g[0]);
            }
        }

        while (!vozachkaRed.isEmpty()) {
            String[] g = vozachkaRed.dequeue();
            System.out.println(g[0]);
        }
    }
}
