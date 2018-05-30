//堆大小用size表示越界不越界
//改变堆的数据，
package basic_class_01;

import java.util.Arrays;

public class Code_03_HeapSort {

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		
		//循环加入数组，实现完全二叉树，大根堆
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}//循环完后数组已经变成无序大根堆，根节点[0]为数组最大值
		
		int size = arr.length; //大根堆节点数
		swap(arr, 0, --size); //交换根节点与最右子节点，大根堆数-1
		while (size > 0) {
			heapify(arr, 0, size); //根节点变化，因此重新调整大根堆
			swap(arr, 0, --size);  //继续交换新的根节点和新的最末子节点，大根堆数-1
		}
	}

	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {//设置[0]的父还是[0]循环，上浮到根节点会自己跳出循环
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	public static void heapify(int[] arr, int index, int size) {//堆大小是0~size-1
		int left = index * 2 + 1;//左孩子
		while (left < size) {//如果当前位置还有孩子循环发生
			//left+1右孩子，选出孩子中最大值的下标
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			
			//父和刚才选的孩子比较，选出最大值的下标
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) { //选出来的最大值和父相等
				break;
			}
			
			//孩子大，则交换
			swap(arr, largest, index);
			index = largest; //索引变为以前最大的孩子的那个位置，也就是现在的我，我往下沉了，继续往下找孩子
			left = index * 2 + 1;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
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

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			heapSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		heapSort(arr);
		printArray(arr);
	}

}
