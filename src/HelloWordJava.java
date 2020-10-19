
/**
 * 开始练习JAVA
 * 
 * @author conan
 * */

public class HelloWordJava {
	//Java入口程序规定的方法必须是静态方法，方法名必须为main，括号内的参数必须是String数组
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
	}

}
