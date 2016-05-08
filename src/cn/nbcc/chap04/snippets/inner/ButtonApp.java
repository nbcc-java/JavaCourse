package cn.nbcc.chap04.snippets.inner;
public class ButtonApp{
	public static void main(String[] args) {
		SubmitButton sBtn = new SubmitButton();
		sBtn.onClick();
		
		ButtonClick lightBtn = new ButtonClick() {
			@Override
			public void onClick() {
				System.out.println("´ò¿ªµçµÆ");
			}
		};
	}
}