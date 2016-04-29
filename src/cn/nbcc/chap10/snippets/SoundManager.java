/**
 * ��������cn.nbcc.chap10.snippets
 * �ļ�����SoundManager.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-27 ����12:59:14
 */
package cn.nbcc.chap10.snippets;
import java.io.File;
import javafx.embed.swt.FXCanvas;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class SoundManager implements IStatusChangeListener {
	private Media hit;
	private MediaPlayer mediaPlayer;
	private String bip;
	public SoundManager(Composite parent,int Style) {
		FXCanvas canvas = new FXCanvas(parent, SWT.NONE);
		Group group = new Group();
		Scene scene = new Scene(group, Color.rgb(
				parent.getBackground().getRed(), parent.getBackground()
						.getGreen(), parent.getBackground().getBlue()));
		
		canvas.setScene(scene);
	}

	@Override
	public void onStatusChange(MicrowaveOven oven) {
		switch (oven.getStatus()) {
		case FINISHED:
			bip = new File("Bell.mp3").toURI().toString();
			hit = new Media(bip);
			mediaPlayer = new MediaPlayer(hit);
			mediaPlayer.play();
			break;
		default:
			break;
		}

	}

}

