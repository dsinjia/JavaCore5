package work16;

public class work161 {
    public static void main(String[] args) {
        Person ivan;
        try {

            ivan = new Person("Ivan Pestov", 5);
        } catch (ArithmeticException err){
            System.out.println("Age is wrong");
        }
        try {
            ivan.setAge(125);
        }catch (ArithmeticException err){
            System.out.println("Age is wrong");
        }
    }
}
