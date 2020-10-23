
public class Interface {

}

//比抽象类还要抽象的纯抽象接口，因为它连字段都不能有.
//接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来（写不写效果都一样）
interface Car {
	void run();

	String getNameString();
}

class BaoMa implements Car {
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
}