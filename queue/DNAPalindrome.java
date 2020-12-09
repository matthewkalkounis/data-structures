import java.util.Scanner;

public class DNAPalindrome {
    public static void main(String[] args){
        System.out.println("Enter a DNA sequence");
        Scanner scn = new Scanner(System.in); //Create a Scanner object
        String dna = scn.nextLine(); //Read user input
        scn.close();
        if (dnaEvaluation(dna)){
           if(Watson_CrickPalindromeEvaluation(dna)){
               System.out.println("The DNA sample is Watson-Crick complemented palindrome");
           }else{
               System.out.println("The DNA sample is not Watson-Crick complemented palindrome");
           }
        }else{
            System.out.println("Wrong input!");
        }

    }
    //Evaluate input data
    private static boolean dnaEvaluation(String dna){
        if(dna.equals("")){
            return true;
        }else{
            for(int i = 0; i < dna.length(); i++){
                if(dna.charAt(i) != 'A' && dna.charAt(i) != 'T' && dna.charAt(i) != 'C' && dna.charAt(i) != 'G'){
                    return false;
                }
            }
        }
        return true;
    }
    //Evaluate if input is Watson-Crick complemented palindrome
    private static Boolean Watson_CrickPalindromeEvaluation(String dna){
        StringDoubleEndedQueueImpl<String> reverseQueue = new StringDoubleEndedQueueImpl<>();
        int sizeQueue = dna.length() -1;
        char c;
        if(!dna.equals("")){
            //insert into Queue the complementary element of every character from front
            for(int i = 0; i <= sizeQueue; i++) {
                c = dna.charAt(i);
                if (c == 'A') {
                    reverseQueue.addFirst("T");
                }else if (c == 'T') {
                    reverseQueue.addFirst("A");
                }else if(c == 'C'){
                    reverseQueue.addFirst("G");
                }else{
                    reverseQueue.addFirst("C");
                }
                //compare string element from last to first with first item in Queue
                if(!Character.toString(dna.charAt(sizeQueue - i)).equals(reverseQueue.getFirst())){
                    return false;
                }
            }
        }
        return true;

    }
}
