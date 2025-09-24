import java.util.*;


class Gragjanin {
    private String ime;
    private int licnaKarta;
    private int pasos;
    private int vozachka;

    public Gragjanin(String ime, int licnaKarta, int pasos, int vozachka) {
        this.ime = ime;
        this.licnaKarta = licnaKarta;
        this.pasos = pasos;
        this.vozachka = vozachka;
    }

    public int getLicnaKarta() {
        return licnaKarta;
    }

    public int getPasos() {
        return pasos;
    }

    public int getVozachka() {
        return vozachka;
    }

    public String getIme() {
        return ime;
    }
}


public class MVR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // потрошете ја новата линија

        LinkedQueue<Gragjanin> lichnaRed = new LinkedQueue<>();
        LinkedQueue<Gragjanin> pasoshRed = new LinkedQueue<>();
        LinkedQueue<Gragjanin> vozachkaRed = new LinkedQueue<>();

        for (int i = 0; i < n; i++) {
            String ime = scanner.nextLine();
            int licna = scanner.nextInt();
            int pasos = scanner.nextInt();
            int vozachka = scanner.nextInt();
            scanner.nextLine(); // потрошете ја новата линија

            Gragjanin g = new Gragjanin(ime, licna, pasos, vozachka);

            if (g.getLicnaKarta() == 1) {
                lichnaRed.enqueue(g);
            } else if (g.getPasos() == 1) {
                pasoshRed.enqueue(g);
            } else {
                vozachkaRed.enqueue(g);
            }
        }

        while (!lichnaRed.isEmpty()) {
            Gragjanin g = lichnaRed.dequeue();
            if (g.getPasos() == 1) {
                pasoshRed.enqueue(g);
            } else if (g.getVozachka() == 1) {
                vozachkaRed.enqueue(g);
            } else {
                System.out.println(g.getIme());
            }
        }

        while (!pasoshRed.isEmpty()) {
            Gragjanin g = pasoshRed.dequeue();
            if (g.getVozachka() == 1) {
                vozachkaRed.enqueue(g);
            } else {
                System.out.println(g.getIme());
            }
        }

        while (!vozachkaRed.isEmpty()) {
            Gragjanin g = vozachkaRed.dequeue();
            System.out.println(g.getIme());
        }
    }
}
