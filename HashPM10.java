import java.util.*;

public class PM10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // број на мерења
        sc.nextLine(); // да го прочисти new line по бројот

        // HashMap каде што:
        // клуч -> името на населбата
        // вредност -> листа од мерења (PM10 вредности)
        HashMap<String, ArrayList<Double>> map = new HashMap<>();

        // внес на мерења
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String neighbourhood = parts[0];                // населба
            double pm10 = Double.parseDouble(parts[1]);     // мерена вредност

            // ако ја нема во map -> додај нова листа
            if (!map.containsKey(neighbourhood)) {
                map.put(neighbourhood, new ArrayList<>());
            }

            // додај ја вредноста во листата за таа населба
            map.get(neighbourhood).add(pm10);
        }

        // населба за која треба да се пресмета просек
        String searchNeighbourhood = sc.nextLine();

        // земи ја листата на мерења за таа населба
        ArrayList<Double> result = map.get(searchNeighbourhood);

        if (result != null && result.size() > 0) {
            double sum = 0;
            for (double value : result) {
                sum += value;
            }
            double avg = sum / result.size();
            System.out.printf("%.2f", avg); // заокружено на 2 децимали
        } else {
            System.out.println("No info");
        }

        sc.close();
    }
}
