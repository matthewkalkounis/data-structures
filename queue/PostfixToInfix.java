import java.util.Scanner;

public class PostfixToInfix {
    public static void main(String[] args){

        System.out.println("Enter postfix expression: ");
        Scanner scn = new Scanner(System.in); //Create a Scanner object
        String postfixStr = scn.nextLine(); //Read user input
        scn.close();

        if (PostfixEvaluation(postfixStr)){
            toInfix(postfixStr);
        }

    }

    private static Boolean PostfixEvaluation(String postfixStr){
        int number = 0;
        int operator = 0;
        boolean bool = true;
        int position;
        int opt = 1;
        for (int i= 0; i < postfixStr.length(); i++){
           char c = postfixStr.charAt(i);
           position = i +1;

           //check for invalid symbols
           if(Character.isDigit(c)){
               number++;
           }else if(c == '+' || c== '-' || c == '*' || c == '/' ){
               operator++;
           }else{
               System.out.println("Invalid symbols! Position found: " + position );
               bool = false;
               break;
           }

            //check if operators are in valid position
            if(i < postfixStr.length() -1  && number <= operator && (c == '+' || c== '-' || c == '*' || c == '/' )){
                opt++;
                System.out.println("Invalid position of operator! Position found: " + position );
                bool = false;
            }

            //check if operators are too many
            if((opt > 1  || i == postfixStr.length() -1) && number <= operator) {
                System.out.println("Too many operators!");
                bool = false;

            }

        }
        //check if number of operators is valid
        if(operator < (number - 1)){
            System.out.println("Not enough operators!");
            bool = false;
        }

        //check if last character is operator
        char c1 = postfixStr.charAt(postfixStr.length() -1);
        if(c1 != '+' && c1 != '-' && c1 != '*' && c1 != '/'){
            System.out.println("The last character must be an operator!");
            bool = false;
        }

        return bool;

    }

    private static void toInfix(String postfixStr){
        //Create a DoubleEnded Queue object
        StringDoubleEndedQueueImpl<String> Queue = new StringDoubleEndedQueueImpl<>("Infix expression");
        for(int i = 0; i < postfixStr.length(); i++){
            char c = postfixStr.charAt(i);
            if(c == '+' || c== '-' || c == '*' || c == '/') {
                String str1 = Queue.removeLast();
                String str2 = Queue.removeLast();
                String tmp;
                if(i < postfixStr.length() -1){
                    tmp = "(" + str2 + c + str1 + ")";
                }else{
                    tmp = str2 + c + str1;
                }
                Queue.addLast(tmp);

            }else{
                Queue.addLast(String.valueOf(c));
            }
        }
        Queue.printQueue(System.out);
    }

}
