package Library;

public class Counter {
	private int c = 0;
	public Counter() {}
	
	public int getCounter() {
		return c;
	}
	public void setCounter(int c) {
		this.c = c;
	}

	public void inc() {
		c++;
	}

	@Override
	public String toString() {
		return c+"";
	}
	
}
