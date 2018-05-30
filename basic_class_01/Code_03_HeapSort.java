//�Ѵ�С��size��ʾԽ�粻Խ��
//�ı�ѵ����ݣ�
package basic_class_01;

import java.util.Arrays;

public class Code_03_HeapSort {

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		
		//ѭ���������飬ʵ����ȫ�������������
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}//ѭ����������Ѿ�����������ѣ����ڵ�[0]Ϊ�������ֵ
		
		int size = arr.length; //����ѽڵ���
		swap(arr, 0, --size); //�������ڵ��������ӽڵ㣬�������-1
		while (size > 0) {
			heapify(arr, 0, size); //���ڵ�仯��������µ��������
			swap(arr, 0, --size);  //���������µĸ��ڵ���µ���ĩ�ӽڵ㣬�������-1
		}
	}

	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {//����[0]�ĸ�����[0]ѭ�����ϸ������ڵ���Լ�����ѭ��
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	public static void heapify(int[] arr, int index, int size) {//�Ѵ�С��0~size-1
		int left = index * 2 + 1;//����
		while (left < size) {//�����ǰλ�û��к���ѭ������
			//left+1�Һ��ӣ�ѡ�����������ֵ���±�
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			
			//���͸ղ�ѡ�ĺ��ӱȽϣ�ѡ�����ֵ���±�
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) { //ѡ���������ֵ�͸����
				break;
			}
			
			//���Ӵ��򽻻�
			swap(arr, largest, index);
			index = largest; //������Ϊ��ǰ���ĺ��ӵ��Ǹ�λ�ã�Ҳ�������ڵ��ң������³��ˣ����������Һ���
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