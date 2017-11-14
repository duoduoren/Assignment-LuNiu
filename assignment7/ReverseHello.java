package assignment7;

// 2.
public class ReverseHello implements Runnable {
	
	int num;
	
	ReverseHello(int num) {
		this.num = num;
	}
	
	public void run() {
		System.out.println("Hello from Thread " + num + "!");
		if (this.num == 1) {
			return;
		}
		
		(new Thread(new ReverseHello(this.num - 1))).start();
	}
	
	public static void main(String[] args) {
		(new Thread(new ReverseHello(50))).start();
	}
}
