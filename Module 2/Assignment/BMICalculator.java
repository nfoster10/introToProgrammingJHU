
import java.util.Scanner;

public class BMICalculator {

	//Department of Health and Human Services BMI standards
	private static final double UNDERWEIGHT = 18.5;
	private static final double NORMAL = 24.9;
	private static final int OVERWEIGHT_MIN = 25;
	private static final double OVERWEIGHT = 29.9;
	private static final int OBESE_MIN = 30;
	
	//Conversions
	private static final double KILOGRAMS_PER_POUND = .45359237;
	private static final double METERS_PER_INCH = .0254;
	
	public static void main(String[] args) 
	{
		System.out.print("\n\n\n");
		System.out.print("Enter weight (lbs) and height (inches) seperated by a blank space and then depress the return key.");
		System.out.print("\n\n");
		
		Scanner input = new Scanner(System.in);
		
		double bmi = calculateBMI(input.nextInt(), input.nextInt());
		
		System.out.printf("\n\n\tYour BMI is %f", bmi);
		
		System.out.print("\n\n\tYou are ");
		int rank = getBMICategoryForBMI(bmi);
		System.out.println();
		
		displayStandards();
	}
	
	//calculate and return BMI
	//return 0 if height or weight is 0
	private static double calculateBMI(int weight, int height)
	{
		double bmi = 0;
		double convertedWeight = KILOGRAMS_PER_POUND * weight;
		double convertedHeight = METERS_PER_INCH * height;
		
		bmi = 0 < convertedHeight ? convertedWeight / (convertedHeight * convertedHeight) : 0;
		
		return bmi;
	}
	
	private static void displayStandards()
	{
		System.out.print("\n\tBMI information defined by the Dept. of Health & Human Services");
		System.out.printf("\n\t\t1. Underweight: less than %.1f", UNDERWEIGHT);
		System.out.printf("\n\t\t2. Normal: %.1f - %.1f", UNDERWEIGHT, NORMAL);
		System.out.printf("\n\t\t3. Overweight: %d - %.1f", OVERWEIGHT_MIN, OVERWEIGHT);
		System.out.printf("\n\t\t4. Obese: %d or greater", OBESE_MIN);
		
	}
	
	//determine weight category and assign rank enumeration
	private static int getBMICategoryForBMI(double bmi)
	{
		int rank = 0;
		
		if (bmi > OVERWEIGHT)
		{
			System.out.print("OBESE");
			rank = 4;
		}
		else if (bmi > NORMAL)
		{
			System.out.print("OVERWEIGHT");
			rank = 3;
		}
		else if (bmi > UNDERWEIGHT)
		{
			System.out.print("NORMAL");
			rank = 2;
		}
		else if (bmi > 0)
		{
			System.out.print("UNDERWEIGHT");
			rank = 1;
		}	
		else
			System.out.print("- ERROR *INVALID WEIGHT OR HEIGHT* ");
		
		return rank;
		
	}

}