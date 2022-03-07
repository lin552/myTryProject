package SortTest;

public class AlgorithmTest {

    public static int[] list;

    public static void main(String[] args) {
        list = new int[]{5, 2, 6, 3, 7, 8};
//        bubbleSort(list);
//        insertionSort(list);
//        bubbleSortBetter(list);
        selectionSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    //选择排序
    public static void selectionSort(int[] arr) {
        int temp, min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = 0; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    //快速排序
    public static void quickSort() {

    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //冒泡排序
    public static void bubbleSortBetter(int[] arr) {
        int temp = 0;
        boolean swap;
        for (int i = arr.length - 1; i > 0; i--) {
            swap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    //插入排序
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            int value = arr[i];
            int position = i;
            while (position > 0 && arr[position - 1] > value) {
                arr[position] = arr[position - 1];
                position--;
            }
            arr[position] = value;
        }
    }

    //归并排序
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        internalMergeSort(arr, temp, 0, arr.length - 1
        );
    }

    private static void internalMergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            internalMergeSort(arr, temp, left, right);
            internalMergeSort(arr, temp, middle + 1, right);
            mergeSortedArray(arr, temp, left, middle, right);
        }
    }

    private static void mergeSortedArray(int arr[], int temp[], int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= middle) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int l = 0; l < k; l++) {
            arr[left + l] = temp[l];
        }
    }

    //堆排序
    public static void heapSort() {

    }

}
