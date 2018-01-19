
public class SelectionSort implements SortStrategy{
	long startTime;
	long endTime;
	
	public long getSortTime() {
		long totalTime = endTime - startTime;
		return totalTime;
	}
	public long[] sort(long[] ar) {
		startTime = System.currentTimeMillis();
		for (int i = 0; i < ar.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < ar.length; j++)
				if (ar[j] < ar[min])
					min = j;
			long temp = ar[i];
			ar[i] = ar[min];
			ar[min] = temp;
		}
		endTime = System.currentTimeMillis();
		return ar;
	}
	public String getStrategyName() {
		return "Selection Sort";
	}
}
