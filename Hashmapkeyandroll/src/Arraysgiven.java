public class Arraysgiven {
    public static void main(String[] args) {
        int[] arr =  {1,2,3,4,5,};

        print(arr);
        System.out.println();
        System.out.println("--------------------------------------");
        printindex(arr);
        System.out.println();
        System.out.println("--------------------------------------");
        printindex3(arr);
        System.out.println();
    }

    private static void printindex3(int[] arr) {
        for(int i =0;i< arr.length;i++){
            if(i!=3){
                System.out.print(arr[i]+" ");
            }else {

            }
        }
    }

    private static void printindex(int[] arr) {
        for(int i =0;i< arr.length;i++){
            if(i!= arr.length-1){
                System.out.print(arr[i]+" ");
            }else{

            }
        }
    }

    private static void print(int[] arr) {
        for(int i =0;i< arr.length;i++){
            if(i!=0){
                System.out.print(arr[i]+" ");
            }else {

            }
        }
    }
}
