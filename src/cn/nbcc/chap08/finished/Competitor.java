/**
 * 所属包：cn.nbcc.chap08.snippets
 * 文件名：Competitor.java
 * 创建者：郑哲
 * 创建时间：2014-5-20 下午08:59:41
 */
package cn.nbcc.chap08.finished;
public abstract class Competitor extends Thread {
	enum ResultStatus {
		WIN,LOSE
	}
	protected int stepLen;	//每步宽度
	protected int curStep;	//当前的位置
	protected String name;
	protected ResultStatus status;//比赛结果
	private int fieldLen;
	protected static volatile boolean isFinished = false;//比赛结束标识
	public abstract void goForward();
	public Competitor(String name,int stepLen, int fieldLen) {
		super();
		this.stepLen = stepLen;
		this.fieldLen = fieldLen;
		this.name = name;
	}
	public int getCurStep() {
		return curStep;
	}
	@Override
	public void run() {
		while (!isFinished) {
			if (curStep<fieldLen) {
				try {
					Thread.sleep(1000);
					goForward();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				isFinished = true;
				status = ResultStatus.WIN;
			}
		}
	}
	public ResultStatus getResultStatus() {
		return status;
	}
}

