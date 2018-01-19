
public class InsertionSort implements SortStrategy{
	long startTime;
	long endTime;

	public long getSortTime() {
		long totalTime = endTime - startTime;
		return totalTime;
	}
	public long[] sort(long[] ar) {
		startTime = System.currentTimeMillis();
		for (int i = 1; i < ar.length; i++) {
			long index = ar[i];
			int j = i;
			while (j > 0 && ar[j - 1] > index) {
				ar[j] = ar[j - 1];
				j--;
			}
			ar[j] = index;
		}
		endTime = System.currentTimeMillis();
		return ar;
	}
	public String getStrategyName() {
		return "Insertion Sort";
	}
}
