import java.util.Scanner;

public class DNAPalindrome{
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		String dna = "";
		char str;
		String reverseDNA = "";
		System.out.println("Enter a DNA sequence");
		dna = scn.nextLine();
		scn.close();
		
		boolean flag = true;
		
		CharDoubleEndedQueueImpl<char> myQueue = new CharDoubleEndedQueueImpl<char>("CharDoubleEndedQueueImpl");
		
		if(dna.contains(" ")){
			System.out.println("Error, contains space");
		}
		else{
			for(int i = 0; i < dna.length(); i++){
				if(dna.charAt(i) != 'A'  && dna.charAt(i) != 'T' && dna.charAt(i) != 'C' && dna.charAt(i) != 'G'){
					flag = false;
					break;
				}
			}
			
			if(flag == true){
				for(int i = 0; i < dna.length(); i++){
					myQueue.addLast(dna.charAt(i));
				}
				
				for(int i = 0; i < myQueue.size(); i++){
					
					str = (char) myQueue.removeLast();
					
					if(str == 'A'){
						reverseDNA += "T";
					}else if(str == 'T'){
						reverseDNA += "A";
					}else if(str == 'C'){
						reverseDNA += "G";
					}else{
						reverseDNA += "C";
					}
				}
				
				if(dna.equals(reverseDNA)){
					System.out.println("The DNA sample is Watson-Crick complemented palindrome");
				}else{
					
					System.out.println("The DNA sample is not Watson-Crick complemented palindrome");
				}
			}else{
				System.out.println("String cointains not accepted characters");
			}
		}
		
	}
}