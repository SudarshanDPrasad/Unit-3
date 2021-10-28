public class KFC {
    int yourtokenNumber;

    public KFC(int yourtokenNumber){
        this.yourtokenNumber=yourtokenNumber;
    }

    public final void  friedChickenRecipe(){
        System.out.println("Fried Chicken recipe: Take 200gms boneless chicken  and \n marinate it with lemon, salt and flour");
    }

    public void display(){
        int tokenNumber = yourtokenNumber;
        System.out.println("KFC token number is "+ tokenNumber);

    }
}
