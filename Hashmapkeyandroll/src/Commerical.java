public class Commerical {

    String customerName;
    double price;

    public Commerical(String customerName , double price) {
        this.customerName = customerName;
        this.price=price;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(java.lang.String customerName) {
        this.customerName = customerName;
    }
    public void calculateBill(){
        double bill = 100*price;
        System.out.println("Bill amount = " + bill+ "Rs");
    }
}
