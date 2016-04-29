/**
 * 所属包：cn.nbcc.chap02.finished
 * 文件名：Helper.java
 * 创建者：郑哲
 * 创建时间：2014-4-28 上午09:51:35
 */
package cn.nbcc.chap02.finished;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Helper {
	private static final String CONFIG_FILE_PATH = "./config.xml";
	private static final int DEFAULT_LIMIT_COUNT = 3;
	private static final int DEFAULT_LOW_PRICE = 0;
	private static final int DEFAULT_HIGH_PRICE = 100;
	private static String hPrice;
	private static String lPrice;
	private static String lCount;
	
	public static void loadData(){
		readFromXML();
	}
	public static void readFromXML() {
		SAXBuilder sb = new SAXBuilder();
		Document doc = null;
		File file = new File(CONFIG_FILE_PATH);
		try {
			doc = sb.build(file);
			if (doc!=null) {
				Element root = doc.getRootElement();
				hPrice = root.getChild("HighPrice").getText();
				lPrice = root.getChildText("LowPrice");
				lCount = root.getChildText("LimitCount");
				
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static int getHighPrice() {
		if (hPrice!=null) {
			return Integer.parseInt(hPrice);
		}
		return DEFAULT_HIGH_PRICE;
	}
	public static int getLowPrice() {
		if (lPrice!=null) {
			return Integer.parseInt(lPrice);
		}
		return DEFAULT_LOW_PRICE;
	}
	public static int getLimitCount() {
		if (lCount!=null) {
			return Integer.parseInt(lCount);
		}
		return DEFAULT_LIMIT_COUNT;
	}
	public static void setHighPrice(String hPrice) {
		Helper.hPrice = hPrice;
	}
	public static void setLowPrice(String lPrice) {
		Helper.lPrice = lPrice;
	}
	public static void setLimitCount(String lCount) {
		Helper.lCount = lCount;
	}
	/**
	 * 保存到XML配置文档中
	 * @return true：保存成功；false：保存失败
	 */
	public static boolean saveToXML() {
		Element root = new Element("Game");
		Document document = new Document(root);
		root.addContent(new Element("LowPrice").addContent(lPrice));
		root.addContent(new Element("HighPrice").addContent(hPrice));
		root.addContent(new Element("LimitCount").addContent(lCount));
		XMLOutputter output = new XMLOutputter(Format.getPrettyFormat());
		try {
			File file = new File(CONFIG_FILE_PATH);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file);
			output.output(document,writer);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

