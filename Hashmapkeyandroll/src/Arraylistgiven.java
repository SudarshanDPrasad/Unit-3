import java.util.ArrayList;
import java.util.Iterator;

public class Arraylistgiven {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(5);
        arrayList.add("Sudarshan");
        arrayList.add("Aditya");
        arrayList.add("Lloyd");
        arrayList.add("Prachi");
        arrayList.add("Arya");
        arrayList.add("Shubham");

        printall(arrayList);
        System.out.println("-------------------------------------");
        printgreater5(arrayList);
        System.out.println("-------------------------------------");
        printindex2(arrayList);
        System.out.println("-------------------------------------");
        printindex3(arrayList);
    }

    private static void printindex3(ArrayList<String> arrayList) {
        arrayList.set(3, "Masai");

        for (String i : arrayList) {
            System.out.println(i);
        }
    }

    private static void printindex2(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (i != 2) {
                System.out.println(arrayList.get(i));
            }
        }
    }

    private static void printgreater5(ArrayList<String> arrayList) {
        try {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String name = it.next();
                if (name.length() < 5)
                    arrayList.remove(name);


                while (it.hasNext()){
                    System.out.println(it.next());
                }
            }
        } catch (Exception e) {

        }

//        for (String i : arrayList) {
//            if (i.length() > 5) {
//                System.out.println(i);
//            }
//        }
    }

    private static void printall(ArrayList<String> arrayList) {
        for (String i : arrayList) {
            System.out.println(i);
        }
    }
}
