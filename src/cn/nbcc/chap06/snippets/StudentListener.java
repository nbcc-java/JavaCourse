/**
 * ��������cn.nbcc.chap06.snippets
 * �ļ�����StudentListener.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-19 ����11:25:10
 */
package cn.nbcc.chap06.snippets;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class StudentListener implements SelectionListener {

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		
		System.out.println("ѧ�����ð�ť������ʱ������һ��");

	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {

	}

}

