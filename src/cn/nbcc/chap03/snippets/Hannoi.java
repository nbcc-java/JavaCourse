/**
 * 所属包：cn.nbcc.chap03.snippets
 * 文件名：Hannoi.java
 * 创建者：郑哲
 * 创建时间：2014-2-7 下午02:17:43
 */
package cn.nbcc.chap03.snippets;
public class Hannoi {
	public static void main(String[] args) {
		int count = 4;
		tower(count,"A","B","C");
	}

	/**
	 * @param count:盘子数目
	 * @param pole1:原始位置
	 * @param pole2：移动辅助柱子
	 * @param pole3：目标柱子
	 */
	public static void tower(int count, String pole1, String pole2, String pole3) {

		if (count == 1)
			System.out.println("从" + pole1 + "搬动到" + pole3 );
		else {
			tower(count - 1, pole1, pole3, pole2);
			System.out.println("从" + pole1 + "搬动到" + pole3 );
			tower(count - 1, pole2, pole1, pole3);
		}
	}

}

