/**
 * ��������cn.nbcc.chap04.snippets
 * �ļ�����App5.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-5 ����10:41:58
 */
package cn.nbcc.chap04.snippets;
public class App5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		ISpeakable[] arr = new ISpeakable[]{
//				new Chinese(),
//				new American(),
//				new Janpanese()
//		};
//		
//		for (int i = 0; i < arr.length; i++) {
//			arr[i].speak();	//��������̣���̬�����������ݰ󶨵Ķ���̬������Ӧ����
//			//�ӿڷ��������滻ԭ��
//		}
		
		
		Person p = new Person("����");
//		p.eat(new Apple());
		
		
		p.eat(new IEatable() {   //����
			
			@Override
			public String eatMethod() {
				return "���˳�";
			}
		}); //�ӿڵĺô�������չ
		
		
		
		

	}

}

