package interviewQuestions;

public class Algorithm {
    public static void main(String[] args) {
        System.out.println("Algorithms");
        ///////// FizzBuzz
        for (var i = 1; i < 100; i++) {
            fizzBuzz(i);

        }


    }

    //    private static void fizzBuzz(int i) {
//        if(i%15==0) {
//            System.out.println(i + " FizzBuzz");
//        }else {
//            if(i%3==0){
//                System.out.println(i + " Fizz");
//            }else {
//                if(i%5==0){
//                    System.out.println(i + " Buzz");
//                }
//            }
//        }
//    }
    /////// Same but short
    private static void fizzBuzz(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            System.out.println(i + " FizzBuzz");
            return;
        }
        if (i % 3 == 0) {
            System.out.println(i + " Fizz");
            return;
        }
        if (i % 5 == 0) {
            System.out.println(i + " Buzz");
        }
    }
}

