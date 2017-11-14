package assignment7;

//1.
public class MaxThread extends Thread {
	private int lo, hi;
	private int[] arr;
	private int max;
	
	public MaxThread(int[] arr, int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
		this.arr = arr;
		max = arr[lo];
	}
	
	@Override
	public void run() {
		for(int i = lo; i <= hi; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
	}
	
    /**
     * Find the largest element of an array.
     * 
     * @param arr array 
     * @return largest of the array's elements
     * @throws InterruptedException shouldn't happen
     */
	public static int max(int[] arr) throws InterruptedException {
		int len = arr.length;
		int max = 0;
	
		//Create and start 4 threads.
		MaxThread[] ts = new MaxThread[4];
		for(int i = 0; i < 4; i++) {
			ts[i] = new MaxThread(arr, (i * len) / 4, ((i + 1) * len / 4));
			ts[i].start();
		}
		
		// Wait for the threads to finish and sum their results.
		for(int i = 0; i < 4; i++) {
			ts[i].join();
			max = ts[i].max;
		}
		
		return max;
	}
	
	public static void main(String[] args) throws InterruptedException {
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		
		int max = max(arr);
		System.out.println("Max: " + max);
	}
}