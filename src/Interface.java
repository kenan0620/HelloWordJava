
public class Interface {

}

//比抽象类还要抽象的纯抽象接口，因为它连字段都不能有.
//接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来（写不写效果都一样）
interface Car {
	void run();

	/**
	 * 实现类可以不必覆写default方法。default方法的目的是，当我们需要给接口新增一个方法时，
	 * 会涉及到修改全部子类。如果新增的是default方法，那么子类就不必全部修改，
	 * 只需要在需要覆写的地方去覆写新增方法。
	 * 
	 * default方法和抽象类的普通方法是有所不同的。
	 * 因为interface没有字段，default方法无法访问字段，而抽象类的普通方法可以访问实例字段。
	 */
	default void quickRun() {
		System.out.println("跑的这块呢!");
	};

	String getNameString();
	
/*
 * 因为interface是一个纯抽象类，所以它不能定义实例字段。
 * 但是，interface是可以有静态字段的，并且静态字段必须为final类型：
*/
    public static final int MALE = 1;
 // 编译器会自动加上public static final:
    int MALE1 = 1;
    int FEMALE = 2;
}

interface Oil {
	void oil();
}

class BaoMa implements Car, Oil {
	private String nameString;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("宝马车跑起来了");
	}

	@Override
	public String getNameString() {
		// TODO Auto-generated method stub
		return this.nameString;
	}

	@Override
	public void oil() {
		// TODO Auto-generated method stub
		System.out.println("宝马油");
	}
}