public class StudentDetails {
    String name;
    String DOB;
    String BloodGroup;

    public StudentDetails(String name,String DOB,String BloodGroup){
        this.name = name;
        this.DOB = DOB;
        this.BloodGroup = BloodGroup;

    }
    public static void main(String[] args) {
        StudentDetails studentDetails1 = new StudentDetails("Aman","19-05-1995","O+ve");
        int age = studentDetails1.Calculateage(studentDetails1.DOB);
        studentDetails1.Student1(studentDetails1,age);

        System.out.println("------------------------------------");
        StudentDetails studentDetails2 = new StudentDetails("Rahul Vats","18-05-1998","Ab-ve");
        int age2 = studentDetails1.Calculateage(studentDetails1.DOB);
        studentDetails2.Student2(studentDetails2,age2);

    }

    private void Student2(StudentDetails studentDetails2, int age2) {
        System.out.println("Student 2 name is " + studentDetails2.name);
        System.out.println("Student 2 age is "+ age2);
        System.out.println("Student 2 BloodGroup is "+studentDetails2.BloodGroup);

    }

    private void Student1(StudentDetails studentDetails1,int age) {
        System.out.println("Student 1 name is " + studentDetails1.name);
        System.out.println("Student 1 age is "+ age);
        System.out.println("Student 1 BloodGroup is "+studentDetails1.BloodGroup);
    }

    private int Calculateage(String dob) {
        int currentYear = 2021;
        String[] arr = dob.split("-");
        String year = arr[2];
        int birthyear = Integer.parseInt(year);
        int age = currentYear-birthyear;
        return age;
    }
}
