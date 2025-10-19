package experiment2;

import java.util.Random;

public class StopWatch {
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void end() {
        endTime = System.nanoTime();
    }

    @Override
    public String toString() {
        return String.valueOf((endTime - startTime) / 1000000 + "ms");
    }
}

class Sort {
    int[] arr;

    private void quickSortImpl(int startIndex, int endIndex) {
        if (startIndex >= endIndex || startIndex < 0 || endIndex >= arr.length)
            return;

        int i = startIndex;
        int j = endIndex;

        Random rand = new Random();
        int pivot = arr[startIndex + rand.nextInt(endIndex - startIndex + 1)];

        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++i;
                --j;
            }
        }

        if (startIndex < j) {
            quickSortImpl(startIndex, j);
        }
        if (i < endIndex) {
            quickSortImpl(i, endIndex);
        }
    }

    public Sort(int[] arr) {
        this.arr = arr;
    }

    public void quickSort() {
        quickSortImpl(0, arr.length - 1);
    }

    public int[] getArr() {
        return arr;
    }

    public void popSort() {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = 1000000;
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = rand.nextInt();
        }

        Sort qs = new Sort(arr);

        StopWatch timer = new StopWatch();

        timer.start();
        qs.quickSort();
        timer.end();
        //arr=qs.getArr();
        System.out.println(timer);
/*
        qs = new Sort(arr);
        timer.start();
        qs.popSort();
        timer.end();
        //arr=qs.getArr();
        System.out.println(timer);

 */
    }
}
