public class FiveStarChicken extends KFC {

    public FiveStarChicken(int yourtokenNumber) {
        super(yourtokenNumber);
    }

    @Override
    public void display() {
        int tokenNumber = yourtokenNumber;
        System.out.println("Five Star Chicken Next order = " + tokenNumber);
    }
}
