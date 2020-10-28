import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

import com.itranswarp.word.PersonPack;

import home.Outer;

/**
 * 开始练习JAVA
 * 
 * @author conan
 */

/*
 * import static很少使用。

Java编译器最终编译出的.class文件只使用完整类名，因此，在代码中，当编译器遇到一个class名称时：

如果是完整类名，就直接根据完整类名查找这个class；

如果是简单类名，按下面的顺序依次查找：

查找当前package是否存在这个class；

查找import的包是否包含这个class；

查找java.lang包是否包含这个class。

*/
import static java.lang.System.*;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

enum Weekday {
    MON, TUE, WED, THU, FRI, SAT, SUN;
}

/**
 * 在IDE中运行Java程序，IDE自动传入的-classpath参数是当前工程的bin目录和引入的jar包。
 * 不要把任何Java核心库添加到classpath中！JVM根本不依赖classpath加载核心库！
 * */

public class HelloWordJava {
	// Java入口程序规定的方法必须是静态方法，方法名必须为main，括号内的参数必须是String数组
	
	//使用Introspector.getBeanInfo()可以获取属性列表。
	static public void main(String[] args) throws IntrospectionException {
		
		// 需要使用安全随机数的时候，必须使用SecureRandom，绝不能使用Random！
		SecureRandom sRandom = null;
		try {
			sRandom = SecureRandom.getInstanceStrong();
			
		} catch (NoSuchAlgorithmException  e) {
			// TODO: handle exception
			// 先记下来再说:
	        e.printStackTrace();
			sRandom = new SecureRandom();
		}
		
		 byte[] buffer = new byte[16];
		 sRandom.nextBytes(buffer); // 用安全随机数填充buffer
	        System.out.println(Arrays.toString(buffer));
		
		Math.random();
		System.out.println(Math.random());
		 BigDecimal d1 = new BigDecimal("123.456789");
	        BigDecimal d2 = d1.setScale(4, RoundingMode.HALF_UP); // 四舍五入，123.4568
	        BigDecimal d3 = d1.setScale(4, RoundingMode.DOWN); // 直接截断，123.4567
	        System.out.println(d2);
	        System.out.println(d3);
	        
	        BigDecimal d11 = new BigDecimal("123.456");
	        BigDecimal d21 = new BigDecimal("123.45600");
	        System.out.println(d11.equals(d21)); // false,因为scale不同
	        System.out.println(d11.equals(d21.stripTrailingZeros())); // true,因为d2去除尾部0后scale变为2
	        //必须使用compareTo()方法来比较，
	        //它根据两个值的大小分别返回负数、正数和0，分别表示小于、大于和等于。
	        System.out.println(d11.compareTo(d21)); // 0
		
		 BeanInfo info = Introspector.getBeanInfo(Person.class);
	        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
	            System.out.println(pd.getName());
	            System.out.println("  " + pd.getReadMethod());
	            System.out.println("  " + pd.getWriteMethod());
	        }
	        
		
		 String[] names = {"Bob", "Alice", "Grace"};
	        var sj = new StringJoiner(", 柯南", "开始是", "结束是");
	        for (String name : names) {
	            System.out.println(sj.toString() + "1");

	            sj.add(name);
	            System.out.println(sj.toString() + "2");
	        }
	        System.out.println(sj.toString());
		
	        var s12 = String.join(", ", names);
	        System.out.println(s12);

		//两个字符串比较，必须总是使用equals()方法。
		//要忽略大小写比较，使用equalsIgnoreCase()方法
		String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        //对两个Integer实例进行比较要特别注意：绝对不能用==比较，
        //因为Integer是引用类型，必须使用equals()比较：


        //把内部优化留给Integer的实现者去做，即使在当前版本没有优化，也有可能在下一个版本进行优化
        // 创建新对象时，优先选用静态工厂方法而不是new操作符。
        Integer nu = Integer.valueOf(100);
        System.out.println(nu);
        
		/*
		 * 上述定义的Outer是一个普通类，而Inner是一个Inner Class，它与普通类有个最大的不同，
		 * 就是Inner Class的实例不能单独存在，必须依附于一个Outer Class的实例。*/
		Outer outer = new Outer("Nested");
		outer.asyncHello();
		Outer.Inner inner = outer.new Inner(); 
		inner.hello();
		Outer.StaticNested sn = new Outer.StaticNested();
		sn.hello();
		PersonPack pack = new PersonPack();
		pack.nameString = "新报了";
		/*
		 * 
		 * 
		 * */
		System.out.println("HelloWordJava!");

		Person studentPerson = new Student("学生名", 15, 20);
		
		System.out.println(studentPerson.name);
		Person mingPerson = new Person();
		String nameString  = "小明";
		mingPerson.setName(nameString);
		mingPerson.setAge(24);
		System.out.println(mingPerson.getName());

		Person.number = 88;
		System.out.println(Person.number);
		Person.number = 99;
		System.out.println(Person.number);

		nameString = "小白菜";
				
		mingPerson.setNames("小红","小蓝","熊白");
		System.out.println(mingPerson.getName());

		System.out.println(Arrays.toString(args));
		
		Person person = new Person("小李", 53);

		/// 经典冒泡排序
		int[] maopaoArr = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
		System.out.println(Arrays.toString(maopaoArr));
		Arrays.sort(maopaoArr);
		System.out.println(Arrays.toString(maopaoArr));

		for (int i = 0; i < maopaoArr.length - 1; i++) {
			for (int j = 0; j < maopaoArr.length - 1 - i; j++) {
				if (maopaoArr[j] > maopaoArr[j + 1]) {
					int tmp = maopaoArr[j];
					maopaoArr[j] = maopaoArr[j + 1];
					maopaoArr[j + 1] = tmp;
				}
			}
		}

		System.out.println(Arrays.toString(maopaoArr));

		for (int i = 0; i < maopaoArr.length / 2; i++) {
			int tmp = maopaoArr[i];
			maopaoArr[i] = maopaoArr[maopaoArr.length - i - 1];
			maopaoArr[maopaoArr.length - i - 1] = tmp;
		}

		System.out.println(Arrays.toString(maopaoArr));

		int x = 100;
		System.out.println(x);
		x = 200;
		System.out.println(x);
		x = 300;
		System.out.println(x);

		int n = 100; // 定义变量n，同时赋值为100
		System.out.println("n = " + n); // 打印n的值

		n = 200; // 变量n赋值为200
		System.out.println("n = " + n); // 打印n的值

		int y = n; // 变量x赋值为n（n的值为200，因此赋值后y的值也是200）
		System.out.println("y = " + y); // 打印y的值

		y = y + 100; // 变量x赋值为y+100（y的值为200，因此赋值后y的值是200+100=300）
		System.out.println("y = " + y); // 打印y的值
		System.out.println("n = " + n); // 再次打印n的值，n应该是200还是300？

		int m = (100 + 200) * (50 + 32);
		int z = 7 * (6 + (m - 6234));
		System.out.println(m);
		System.out.println(z);

		int a = z / 53;
		System.out.println(a);
		int b = z % 53;
		System.out.println(b);

		char k = 'A';
		char l = '中';
		System.out.println(k);
		System.out.println(l);

		final double PI = 3.141592;
		double r = 5.0;
		double area = r * r * PI;

		System.out.println(area);

		var num = 9;
		System.out.println(num);

		var hello = new HelloWordJava();
		System.out.println(hello.toString());

		int d = m << 3;
		System.out.println(d);

		double p = 1.0 / 10;
		double o = 1 - 9.0 / 10;
		System.out.println(p);
		System.out.println(o);

		double value = Math.abs(p - o);
		if (value < 0.0001) {
			System.out.println("值是相等的");
		} else {
			System.out.println("不相等");
		}

		System.out.println("组合一下" + p + o + "!");

		String s = "hello";
		System.out.println(s); // 显示 hello
		s += " world";
		System.out.println(s); // 显示 world

		int[] arr = new int[5];
		arr[0] = 68;
		arr[1] = 79;
		arr[2] = 91;
		arr[3] = 85;
		arr[4] = 62;
		System.out.println(Arrays.toString(arr));

		double dd = 12900000;
		System.out.println(dd);

		System.out.printf("%.2f\n", p);
		System.out.printf("%.4f\n", o);

		// Java 12开始，switch语句升级为更简洁的表达式语法使用类似模式匹配（Pattern
		// Matching）的方法，保证只有一种路径会被执行，并且不需要break语句：
		int option = 1;
		switch (option) {
		case 1 -> System.out.println("Selected 1");
		case 2 -> System.out.println("Selected 2");
		case 3 -> System.out.println("Selected 3");
		default -> System.out.println("Selected none");
		}

		int sum = 0;
		int v = 0;
		while (v <= 100) {
			v++;
			sum = sum + v;
		}
		System.out.println(sum);

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Input your name: "); // 打印提示
			String name = scanner.nextLine(); // 读取一行输入并获取字符串
			System.out.print("Input your age: "); // 打印提示
			int age = scanner.nextInt(); // 读取一行输入并获取整数
			System.out.printf("Hi, %s, you age %d\n", name, age); // 格式化输出
		}
	}

}
