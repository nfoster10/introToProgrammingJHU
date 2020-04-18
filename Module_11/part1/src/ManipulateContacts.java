import java.io.*;
import java.util.*;

public class ManipulateContacts
{
	private static Scanner consoleInput = new Scanner(System.in); 
	private static File inputFile = null;
	private static BufferedReader contactList = null;

	private static TreeMap<Integer, Contact> contacts = new TreeMap<Integer, Contact>();

	public static void main(String [] args)
	{
		String contactListPath = new String();
		String manipulateType = new String();

		System.out.printf("\n\n\t\tManipulating Contacts!");

		while(true) //prompt for file path until file found
		{
			try{
				System.out.printf("\n\nEnter path to contact list or 'none' to create new file: ");
				contactListPath = consoleInput.nextLine().trim();

				if(contactListPath.equals("none"))
					break;

				inputFile = new File(contactListPath);

				contactList =  new BufferedReader(new FileReader(inputFile));
				System.out.printf("\n\nFile found.\n");

				break; //file found, break loop
			}
			catch(FileNotFoundException e0) {
				System.out.printf("\n\tFile not found! Try again!");
			}
		}

		//read contacts into TreeMap of contacts
		if(!contactListPath.equals("none"))
			populateContacts();

		while(true)
		{
			System.out.printf("\nEnter 'done', 'add', 'delete', or 'display'" +
				"\nto exit, add a contact, delete a contact or dislpay the contact list respectively: ");

			manipulateType = consoleInput.nextLine().trim();

			if(manipulateType.equals("done"))
				break;
			else if(manipulateType.equals("add"))
				addContact();
			else if(manipulateType.equals("delete"))
				deleteContact();
			else if(manipulateType.equals("display"))
				dislpayContacts();
			else
				System.out.printf("\n\tInvalid Entry!");
		}

		//re-write to new contact list...rename old contact list to .old
		if(!contactListPath.equals("none"))
		{
			inputFile.renameTo(new File(inputFile.getAbsolutePath() + ".old"));
		}

		writeNewContactList(contactListPath);
	}

	public static void populateContacts()
	{
		String lineToProcess = new String();
		String [] processedLine;
		int contactCounter = 0;

		try{
			while ((lineToProcess = contactList.readLine()) != null)
			{
				System.out.println(lineToProcess);
				processedLine = lineToProcess.split("\\|",0);
				for(String data : processedLine)
					data.trim();

				contacts.put(contactCounter, new Contact(processedLine[0], processedLine[1], processedLine[2], processedLine[3]));
				contactCounter++;
			}

			contactList.close();
		}
		catch (IOException e1){
			System.out.println("\nError: \n\t" + e1);
		}
	}

	public static void addContact()
	{
		int newContactKey = 0;
		String [] contactDataToEnter = new String[4];

		while(contacts.containsKey(newContactKey)) //find available contact key
			newContactKey++;

		System.out.print("\n\tEnter first name: ");
		contactDataToEnter[0] = consoleInput.nextLine().trim();
		System.out.print("\n\tEnter last name: ");
		contactDataToEnter[1] = consoleInput.nextLine().trim();
		System.out.print("\n\tEnter phone 10-digit #: ");
		contactDataToEnter[2] = consoleInput.nextLine().trim();
		System.out.print("\n\tEnter email: ");
		contactDataToEnter[3] = consoleInput.nextLine().trim();

		contacts.put(newContactKey, new Contact(contactDataToEnter[0], contactDataToEnter[1], contactDataToEnter[2], contactDataToEnter[3]));
	}

	public static void deleteContact()
	{
		int keyToRemove;

		System.out.println();
		System.out.print("\tEnter contact # to delete: ");
		if(contacts.containsKey(keyToRemove = consoleInput.nextInt()))
			contacts.remove(keyToRemove);
		else
			System.out.print("\n\tKey does not exist.");

		consoleInput.nextLine(); //eat the remainder of the line
	}

	public static void dislpayContacts()
	{
		System.out.printf("\n%10s%-20s|%-20s|%-15s|%-40s", "", "First Name", "Last Name", "Phone Number", "Email");
		System.out.printf("\n%10s%-20s|%-20s|%-15s|%-40s", "", "----------", "---------", "------------", "------");

		for(Map.Entry contact : contacts.entrySet())
		{
			System.out.printf("\n%-10s%s", contact.getKey().toString() + ": ", contact.getValue().toString());
		}
	}

	public static void writeNewContactList(String contactListPath)
	{
		if(!contactListPath.equals("none"))
		{
			try (PrintWriter dataOutput = new PrintWriter( new FileWriter(contactListPath, true))){
				for(Map.Entry contact : contacts.entrySet())
					dataOutput.println(contact.getValue().toString());
			}
			catch(IOException e2){
				System.out.println("Error:" + e2);
			}
		}
		else //no input file
		{
			try (PrintWriter dataOutput = new PrintWriter( new FileWriter("Contact_List.txt", true))){
				for(Map.Entry contact : contacts.entrySet())
					dataOutput.println(contact.getValue().toString());
			}
			catch(IOException e2){
				System.out.println("Error:" + e2);
			}

		}
	}
}