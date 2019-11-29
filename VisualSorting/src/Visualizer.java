import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Visualizer extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7186796350563341132L;

	/**
	 * 
	 */
	Bar b[]= new Bar[1300];
	
	boolean running = false;
	
	public Visualizer(){
		for(int i = 0; i<1300; i++){
			b[i] = new Bar((int) (Math.random()*400), i);
		}
		
		
		
		new GUI(this, 1300,700);
		
		
		
		running = true;
		run();
	}
	
	public static void main(String args[]){
		new Visualizer();
	}

	void render(){
		BufferStrategy bs = this.getBufferStrategy(); // BufferStrategy basically manages the window
		if(bs==null) {
			this.createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics(); 
		
		for(int i=0; i < 1300; i++){
			b[i].render(g); // 
		}
		g.dispose();
		bs.show();
		selectionSort(b);
		
		
		
		
	}
	
	@Override
	public void run() {
		this.requestFocus();
		long f = System.nanoTime();
		while(f-System.nanoTime()<1000){
		
		
		
		render();
		
		
		
		
		}
		
	}
	
	public void selectionSort(Bar[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = findMinimum(a, i);
            if (minIndex != i) //if lowest is not already in place
            {
            	BufferStrategy bs = this.getBufferStrategy(); // BufferStrategy basically manages the window
        		if(bs==null) {
        			this.createBufferStrategy(2);
        			return;
        		}
        		Graphics g = bs.getDrawGraphics(); 
                swap(a, i, minIndex);
                a[i].render(g);
                a[minIndex].render(g);
                g.dispose();
        		bs.show();
            }
        } //end for
    }

    public static int findMinimum(Bar[] a, int first) {
        //first=where to start looking from
        //assume first is also the smallest for now
        int minIndex = first;
        for (int i = first + 1; i < a.length; i++) {
            if (a[i].compareTo(a[minIndex]) < 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void swap(Bar[] a, int x, int y) {
        int temp = a[x].getLength();
        a[x].setLength(a[y].getLength());
        a[y].setLength(temp); 
    }
    
    
	
}
