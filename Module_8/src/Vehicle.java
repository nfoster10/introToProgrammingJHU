public class Vehicle extends LearningObject
{
	private int age;

	Vehicle() //class concatenator
	{
		this.age = 0;
	}

	//Vehicle::setAge() returns true if inputAge is a valid Age and sets age to inputAge
	//inputAge is valid if greater than 0
	public boolean setAge(int inputAge){
		boolean isValidData = false
		
		if (inputAge > 0)
		{
			this.age = inputAge;
			isValidData = true;
		}

		return isValidData;
	}

	//Vehicle::getAge() returns the age of the calling instance of a Vehicle object
	public int getAge(){
		return this.age;
	}

	//Vehicle::drawObject() returns a String "Drawing a Vehicle"
	public String drawObject()
	{
		return "Drawing a Vehicle";
	}

	//Vehicle::resizeObject() returns a String "Resizing a Vehicle"
	public String resizeObject()
	{
		return "Resizing a Vehicle";
	}

	//Vehicle::rotateObject() returns a String "Rotating a Vehicle"
	public String rotateObject()
	{
		return "Rotating a Vehicle";
	}

	//Vehicle::playSound() returns a String "Vehicle Sound"
	public String playSound()
	{
		return "Vehicle Sound";
	}
}