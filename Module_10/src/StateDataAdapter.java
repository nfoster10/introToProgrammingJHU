import java.io.*;
import java.util.*;

public class StateDataAdapter
{
	public static void main(String[]args)
	{
		PrintWriter consoleOutput = new PrintWriter(System.out, true); //flushing automatic 

		if(args.length >= 3)
		{
	    	try(FileReader dataInput =  new FileReader(args[0]); 
				PrintWriter dataOutput = new PrintWriter( new FileWriter(args[1], true))) 
	    	{
	    		Scanner fileReader = new Scanner(new File(args[0]), "UTF-8");
	    		int numberOfInputs;

	    		try
				{
					numberOfInputs = Integer.parseInt(args[2]);
				}
				catch(NumberFormatException e0) {
				   		consoleOutput.println("Error: 3rd input not a number");
				   		consoleOutput.println("Usage: java StateDataAdapter <input_location> <output_destination> <#_of_records>\n");
				   		return;
				}

	    		Object [][] dataByState = new Object[50][4]; //state/population/child population/child poverty population

	    		//fill dataByState with null pointers
	    		for(Object [] dataPoints : dataByState)
	    			for (Object dataPoint : dataPoints)
	    				dataPoint = null;

	    		String lineOfData = null;
	    		String [] lineOfDataAdapted = new String[7];
	    		boolean stateFound = false;

	    		//read data into dataByState
	    		for (int dataReader = 0; dataReader < numberOfInputs; dataReader++)
	    		{
	    			

	    			try
	    			{
	    				if(fileReader.hasNextLine())
	    					lineOfData = fileReader.nextLine();
	    				else{
	    					consoleOutput.println("End of file.");
	    					break;
	    				}

		    			consoleOutput.println(dataReader + " " + lineOfData);
		    			lineOfDataAdapted[0] = lineOfData.substring(0,2).trim();
		    			lineOfDataAdapted[4] = lineOfData.substring(82,90).trim();
		    			lineOfDataAdapted[5] = lineOfData.substring(91,99).trim();
		    			lineOfDataAdapted[6] = lineOfData.substring(100,108).trim();

	   					for (String token : lineOfDataAdapted)
			    			consoleOutput.print(token + " . ");
			    	}
			    	catch(StringIndexOutOfBoundsException e4) {
			    		consoleOutput.println("Error: upexecpted line length, skipping line");
			    		continue;
			    	}
			    	catch(NoSuchElementException e4) {
			    		consoleOutput.println("Error: no line data available, skipping line");
			    		continue;
			    	}

	    			for(Object [] stateData : dataByState) //locate state
	    			{
	    				if (stateData[0] != null)
		    				if(stateData[0].equals(lineOfDataAdapted[0]))
		    				{
		    					consoleOutput.println("state found!");
		    					stateData[1] = (int) stateData[1] + Integer.parseInt(lineOfDataAdapted[4]); //add population
		    					stateData[2] = (int) stateData[2] + Integer.parseInt(lineOfDataAdapted[5]); //add child populaton
		    					stateData[3] = (int) stateData[3] + Integer.parseInt(lineOfDataAdapted[6]); //add child in poverty population
		    					stateFound = true;
		    					break;
		    				}
	    			}

	    			if (!stateFound) //find empty slot to put state data
	    			{
		    			for(Object [] stateData : dataByState)
		    			{
		    				if (stateData[0] == null) 
		    				{
		    					consoleOutput.println("state not found!");

		    					for (String token : lineOfDataAdapted)
		    						consoleOutput.println(token);

		    					stateData[0] = lineOfDataAdapted[0];
		    					stateData[1] = Integer.parseInt(lineOfDataAdapted[4]); //add population
		    					stateData[2] = Integer.parseInt(lineOfDataAdapted[5]); //add child populaton
		    					stateData[3] = Integer.parseInt(lineOfDataAdapted[6]); //add child in poverty population
		    					break;
		    				}
		    			}
	    			}
	    			else
						stateFound = false;
	    		}

	    		//print out state data to console and dataOutput
	    		for (Object [] dataLine : dataByState)
	    		{	
	    			if(dataLine[0] != null)
	    				dataOutput.printf("%-2s %-20d %-20d %-20d \n", dataLine[0].toString(), (int)dataLine[1], (int)dataLine[2], (int)dataLine[3]);
	    			
	    			for (Object dataPoint : dataLine)
	    			{
	    				consoleOutput.print(dataPoint + ".");
	    			}
	    			consoleOutput.println();
	    		}
		    } 
		    catch(IOException e1) {
		    	consoleOutput.println("Error: \n\t" + e1);
		   	}
		   	catch(NumberFormatException e2) {
		   		consoleOutput.println("Error: \n\t" + e2);
		   	}
	    }
	    else //program parameters not specified
	    {
	    	consoleOutput.println("\nUsage: java StateDataAdapter <input_location> <output_destination> <#_of_records>\n");
	    }
	}
}