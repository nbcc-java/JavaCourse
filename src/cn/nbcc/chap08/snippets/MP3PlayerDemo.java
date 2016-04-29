/**
 * ��������cn.nbcc.chap08.snippets
 * �ļ�����MP3PlayerDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-16 ����10:49:45
 */
package cn.nbcc.chap08.snippets;

import java.io.File;

import javafx.embed.swt.FXCanvas;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MP3PlayerDemo {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("����MP3ʾ��");
		shell.setLayout(new FillLayout());
		Group group = new Group();
		//�ȴ���FXCanvas �ٴ���Scence���ܿ���FX application thread
		FXCanvas canvas = new FXCanvas(shell, SWT.NONE);
		Scene scene = new Scene(group,Color.rgb(shell.getBackground().getRed(), 
				shell.getBackground().getGreen(), shell.getBackground().getBlue()));
		String bip = new File("invite1.mp3").toURI().toString();
		Media hit = new Media(bip);
		MediaPlayer mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.play();
		canvas.setScene(scene);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}

