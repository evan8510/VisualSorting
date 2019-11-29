import java.awt.Color;
import java.awt.Graphics;

public class Bar implements Comparable{
	
	private int length, x, y, width=1;
	// max length is 400
	public Bar(int l, int xPos){
		length = l;
		x = xPos;
		y = 430 - length;
	}
	
	public void render(Graphics g){
		g.setColor(Color.white);
		g.fillRect(x, y, width, length);
		g.setColor(Color.black);
		//g.drawRect(x, y, width, length);
		g.fillRect(x, 30, width+1, 400-length);
	}
	
	@Override
	public int compareTo(Object bar) {
		return length - ((Bar)bar).getLength();
	}
	
	public int getLength(){
		return length;
	}
	
	public void setLength(int l){
		length = l;
		y=430-length;
	}
	
	public void swap(Bar b, Graphics g){
		int l = length;
		setLength(b.getLength());
		setLength(l);
		render(g);
		b.render(g);
	}
	
	
}
