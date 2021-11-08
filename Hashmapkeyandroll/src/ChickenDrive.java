public class    ChickenDrive {
    public static void main(String[] args) {
        KFC kfc = new KFC(102);
        kfc.friedChickenRecipe();
        kfc.display();
        System.out.println();
        FiveStarChicken fiveStarChicken = new FiveStarChicken(345);
        fiveStarChicken.display();
    }
}
