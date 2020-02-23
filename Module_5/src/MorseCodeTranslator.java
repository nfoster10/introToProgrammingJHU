import java.util.Scanner;

public class MorseCodeTranslator
{
	private static final String [][] ENGLISH_TO_MORSE_DECODER = 
		{{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
		"1","2","3","4","5","6","7","8","9","0"},
		{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...",
		"-","..-","...-",".--","-..-","-.--","--..",".----","..---","...--","....-",".....","-....","--...","---..","----.","-----"}};
	private static final Scanner input = new Scanner(System.in);

	public static void main (String [] args)
	{
		String userInput = new String();
		String translation = new String();

		while (!userInput.equals("done"))
		{
			System.out.printf("\n\nEnter 1 for Morse Code -> English, 2 for English -> Morse Code translation, or done to end: ");
			userInput = input.nextLine();

			switch (userInput)
			{
				case ".----":
				case "1":
					System.out.printf("\n\nEnter a Morse code phrase with characters seperated by spaces " +
						"and words seperated by pipes '|'. \nThen depress the Enter key:\n");
					translation = MorseCodeTranslator.translateMorseToEnglish(getMorseCodePhrase(input.nextLine()));
					break;
				case "..---":
				case "2":
					System.out.printf("\n\nEnter an English phrase. Then depress the Enter key:\n");
					translation = MorseCodeTranslator.translateEnglishToMorse(getEnglishPhrase(input.nextLine()));
					break;
				case "done":
					translation = "DONE"; //System.out.printf("\n\nDONE\n\n");
					break;
				default:
					translation = "INVALID input"; //System.out.printf("\n\nINVALID input.");
					break;
			}

			System.out.printf("\n\nTranslation: %s\n\n", translation);
		}
	}

	public static String [] getMorseCodePhrase(String userMorseCodePhrase)
	{
		String [] normalizedMorseCodePhrase = userMorseCodePhrase.split("\\s+");

		return normalizedMorseCodePhrase;
	}
	public static String translateMorseToEnglish(String [] morseCodePhrase)
	{
		String translatedMorseCodePhrase = new String();
		boolean characterFound; 

		for (String morseCharacter : morseCodePhrase)
		{
			characterFound = false;

			for (int decoder = 0; decoder < ENGLISH_TO_MORSE_DECODER[1].length; decoder++)
			{
				if (ENGLISH_TO_MORSE_DECODER[1][decoder].equals(morseCharacter))
				{
					translatedMorseCodePhrase = translatedMorseCodePhrase + ENGLISH_TO_MORSE_DECODER[0][decoder];
					characterFound = true;
				}
			}
			if (morseCharacter.equals("|"))
				translatedMorseCodePhrase = translatedMorseCodePhrase + " ";
			else if (!characterFound)
				translatedMorseCodePhrase = translatedMorseCodePhrase + "ERROR: Character not found!";
		}

		return translatedMorseCodePhrase;
	}

	public static String [] getEnglishPhrase(String userEnglishPhrase)
	{
		String [] normalizedEnglishPhrase = userEnglishPhrase.split("\\s+");
		return normalizedEnglishPhrase;
	}
	public static String translateEnglishToMorse(String [] englishPhrase)
	{
		String translatedEnglishPhrase = new String();
		boolean characterFound;

		for (String englishWord : englishPhrase)
		{
			for (int letter = 0; letter < englishWord.length(); letter++)
			{
				characterFound = false;

				for (int decoder = 0; decoder < ENGLISH_TO_MORSE_DECODER[0].length; decoder++)
				{
					if (ENGLISH_TO_MORSE_DECODER[0][decoder].charAt(0) == englishWord.charAt(letter) ||
						Character.toLowerCase(ENGLISH_TO_MORSE_DECODER[0][decoder].charAt(0)) == englishWord.charAt(letter))
					{
						translatedEnglishPhrase = translatedEnglishPhrase + ENGLISH_TO_MORSE_DECODER[1][decoder] + " ";
						characterFound = true;
						break;
					}
				}
				if (!characterFound)
					translatedEnglishPhrase = translatedEnglishPhrase + "ERROR: Character not found!";
			}
			translatedEnglishPhrase = translatedEnglishPhrase + " | ";
		}

		return translatedEnglishPhrase;
	}
}