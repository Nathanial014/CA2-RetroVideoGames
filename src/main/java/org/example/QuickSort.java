import java.util.Comparator;
import java.util.List;

public class QuickSort {
//
//    public static void quickSort(int[] a, int lowerIndex, int higherIndex) {
//        int leftIndex = lowerIndex;
//        int rightIndex = higherIndex;
//        int pivot = a[lowerIndex+(higherIndex-lowerIndex)/2]; //Use middle as pivot (could use others)
//        while(leftIndex<=rightIndex) { //Until left and right indices "cross over"
//            while(a[leftIndex]<pivot) leftIndex++; //Move until left index elem not < pivot
//            while(a[rightIndex]>pivot) rightIndex--; //Move until right index elem not > pivot
//            if(leftIndex<=rightIndex) { //If indices haven't crossed over, swap the elements
//                int swap=a[leftIndex];
//                a[leftIndex]=a[rightIndex];
//                a[rightIndex]=swap;
//                //Move indices to next positions on both sides before continuing
//                leftIndex++;
//                rightIndex--;
//            }
//        }
//        if(lowerIndex<rightIndex) quickSort(a,lowerIndex,rightIndex);
//        if(leftIndex<higherIndex) quickSort(a,leftIndex,higherIndex);
//    }
//
//    public static <T extends Comparable<T>> void quickSort(List<T> a, int lowerIndex, int higherIndex) {
//        int leftIndex = lowerIndex;
//        int rightIndex = higherIndex;
//        T pivot = a.get(lowerIndex+(higherIndex-lowerIndex)/2); //Use middle as pivot (could use others)
//        while(leftIndex<=rightIndex) { //Until left and right indices "cross over"
//            while(a.get(leftIndex).compareTo(pivot)<=0) leftIndex++; //Move until left index elem not < pivot
//            while(a.get(rightIndex).compareTo(pivot)>0) rightIndex--; //Move until right index elem not > pivot
//            if(leftIndex<=rightIndex) { //If indices haven't crossed over, swap the elements
//                int swap=a[leftIndex];
//                a[leftIndex]=a[rightIndex];
//                a[rightIndex]=swap;
//                //Move indices to next positions on both sides before continuing
//                leftIndex++;
//                rightIndex--;
//            }
//        }
//        if(lowerIndex<rightIndex) quickSort(a,lowerIndex,rightIndex);
//        if(leftIndex<higherIndex) quickSort(a,leftIndex,higherIndex);
//    }
//
//    /*
//        ArrayList<Game> games=...;
//        QuickSort.quickSort(games,(g1,g2)->g1.getTitle().compareTo(g2.getTitle());
//        QuickSort.quickSort(games,(g1,g2)->g1.getYear()-g2.getYer());
//
//     */
//    public static <T> void quickSort(List<T> a, Comparator<T> c){
//        quickSort(a,0,a.size()-1,c);
//    }
//    public static <T> void quickSort(List<T> a, int lowerIndex, int higherIndex, Comparator<T> c) {
//        int leftIndex = lowerIndex;
//        int rightIndex = higherIndex;
//        T pivot = a.get(lowerIndex+(higherIndex-lowerIndex)/2); //Use middle as pivot (could use others)
//        while(leftIndex<=rightIndex) { //Until left and right indices "cross over"
//            while(c.compare(a.get(leftIndex),pivot)<=0) leftIndex++; //Move until left index elem not < pivot
//            while(c.compare(a.get(rightIndex),pivot)>0) rightIndex--; //Move until right index elem not > pivot
//            if(leftIndex<=rightIndex) { //If indices haven't crossed over, swap the elements
//                int swap=a[leftIndex];
//                a.get(leftIndex)=a.get(rightIndex);
//                a.get(rightIndex)=swap;
//                //Move indices to next positions on both sides before continuing
//                leftIndex++;
//                rightIndex--;
//            }
//        }
//        if(lowerIndex<rightIndex) quickSort(a,lowerIndex,rightIndex,c);
//        if(leftIndex<higherIndex) quickSort(a,leftIndex,higherIndex,c);
//    }
//
//
}
