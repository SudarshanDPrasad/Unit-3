public class FinalCalCulateClass {
    public static void main(String[] args) {
        Commerical commercial = new Commerical("Raj Kuamar",5);
        System.out.println("customer" + commercial.customerName);
        commercial.calculateBill();
        System.out.println();

        Domestic domestic = new Domestic("Lalith Raj",2.5);
        System.out.println("customer "+ domestic.customerName);
        domestic.calculateBill();


    }
}
