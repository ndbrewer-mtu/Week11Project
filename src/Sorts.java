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
      
   }

   public static <E extends Comparable> void mergesort ( List< E > list, int lowindex, int highindex, SortOrder sortOrder ) {
      if(list == null  || sortOrder == null || (highindex < lowindex)) throw new IllegalArgumentException();
   }

   public static <E extends Comparable<E>> void mysort ( List< E > list, int lowindex, int highindex, SortOrder sortOrder ) {
      if(list == null  || sortOrder == null || (highindex < lowindex)) throw new IllegalArgumentException();
   }
}