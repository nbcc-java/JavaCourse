package cn.nbcc.chap04.snippets;
public class App2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Person p = new Person("����");
		WhiteHorse wHorse = new WhiteHorse("����");
		
		Horse aHorse = new WhiteHorse("����");//��������
//		p.drive(wHorse);	
		//�����������������滻ԭ��һ�����������Ա��浽��������ñ����
		//��������ñ������ܱ��游�����
		
//		WhiteHorse whiteHorse = new Horse("��");
		
		BlackHorse bHorse = new BlackHorse("����");
//		p.drive(bHorse);
		
		Horse horses[] =new Horse[10];
		
		for (int i = 0; i < horses.length; i++) {
			if ((int)(Math.random()*2)==0) {
				horses[i]=new WhiteHorse("����");
			}else
				horses[i]=new BlackHorse("����");
			
			p.drive(horses[i]);//��������̣�����������ԣ�����չ�ԣ�ͳһ���
		}
		
		

	}

}

