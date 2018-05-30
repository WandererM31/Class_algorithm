package basic_class_01;

public class Code_08_NetherlandsFlag {

	public static int[] partition(int[] arr, int l, int r, int p) {//������������
		int less = l - 1; //С�������ұ߽�
		int more = r + 1;
		while (l < more) {//��ǰλ�ò��ʹ�������ײ�ϵ�ʱ���Ҿ�ִ��
			if (arr[l] < p) { //��ǰ��С��p
				swap(arr, ++less, l++);//�Ƚ�����ǰ����С���������һ����less+1���������С��������һ��λ�ã���ǰλ��Ҳ����һ��
			} else if (arr[l] > p) {//��ǰ������p��
				swap(arr, --more, l);  //������ǰ���ʹ�����ǰһ��λ�õ�������������������l�Ѿ�����������������λ��
			} else {
				l++; //�Ǹ�������ָ�룬index������p��ָ��ֱ��ָ��һ��
			}
		}
		return new int[] { less + 1, more - 1 };//���ص������������ĵ������߽�
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
		System.out.println(res[0]);//��������������ı߽�
		System.out.println(res[1]);

	}
}
