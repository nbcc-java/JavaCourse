/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：ByteArrayInputOutputSnippet.java
 * 创建者：郑哲
 * 创建时间：2014-2-12 下午10:40:09
 */
package cn.nbcc.chap07.snippets;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class ByteArrayInputOutputSnippet {
	public static void main(String[] args) throws IOException {
		String dirName="C:\\";
		ByteArrayOutputStream baos=new ByteArrayOutputStream(1000);
		BufferedImage img=ImageIO.read(new File(dirName,"pic01.jpg"));
		ImageIO.write(img, "jpg", baos);
		baos.flush();
		baos.close();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		BufferedImage imag=ImageIO.read(bais);
		ImageIO.write(imag, "jpg", new File(dirName,"pic02.jpg"));
		bais.close();
	}
}

