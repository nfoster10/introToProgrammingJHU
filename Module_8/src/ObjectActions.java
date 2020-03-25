public class ObjectActions
{
	public interface Drawable{
		String drawObject();
	}

	public interface Resizable{
		String resizeObject();
	}

	public interface Rotatable{
		String rotateObject();
	}

	public interface Sounds{
		String playSound();
	}
}