public class Bubblesort {
    
    //Time - worst: n^2. av: n^2

    void sort(int[] arr){
        int size = arr.length;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < (size-i-1); j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args){
        Bubblesort bees = new Bubblesort();

        int[] test = {2, 7, 8, 3, 4, 10, 20};

        bees.sort(test);

        for(int i = 0; i < test.length; i++){
            System.out.println(test[i] + " ");
        }
    }
}
