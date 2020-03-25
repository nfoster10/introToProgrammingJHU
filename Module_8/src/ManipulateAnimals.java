public class ManipulateAnimals
{
	public static void main(String [] thing)
	{
		LearningObject [] learningObjects = {new Animal(), new Animal(), new Vehicle(), new Vehicle()};

		//demonstrate polymorphism using Animal and Vehicle classes
		for (LearningObject object : learningObjects)
		{
			System.out.println(object.drawObject());
			System.out.println(object.resizeObject());
			System.out.println(object.rotateObject());
			System.out.println(object.playSound());
			System.out.println();
		}
	}
}