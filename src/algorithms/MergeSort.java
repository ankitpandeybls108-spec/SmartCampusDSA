package algorithms;

public class MergeSort {

    public static void sort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(
            int[] arr,
            int left,
            int right) {

        if (left >= right) {
            return;
        }

        int mid =
                left + (right - left) / 2;

        mergeSort(arr, left, mid);

        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(
            int[] arr,
            int left,
            int mid,
            int right) {

        int[] temp =
                new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j]) {

                temp[k] = arr[i];
                i++;

            } else {

                temp[k] = arr[j];
                j++;
            }

            k++;
        }

        while (i <= mid) {

            temp[k] = arr[i];

            i++;
            k++;
        }

        while (j <= right) {

            temp[k] = arr[j];

            j++;
            k++;
        }

        for (int x = 0; x < temp.length; x++) {

            arr[left + x] = temp[x];
        }
    }
}