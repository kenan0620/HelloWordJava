package home;

//内部类（Nested Class）
public class Outer {
	private static String NAME = "OUTER";
	public static class StaticNested {
		public void hello() {
			System.out.println("hello, " + Outer.NAME);
		}
	}
	private String nameString;
	public Outer(String name) {
		this.nameString = name;
	}
	

	/**
	 * Anonymous Class 
	 * 还有一种定义Inner Class的方法，它不需要在Outer Class中明确地定义这个Class，
	 * 而是在方法内部，通过匿名类（Anonymous Class）来定义。
	 * */
	public void asyncHello() {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Hello, " + Outer.this.nameString);
			}
		};
		new Thread(runnable).start();
	}
	
	public class Inner {
		// 定义了一个Inner Class
		/*
		 * Outer是一个普通类，而Inner是一个Inner Class，它与普通类有个最大的不同，
		 * 就是Inner Class的实例不能单独存在，必须依附于一个Outer Class的实例。
		 * 
		 * Inner Class和普通Class相比，除了能引用Outer实例外，
		 * 还有一个额外的“特权”，就是可以修改Outer Class的private字段，
		 * 因为Inner Class的作用域在Outer Class内部，
		 * 所以能访问Outer Class的private字段和方法。
		 * 观察Java编译器编译后的.class文件可以发现，
		 * Outer类被编译为Outer.class，而Inner类被编译为Outer$Inner.class。
		 * */
		public void hello() {
			System.out.println("Hello, " + Outer.this.nameString);
		}
	}
}
