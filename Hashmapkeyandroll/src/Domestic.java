public class Domestic extends Commerical {
    public Domestic(String customerName,double price){
        super(customerName,price);
    }

    @Override
    public String getCustomerName() {
        return super.getCustomerName();
    }

    @Override
    public void setCustomerName(String customerName) {
        super.setCustomerName(customerName);
    }

    @Override
    public void calculateBill() {
        double bill = 100*price;
        System.out.println("Bill amount = " + bill+ "Rs");
    }
}
