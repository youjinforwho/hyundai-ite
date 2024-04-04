package workshop05;

public class Test03 {
	public static void swap(int arr[], int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}
	public static void main(String[] args) {
		int[][] arr2 = {
				{20, 30, 10},
				{50, 40, 60},
				{80, 80, 90}
		};
		int arr_size = arr2.length * arr2[0].length;
		int idx = 0;
		int[] arr1 = new int[arr_size];
		for (int i =0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				arr1[idx] = arr2[i][j];
				idx ++;
			}
		}
		for (int i = 0; i < arr_size; i++) {
			for (int j = i + 1; j < arr_size; j++) {
				if (arr1[i] < arr1[j]) {
					swap(arr1, i, j);
				}
			}
		}
		for (int arr: arr1) {
			System.out.print(arr + " ");
		}
	}
}

