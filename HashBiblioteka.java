/*
Библиотека

Студентите на факултетот за научна фантастика имаат текстуални индекси. Нивните информации (име и презиме) се чуваат во податочна структура така што може со сложеност О(1) за било кој индекс да се пристапи до името и презимето на студентот.

За да добијат попуст за влез во библиотеката, студентите треба да имаат поминато барем Т минути во библиотеката. Вие треба да напишете програма која ќе добие информации за дадени индекси колку време поминале во библиотеката, и ќе треба да се отпечати името и презимето за соодветните индекси кои што добиваат попуст.

Влез: На влез прво е даден број N- број на студенти за кои има информации во податочната структура. Потоа во секој од следните N редови има име, презиме и индекс за секој студент.

Во следниот ред е даден цел број T - минималното време потребно за да се добие попуст во библиотеката.

Во останатите редови се дадени парови од индекс и поминато време, се додека не се внесе "kraj 0". (студенти може да пристигаат по било кој редослед, и по повеќе пати, погледнете ги примерите)

Излез: За секој индекс од паровите на влез, доколку соодветното време е барем Т тогаш отпечатете ги името и  презимето на студентот во посебен ред.

За задачата да се смета за точна треба пристапот до името и презимето за даден индекс да биде со сложеност О(1).

Можете да користите податочна структура по свој избор, која што го исполнува барањето погоре.
Library

The students of the Faculty of Science Fiction have textual indexes. Their information (first name and last name) is stored in a data structure so that the name and surname of a student can be accessed by their index with complexity O(1).

To get a discount on the library entry fee, students must spend at least T minutes in the library. You need to write a program that will receive information for given indexes about how much time they have spent in the library, and you should print the first name and last name for the corresponding indexes that get a discount.

Input: The first line contains the number N – the number of students for whom there is information in the data structure. Each of the following N lines contains a first name, last name, and index for one student.

In the next line, an integer T is given – the minimum time required for a discount in the library.

In the remaining lines, pairs of index and time spent are given, until "kraj 0" is entered. (students can arrive in any order, and multiple times, look at the examples.)

Output: For each index from the pairs, if the corresponding time is at least T then print the first and last name of the student in a separate line.

For the solution to be considered correct, access to the first and last name for a given index must be with complexity O(1).

You may use a data structure of your choice, as long as it satisfies the requirement above.

=================================================================

Пример/Example:
Влез/Input:
10
Ivana Petrovska 10a1
Martin Jovanov 22b5
Ana Stojanovska 33c0
Boris Nikolov 44d7
Elena Krstevska 55e9
Petar Angelov 66f3
Marija Karanfilovska 77g2
Stefan Trajkov 88h6
Simona Georgievska 99i4
Aleksandar Iliev 11j8
30
10a1 45
22b5 25
33c0 60
44d7 10
55e9 30
66f3 50
77g2 15
88h6 70
99i4 20
11j8 35
10a1 29
77g2 85
33c0 42
kraj 0

Излез/Output:

Ivana Petrovska
Ana Stojanovska
Elena Krstevska
Petar Angelov
Stefan Trajkov
Aleksandar Iliev
Marija Karanfilovska
Ana Stojanovska


For example:

Input	Result
10
Ivana Petrovska 10a1
Martin Jovanov 22b5
Ana Stojanovska 33c0
Boris Nikolov 44d7
Elena Krstevska 55e9
Petar Angelov 66f3
Marija Karanfilovska 77g2
Stefan Trajkov 88h6
Simona Georgievska 99i4
Aleksandar Iliev 11j8
30
10a1 45
22b5 25
33c0 60
44d7 10
55e9 30
66f3 50
77g2 15
88h6 70
99i4 20
11j8 35
10a1 29
77g2 85
33c0 42
kraj 0
Ivana Petrovska
Ana Stojanovska
Elena Krstevska
Petar Angelov
Stefan Trajkov
Aleksandar Iliev
Marija Karanfilovska
Ana Stojanovska
10
Lara Dimitrova a12x9
Nikola Spasov b77m3
Mila Kostovska c55z1
Filip Petrovski d91y4
Teodora Ivanova e08q7
Viktor Stamenkov f66r2
Sara Mitreva g42k5
Damjan Velkov h19n8
Kristina Ristovska i73p6
Stefan Milenkov j30t0
40
i73p6 25
e08q7 10
f66r2 85
g42k5 33
j30t0 40
h19n8 41
h19n8 50
i73p6 20
a12x9 38
g42k5 80
d91y4 70
a12x9 55
b77m3 20
b77m3 65
f66r2 39
e08q7 45
d91y4 15
j30t0 90
c55z1 60
c55z1 42
kraj 0
Viktor Stamenkov
Stefan Milenkov
Damjan Velkov
Damjan Velkov
Sara Mitreva
Filip Petrovski
Lara Dimitrova
Nikola Spasov
Teodora Ivanova
Stefan Milenkov
Mila Kostovska
Mila Kostovska

*/

import java.util.*;

public class LibraryDiscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine()); // број на студенти
        HashMap<String, String> students = new HashMap<>();

        // Внесување на студентите во хеш мапата
        for (int i = 0; i < N; i++) {
            String firstName = sc.next();
            String lastName = sc.next();
            String index = sc.next();
            students.put(index, firstName + " " + lastName);
        }

        int T = sc.nextInt(); // минимално време за попуст
        sc.nextLine(); // прочистување на редот

        while (true) {
            String line = sc.nextLine();
            if (line.equals("kraj 0")) break;

            String[] parts = line.split(" ");
            String index = parts[0];
            int minutes = Integer.parseInt(parts[1]);

            if (minutes >= T) {
                System.out.println(students.get(index));
            }
        }
    }
}
