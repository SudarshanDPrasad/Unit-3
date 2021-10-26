import java.util.HashMap;
import java.util.Map;

public class HashMapstudent {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Aditya", 35);
        hashMap.put("Sudarshan", 26);
        hashMap.put("Shub", 45);
        hashMap.put("Arya", 37);
        hashMap.put("prac", 25);
        hashMap.put("LLoyd", 47);

        System.out.println("The name of the student ");
        printall(hashMap);
        System.out.println("---------------------------------------");
        System.out.println("The name of the student more than length 5");
        printlength(hashMap);
        System.out.println("---------------------------------------");
        System.out.println("The name of the student less than length 6 ");
        printlength6(hashMap);


    }

    private static void printlength6(HashMap<String, Integer> hashMap) {
        for(Map.Entry<String,Integer> map : hashMap.entrySet()){
            if(map.getKey().length() >= 6 ) {

            }else{
                System.out.println(map.getKey());
            }
        }
    }

    private static void printlength(HashMap<String, Integer> hashMap) {
        for(Map.Entry<String,Integer> map : hashMap.entrySet()){
            if(map.getKey().length()>5){
                System.out.println(map.getValue());
            }
        }
    }

    private static void printall(HashMap<String, Integer> hashMap) {
        for (Map.Entry<String, Integer> map : hashMap.entrySet())
            System.out.println(map.getKey());
    }
}
