class QuickSort {

    //Time Complexity: Worst - On^2. Average - N log N.

    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = (low-1);
        for(int j = low; j < high; j++){
            if(arr[j]< pivot){
                i++;
                //switch the arr elements
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[(i+1)];
        arr[(i+1)] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    static void sort(int[] arr, int low, int high){

       if(low < high){
        int part = partition(arr, low, high);

        sort(arr, low, part-1);
        sort(arr, part+1, high);
       }

    }
    public static void main(String[] args) {
        int[] tester = {3, 6, 10, 5, 25, 11, 13, 14, 2, 1};
        int n = tester.length; 
        sort(tester, 0, n-1);

        for (int i=0; i<n; ++i) 
            System.out.print(tester[i]+" "); 
    }

}