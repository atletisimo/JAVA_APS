/* Квалитет на воздух 
Дадени се мерења на PM10 честички за населбите во Скопjе. Ваша задача е за
дадена населба да jа наjдете просечната концентрациjа на PM10 честички.
Влез: Во првиот ред од влезот е даден броjот на мерења, а во секоj нареден ред се дадени населбата и концентрациjата на PM10 честички разделени со
празно место. Во последниот ред е дадена населбата за коjа треба да наjдете
просечна концентрациjа на PM10 честички.
Излез: Просечната концентрациjа на PM10 честички за дадената населба
220
Податочни структури
(заокружена на 2 децимали, притоа прво нао´гате просечна концентрациjа, па
заокружувате).
Пример:
Влез:
8
Centar 319.61
Karposh 296.74
Centar 531.98
Karposh 316.44
GaziBaba 384.05
GaziBaba 319.3
Karposh 393.37
GaziBaba 326.42
Karposh
Излез:
355.52
*/
public class PM10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        OBHT<String, ArrayList<Double>> hashtable = new OBHT<>(2 * N);

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String neighbourhood = parts[0];
            double pm10 = Double.parseDouble(parts[1]);

            ArrayList<Double> list;
            int index = hashtable.search(neighbourhood);

            if (index == -1) {
                list = new ArrayList<>();
                list.add(pm10);
                hashtable.insert(neighbourhood, list);
            } else {
                list = hashtable.getBucket(index).value;
                list.add(pm10);
                hashtable.insert(neighbourhood, list);
            }
        }

        String searchNeighbourhood = sc.nextLine();
        int idx = hashtable.search(searchNeighbourhood);

        if (idx != -1) {
            ArrayList<Double> result = hashtable.getBucket(idx).value;
            if (result.size() > 0) {
                double sum = 0;
                for (double val : result) sum += val;
                double avg = sum / result.size();
                System.out.printf("%.2f", avg);
            } else {
                System.out.println("No info");
            }
        } else {
            System.out.println("No info");
        }

        sc.close();
    }
}
