import java.util.Arrays;
import java.util.Scanner;

/**
 * 开始练习JAVA
 * 
 * @author conan
 */

public class HelloWordJava {
	// Java入口程序规定的方法必须是静态方法，方法名必须为main，括号内的参数必须是String数组
	static public void main(String[] args) {
		/*
		 * 
		 * 
		 * */
		System.out.println("HelloWordJava!");

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

		Scanner scanner = new Scanner(System.in); // 创建Scanner对象

		System.out.print("Input your name: "); // 打印提示
		String name = scanner.nextLine(); // 读取一行输入并获取字符串
		System.out.print("Input your age: "); // 打印提示
		int age = scanner.nextInt(); // 读取一行输入并获取整数
		System.out.printf("Hi, %s, you age %d\n", name, age); // 格式化输出
	}

}
