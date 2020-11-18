public class Mergesort {

    //time - worst: n log n. average: n log n.

    static void merge(int[] arr, int mid, int left, int right){
        //find size of each array
        int n1 = (mid-left)+1;
        int n2 = (right - mid);

        //make 2 temp arrays
        int[] lef = new int[n1];
        int[] rig = new int[n2];

        //copy arr to temp arr
        for(int i = 0; i<n1; ++i){
            lef[i] = arr[left+i];
        }
        for(int j = 0; j<n2; ++j){
            rig[j] = arr[mid + left + j];
        }

        int i = 0; 
        int j = 0; 
        int k = left;

        while(i < n1 && j < n2){
            if(lef[i] <= rig[j]){
                arr[k]=lef[i];
                i++;
            }else{
                arr[k] = rig[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = lef[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k]= rig[j];
            j++;
            k++;
        }
    }

    static void sort(int[] arr, int left, int right){

        if(left < right){
            //find mid
            int m = (left + right)/2;

            //sort both halves
            sort(arr, left, m);
            sort(arr, (m+1), right);

            //merge halves
            merge(arr, m, left, right);
        }

    }

    public static void main(String[] args){
        int[] test = {6, 8, 2, 4, 10, 22, 21, 3, 1};
        sort(test, 0, test.length-1);

        for (int i = 0; i < test.length; ++i) System.out.print(test[i] + " ");
        
    }
    
}
