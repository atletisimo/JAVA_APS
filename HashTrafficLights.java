import java.util.*;
import java.text.*;

// Класа за возач
class Driver implements Comparable<Driver> {
    String name;
    String surname;
    Date time;

    public Driver(String name, String surname, Date time) {
        this.name = name;
        this.surname = surname;
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public int compareTo(Driver o) {
        return this.getTime().compareTo(o.getTime());
    }
}

// Главна класа
public class TrafficLights {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        // Број на регистарски таблички
        int N = Integer.parseInt(sc.nextLine());

        // Хеш табела со регистрација како key и име+презиме како value
        OBHT<String, String> hashtable = new OBHT<>(2 * N);

        // Читање на сопственици
        for (int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split(" ");
            String plate = parts[0];
            String nameSurname = parts[1] + " " + parts[2];
            hashtable.insert(plate, nameSurname);
        }

        // Дозволена брзина
        int maxSpeed = Integer.parseInt(sc.nextLine());

        // Дневен извештај од радарот
        String[] traffic = sc.nextLine().split(" ");

        // Листа за возачи кои ја надминале брзината
        LinkedList<Driver> drivers = new LinkedList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        // Обработка на дневниот извештај
        for (int i = 0; i < traffic.length; i += 3) {
            String plateDriver = traffic[i];
            int speedDriver = Integer.parseInt(traffic[i + 1]);
            String timeDriver = traffic[i + 2];

            if (speedDriver > maxSpeed) {
                String nameSurname = hashtable.getBucket(hashtable.search(plateDriver)).value;
                String[] pom = nameSurname.split(" ");
                drivers.add(new Driver(pom[0], pom[1], formatter.parse(timeDriver)));
            }
        }

        // Сортирање по време
        Collections.sort(drivers);

        // Печатење на резултати
        for (Driver d : drivers) {
            System.out.println(d.toString());
        }
    }
}
