import java.util.ArrayList;
import java.util.List;

public class Sorts {
   public enum SortOrder { ASCENDING, DESCENDING }

   public static <E extends Comparable<E>> void bubblesort ( List< E > list, int lowindex, int highindex, SortOrder sortOrder ) {
      if(list == null  || sortOrder == null || (highindex < lowindex)) throw new IllegalArgumentException();
      
      for(int k = 0; k < highindex; k++){
         for(int i = lowindex+1; i < highindex; i++){
            if(list.get( i ).compareTo( list.get(i-1) ) > 0 && sortOrder == SortOrder.ASCENDING){
               E data = list.get( i );
               list.set( i,list.get( i-1 ) );
               list.set( i-1,data );
            } else if(list.get( i ).compareTo( list.get(i-1) ) < 0 && sortOrder == SortOrder.DESCENDING){
               E data = list.get( i );
               list.set( i,list.get( i-1 ) );
               list.set( i-1,data );
            }
         }
      }
   }

   public static <E extends Comparable<E>> void insertionsort ( List< E > list, int lowindex, int highindex, SortOrder sortOrder ) {
      if(list == null  || sortOrder == null || (highindex < lowindex)) throw new IllegalArgumentException();
      for(int i = lowindex ; i < highindex; i++){
         E currentElement = list.get( i );
         int k;
         if(sortOrder == SortOrder.ASCENDING)
            for(k = i - 1; k >= lowindex && list.get( k ).compareTo( currentElement) > 0; k--)
               list.set( k+1, list.get( k ) );
         else
            for(k = i - 1; k >= lowindex && list.get( k ).compareTo( currentElement) < 0; k--)
               list.set( k+1, list.get( k ) );
         list.set( k+1,currentElement );
      }
   }

   public static <E extends Comparable<E>> void selectionsort ( List< E > list, int lowindex, int highindex, SortOrder sortOrder ) {
      if(list == null  || sortOrder == null || (highindex < lowindex)) throw new IllegalArgumentException();
     
      for (int currentIndex = lowindex; currentIndex < highindex - 1; currentIndex++)
      {
         int minIndex = currentIndex;
         for (int i = currentIndex + 1; i < highindex; i++)
         {
            if (list.get( i ).compareTo(list.get( minIndex )) < 0 && sortOrder == SortOrder.ASCENDING)
               minIndex = i;
            else if (list.get( i ).compareTo(list.get( minIndex )) > 0 && sortOrder == SortOrder.DESCENDING)
               minIndex = i;
         }
         if (minIndex != currentIndex)
         {
            E temp = list.get( currentIndex );
            list.set( currentIndex,list.get( minIndex ) );
            list.set( minIndex, temp );
         }
      }
   }

   public static <E extends Comparable> void mergesort ( List< E > list, int lowindex, int highindex, SortOrder sortOrder ) {
      if(list == null  || sortOrder == null || (highindex < lowindex)) throw new IllegalArgumentException();
      if(lowindex < highindex){
         int mid = ( lowindex + highindex ) / 2;
         
         mergesort( list,lowindex,mid,sortOrder );
         mergesort( list,mid+1,highindex,sortOrder );
         
         merge(list,lowindex,mid,highindex);
         System.out.println("\nExit Merge");
      }
   }
   private static <E extends Comparable> void merge( List< E > list, int start, int middle, int end ){
      System.out.println("Entered merge()\n");
      List<E> leftList = new ArrayList<>();
      List<E> rightList = new ArrayList<>();
      
      for(int i = 0; i < (middle - start + 1); i++){
         leftList.add( list.get( start+i ) );
         System.out.println("l I: " + i);
      }
      
      System.out.println("ll: "+leftList);
      
      for(int i = 0; i < (end - middle); i++){
         rightList.add( list.get( middle+1+i ) );
         System.out.println("r I: " + i);
      }
      
      System.out.println("rl: "+rightList);
      
      int left=0,right=0;
      
      int currentIndex = start;
      
      while(left < leftList.size() && right < rightList.size()){
         if(leftList.get( left ).compareTo( rightList.get( right ) ) <= 0){
            list.set(currentIndex,leftList.get( left ));
            System.out.println("l: "+list.get( currentIndex ));
            left++;
         }
         else {
            list.set( currentIndex, rightList.get(right) );
            System.out.println("r: "+list.get( currentIndex ));
            right++;
         }
         currentIndex++;
      }
      
      while(left < leftList.size()) list.set( currentIndex++, leftList.get(left++ ));
      while(right < rightList.size()) list.set( currentIndex++, rightList.get(right++ ));
      System.out.println("l: "+list);
   }

   public static <E extends Comparable<E>> void mysort ( List< E > list, int lowindex, int highindex, SortOrder sortOrder ) {
      if(list == null  || sortOrder == null || (highindex < lowindex)) throw new IllegalArgumentException();
      
   }
}