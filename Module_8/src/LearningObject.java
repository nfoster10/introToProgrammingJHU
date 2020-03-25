
abstract class LearningObject implements ObjectActions.*
{
	private String name;

	LearningObject() //class concatenator
	{
		this.name = new String();
	}
	//LearningObject::setName() returns true and sets name to the inputName
	//if inputName is a valid input. All inputName values are valid
	public boolean setName(String inputName){
		this.name = inputName;
		return true;
	}

	//LearningObject::getName() returns String variable name for the calling instance of LearningObject
	public String getName(){
		return this.name;
	}
}