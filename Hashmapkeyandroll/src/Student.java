import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // no of students
        while (n != 0) {
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            int houseNo = sc.nextInt();
            sc.nextLine();
            String address = sc.nextLine();


            System.out.println();

            System.out.println(name);
            System.out.println(houseNo);
            System.out.println(address);


            n--;
        }

    }
}

