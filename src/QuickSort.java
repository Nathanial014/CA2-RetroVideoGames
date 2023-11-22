public class QuickSort {

    public static void quickSort(int[] a, int lowerIndex, int higherIndex) {
        int leftIndex = lowerIndex;
        int rightIndex = higherIndex;
        int pivot = a[lowerIndex+(higherIndex-lowerIndex)/2]; //Use middle as pivot (could use others)
        while(leftIndex<=rightIndex) { //Until left and right indices "cross over"
            while(a[leftIndex]<pivot) leftIndex++; //Move until left index elem not < pivot
            while(a[rightIndex]>pivot) rightIndex--; //Move until right index elem not > pivot
            if(leftIndex<=rightIndex) { //If indices haven't crossed over, swap the elements
                int swap=a[leftIndex];
                a[leftIndex]=a[rightIndex];
                a[rightIndex]=swap;
                //Move indices to next positions on both sides before continuing
                leftIndex++;
                rightIndex--;
            }
        }
        if(lowerIndex<rightIndex) quickSort(a,lowerIndex,rightIndex);
        if(leftIndex<higherIndex) quickSort(a,leftIndex,higherIndex);
    }


}
