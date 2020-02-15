package M1Assignment_N_Foster;

/*
	This will print the word JAVA in large letters that are all the same height
*/
public class PrintWord {

	public static void main(String[] args) 
	{
		//define letter templates
		char [][] letterTemplate_J = {
				{' ',' ',' ','J',},
				{' ',' ',' ','J',},
				{'J',' ',' ','J',},
				{' ','J','J',' ',}};
		char [][] letterTemplate_A = {
				{' ',' ',' ','A',' ',' ',' ',},
				{' ',' ','A',' ','A',' ',' ',},
				{' ','A','A','A','A','A',' ',},
				{'A',' ',' ',' ',' ',' ','A',}};
		char [][] letterTemplate_V = {
				{'V',' ',' ',' ',' ',' ','V',},
				{' ','V',' ',' ',' ','V',' ',},
				{' ',' ','V',' ','V',' ',' ',},
				{' ',' ',' ','V',' ',' ',' ',}};
		
		//spell word to be printed
		char [][][] word = {letterTemplate_J, letterTemplate_A, letterTemplate_V, letterTemplate_A};
		
		//Some helpful information
		//System.out.println("length word: " + word.length);
		//System.out.println("length word[0]: " + word[0].length);
		//System.out.println("length word[0][0]: " + word[0][0].length + "\n");
		
		
		//print variable word assuming all letters are the same height
		for (int row = 0; row < word[0].length; row++)
		{
			for (int letter = 0; letter < word.length; letter++)
			{
				for (int column = 0; column < word[letter][row].length; column++)
				{
					System.out.print(word[letter][row][column]);
				}//end of letter
			}//end of row
			System.out.println(); 
		}//end of word
	}//end main()
}//end class
