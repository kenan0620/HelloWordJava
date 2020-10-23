
public class Person {
	protected String name;
	protected int age;

	private String[] names;

	public String getName() {
		/*
		 * 在方法内部，可以使用一个隐含的变量this，它始终指向当前实例。因此，通过this.field就可以访问当前实例的字段。
		 * 
		 * 如果没有命名冲突，可以省略this
		 */
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		/*
		 * 但是，如果有局部变量和字段重名，那么局部变量优先级更高，就必须加上this：
		 */
		return this.age;
	}

	public void setAge(int age) {
		if (age < 0 || age > 130) {
			throw new IllegalArgumentException("invalid age value");
		}
		this.age = age;
	}

	public void setNameAndAge(String name, int age) {
		this.name = name;
		if (age < 0 || age > 130) {
			throw new IllegalArgumentException("invalid age value");
		}
		this.age = age;
	}

	public void setNames(String... names) {
		this.names = names;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 调用另一个构造方法Person(String)
	public Person() {
		this("no");
	}

	// 调用另一个构造方法Person(String, int)
	public Person(String name) {
		this(name, 18);
	}

	/*
	 * 用final修饰的方法不能被Override： 用final修饰的类不能被继承：
	 */
	public final void custom() {

	}
}

final class Teacher extends Person {

}

class Student extends Person {
	private int score;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String hello() {
		return "Hello, " + super.name;
	}

	public Student(String name, int age, int score) {
		super();
		this.score = score;
	}
}
