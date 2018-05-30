package basic_class_01;

public class Code_08_NetherlandsFlag {

	public static int[] partition(int[] arr, int l, int r, int p) {//返回整形数组
		int less = l - 1; //小于区的右边界
		int more = r + 1;
		while (l < more) {//当前位置不和大于区域撞上的时候，我就执行
			if (arr[l] < p) { //当前数小于p
				swap(arr, ++less, l++);//先交换当前数和小于区域的下一个数less+1，交换完后小于区跳下一个位置，当前位置也跳下一个
			} else if (arr[l] > p) {//当前数大于p则
				swap(arr, --more, l);  //交换当前数和大于区前一个位置的数，大于区向左扩，l已经被换数，不再增加位置
			} else {
				l++; //是个索引，指针，index，等于p则指针直接指下一个
			}
		}
		return new int[] { less + 1, more - 1 };//返回的是排序后数组的等于区边界
	}

	// for test
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 3);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] test = generateArray();

		printArray(test);
		int[] res = partition(test, 0, test.length - 1, 1);
		printArray(test);
		System.out.println(res[0]);//返回数组等于区的边界
		System.out.println(res[1]);

	}
}
