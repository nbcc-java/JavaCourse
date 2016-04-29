package cn.nbcc.chap05.snippets;
public class Cylinder extends Circle {
	private int height;
	public Cylinder(int x, int y, int r) {
		super(x, y, r);
	}
	public Cylinder(int x,int y,int r,int h)
	{
		this(x,y,r);
		this.height = h;
	}
	@Override
	public String toString() {
		return String.format("%s,h=%d", super.toString(),height);
	}
}

