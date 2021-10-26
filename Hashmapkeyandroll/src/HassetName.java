import java.util.HashSet;
import java.util.Map;

public class HassetName {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("India");
        hashSet.add("Pak");
        hashSet.add("China");
        hashSet.add("India");
        hashSet.add("Aus");
        hashSet.add("Pak");
        hashSet.add("Japan");

        prinallelements(hashSet);
        System.out.println("---------------------------------------");
        System.out.println("The name of the Country more than length 3");
        printlength(hashSet);
        System.out.println("---------------------------------------");
        System.out.println("The name of the Country without India");
        print(hashSet);
    }

    private static void print(HashSet<String> hashSet) {
        for(String i : hashSet){
            if(!i.equals("India")){
                System.out.println(i);
            }
        }
    }

    private static void printlength(HashSet<String> hashSet) {
        for (String i : hashSet) {
            if (i.length() >= 3) {
                System.out.println(i);
            }
        }
    }

    private static void prinallelements(HashSet<String> hashSet) {
        for (String i : hashSet) {
            System.out.println(i);
        }
    }
}
