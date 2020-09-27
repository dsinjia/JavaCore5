package interviewQuestions;

public class ReverseSentence {
    public static void main(String[] args) {
        final String sentence = "Today is awful weather";
        reverseSentence(sentence);

    }

    private static void reverseSentence(String sentence) {
        var words = sentence.split(" ");
        var reverse = "";
        for(var i = words.length-1;i>=0;i--){
            reverse+=words[i]+" ";
        }
        System.out.println(reverse);
    }
}
