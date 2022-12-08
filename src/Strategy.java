import java.util.Arrays;

public class Strategy {
    public static void main(String[] args) {
        StrategyClient c = new StrategyClient();
        int[] arr0 = {1,3,2,1};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr0);

        int[] arr1 = {11,4,2,7,54};
        c.setStrategy(new SelectionSort());
        c.executeStrategy(arr1);
    }
}

class StrategyClient{
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] arr){
        strategy.sort(arr);
    }
}
interface Sorting{
    void sort(int[]arr);
}

class BubbleSort implements Sorting{
    @Override
    public void sort(int[] arr) {
        System.out.println("Bubble sort");
        System.out.println("Before: \t" + Arrays.toString(arr));
        for (int i = arr.length -1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println("After: \t" + Arrays.toString(arr));
    }
}

class SelectionSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("Selection sort");
        System.out.println("Before: \t" + Arrays.toString(arr));
        for (int barier = 0; barier < arr.length-1; barier++) {
            for (int i = barier+1; i < arr.length; i++) {
                if(arr[i] < arr[barier]){
                    int tmp = arr[i];
                    arr[i] = arr[barier];
                    arr[barier] = tmp;
                }
            }
        }

        System.out.println("After: \t" + Arrays.toString(arr));
    }
}



