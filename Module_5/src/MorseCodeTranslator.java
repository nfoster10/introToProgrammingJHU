import java.util.Scanner;

public class MorseCodeTranslator
{
	private static final String [][] ENGLISH_TO_MORSE_DECODER = 
		{{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
		"1","2","3","4","5","6","7","8","9","0"},
		{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...",
		"-","..-","...-",".--","-..-","-.--","--..",".----","..---","...--","....-",".....","-....","--...","---..","----.","-----"}};

	public static void main (String [] args)
	{
		String userInput = new String();
		String translation = new String();
		Scanner input = new Scanner(System.in);

		while (!userInput.equals("done"))
		{
			System.out.printf("\n\nEnter 1(.----) for Morse Code -> English, 2(..---) for English -> Morse Code translation, or done to end: ");
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
					translation = "DONE"; 
					break;
				default:
					translation = "INVALID input"; 
					break;
			}
			System.out.printf("\n\nTranslation: %s\n\n", translation);
		}
	}

	//MorseCodeTranslator::getMorseCodePhrase() takes a user input Morse Code phrase and outputs a String array equivalent 
	//of the user input string 'userMorseCodePhrase' that has been normalzied to be translated.
	//pre-conditions: the input phrase is morse code characters separated by spaces and words separated by pipes
	//post-conditions: an array of Strings for each morse character is returned
	public static String [] getMorseCodePhrase(String userMorseCodePhrase)
	{
		String [] normalizedMorseCodePhrase = userMorseCodePhrase.split("\\s+");

		return normalizedMorseCodePhrase;
	}

	//MorseCodeTranslator::translateMorseToEnglish() takes a normalized string array of a morse code and outputs a string
	//object of the morse code in English
	//pre-conditons: morseCodePhrase is normalized
	//post-conditions: an english translation or error message is output in translatedMorseCodePhrase
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

	//MorseCodeTranslator::getEnglishPhrase() takes a user input english phrase and outputs a String array equivalent 
	//of the user input string 'userEnglishPhrase' that has been normalzied to be translated.
	//pre-conditions: the input phrase is english words
	//post-conditions: an array of Strings for each english word is returned
	public static String [] getEnglishPhrase(String userEnglishPhrase)
	{
		String [] normalizedEnglishPhrase = userEnglishPhrase.split("\\s+");
		return normalizedEnglishPhrase;
	}

	//MorseCodeTranslator::translateEnglishToMorse() takes a normalized string array of a english words and outputs a string
	//object of the morse code in morse code
	//pre-conditons: englishPhrase is normalized
	//post-conditions: a morse code translation or error message is output in translatedEnglishPhrase
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
			translatedEnglishPhrase = translatedEnglishPhrase + "| ";
		}

		return translatedEnglishPhrase;
	}
}