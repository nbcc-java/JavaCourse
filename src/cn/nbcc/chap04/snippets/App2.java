package cn.nbcc.chap04.snippets;
public class App2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Person p = new Person("张三");
		WhiteHorse wHorse = new WhiteHorse("白马");
		
		Horse aHorse = new WhiteHorse("白马");//白马是马
//		p.drive(wHorse);	
		//骑白马就是骑马，里氏替换原则，一个子类对象可以保存到父类的引用变量里。
		//子类的引用变量不能保存父类对象
		
//		WhiteHorse whiteHorse = new Horse("马");
		
		BlackHorse bHorse = new BlackHorse("黑马");
//		p.drive(bHorse);
		
		Horse horses[] =new Horse[10];
		
		for (int i = 0; i < horses.length; i++) {
			if ((int)(Math.random()*2)==0) {
				horses[i]=new WhiteHorse("白马");
			}else
				horses[i]=new BlackHorse("黑马");
			
			p.drive(horses[i]);//面向抽象编程，增加了灵活性，可扩展性，统一编程
		}
		
		

	}

}

