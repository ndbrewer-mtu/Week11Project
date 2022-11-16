import java.util.ArrayList;
import java.util.List;

/**
 * All sorts in this class are DESTRUCTIVE.
 * Meaning they destroy the array as they sort it.
 * If you want to prevent losing the previous unsorted data you should copy your array before calling any method in this class.
 */
public class Sorts {
   /**
    * Order to sort in.
    * <br><code>Ascending = -1</code><br><code>Descending = 1</code>
    */
   public enum SortOrder { 
      ASCENDING(-1),
      DESCENDING(1);
      public final int order;
      SortOrder(int order){
         this.order = order;
      }
   }
   
   /**
    * Sorts a List using Bubble sort Algorithm standard.
    * @param list List of elements to sort.
    * @param lowindex index to start sorting from. list[lowindex...highindex]. (inclusive)
    * @param highindex index to stop sorting at. list[lowindex...highindex]. (exclusive)
    * @param sortOrder order to sort in. [ASCENDING, DESCENDING].
    * @param <E> Generic type that extends Comparable.
    */
   public static <E extends Comparable<E>> void bubblesort ( List< E > list, int lowindex, int highindex, SortOrder sortOrder ) {
      if(list == null  || sortOrder == null || (highindex < lowindex)) throw new IllegalArgumentException();
      
      for(int k = 0; k < highindex; k++){
         for(int i = lowindex+1; i < highindex; i++){
            if(list.get( i ).compareTo( list.get(i-1) ) == sortOrder.order){// && sortOrder == SortOrder.ASCENDING){
               E data = list.get( i );
               list.set( i,list.get( i-1 ) );
               list.set( i-1,data );
            }
         }
      }
   }
   
   /**
    * Sorts a List using Bubble sort Algorithm standard.
    * Takes in object array as argument instead of 4 arguments.
    * Still only accepts up to 4 arguments in order of List, int, int, Sortorder. <br>
    * <br>
    * Throws IllegalArgumentExpecion if arg.length is not equal to 4 or if any of the arguments are null.
    * @param arg Objects array that should only contain 4 elements in order of List, int, int, Sortorder.
    * @param <E> Generic type that should extend Comparable.
    */
   public static <E extends Comparable<E>> void bubblesort(Object[] arg){
      if( arg.length != 4 )
         throw new IllegalArgumentException();
      for (Object o : arg)
         if(o == null)
            throw new IllegalArgumentException();
      
      List<E> arg0 = ( List< E > ) arg[0];
      
      bubblesort( arg0,(int) arg[1],(int) arg[2],(SortOrder ) arg[3] );
   }
   
   /**
    * Sorts a List using Insertion sort Algorithm standard.
    * @param list List of elements to sort.
    * @param lowindex index to start sorting from. list[lowindex...highindex]. (inclusive)
    * @param highindex index to stop sorting at. list[lowindex...highindex]. (exclusive)
    * @param sortOrder order to sort in. [ASCENDING, DESCENDING].
    * @param <E> Generic type that extends Comparable.
    */
   public static <E extends Comparable<E>> void insertionsort ( List< E > list, int lowindex, int highindex, SortOrder sortOrder ) {
      if(list == null  || sortOrder == null || (highindex < lowindex)) throw new IllegalArgumentException();
      for(int i = lowindex ; i < highindex; i++){
         E currentElement = list.get( i );
         int k;
         for(k = i - 1; k >= lowindex && list.get( k ).compareTo( currentElement) == -sortOrder.order; k--)
            list.set( k+1, list.get( k ) );
         list.set( k+1,currentElement );
      }
   }
   
   /**
    * Sorts a List using Insertion sort Algorithm standard.
    * Takes in object array as argument instead of 4 arguments.
    * Still only accepts up to 4 arguments in order of List, int, int, Sortorder.<br>
    * <br>
    * Throws IllegalArgumentExpecion if arg.length is not equal to 4 or if any of the arguments are null.
    * @param arg Objects array that should only contain 4 elements in order of List, int, int, Sortorder.
    * @param <E> Generic type that should extend Comparable.
    */
   public static <E extends Comparable<E>> void insertionsort(Object[] arg){
      if( arg.length != 4 )
         throw new IllegalArgumentException();
      for (Object o : arg)
         if(o == null)
            throw new IllegalArgumentException();
      
      List<E> arg0 = ( List< E > ) arg[0];
   
      insertionsort( arg0,(int) arg[1],(int) arg[2],(SortOrder ) arg[3] );
   }
   
   /**
    * Sorts a List using Selection sort Algorithm standard.
    * @param list List of elements to sort.
    * @param lowindex index to start sorting from. list[lowindex...highindex]. (inclusive)
    * @param highindex index to stop sorting at. list[lowindex...highindex]. (exclusive)
    * @param sortOrder order to sort in. [ASCENDING, DESCENDING].
    * @param <E> Generic type that extends Comparable.
    */
   public static <E extends Comparable<E>> void selectionsort ( List< E > list, int lowindex, int highindex, SortOrder sortOrder ) {
      if(list == null  || sortOrder == null || (highindex < lowindex)) throw new IllegalArgumentException();
     
      for (int currentIndex = lowindex; currentIndex < highindex - 1; currentIndex++)
      {
         int minIndex = currentIndex;
         for (int i = currentIndex + 1; i < highindex; i++)
            if (list.get( i ).compareTo(list.get( minIndex )) == sortOrder.order)
               minIndex = i;
         if (minIndex != currentIndex)
         {
            E temp = list.get( currentIndex );
            list.set( currentIndex,list.get( minIndex ) );
            list.set( minIndex, temp );
         }
      }
   }
   /**
    * Sorts a List using Selection sort Algorithm standard.
    * Takes in object array as argument instead of 4 arguments.
    * Still only accepts up to 4 arguments in order of List, int, int, Sortorder.<br>
    * <br>
    * Throws IllegalArgumentExpecion if arg.length is not equal to 4 or if any of the arguments are null.
    * @param arg Objects array that should only contain 4 elements in order of List, int, int, Sortorder.
    * @param <E> Generic type that should extend Comparable.
    */
   public static <E extends Comparable<E>> void selectionsort(Object[] arg){
      if( arg.length != 4 )
         throw new IllegalArgumentException();
      for (Object o : arg)
         if(o == null)
            throw new IllegalArgumentException();
      
      List<E> arg0 = ( List< E > ) arg[0];
   
      selectionsort( arg0,(int) arg[1],(int) arg[2],(SortOrder ) arg[3] );
   }
   
   /**
    * Sorts a List using Merge sort Algorithm standard.
    * @param list List of elements to sort.
    * @param lowindex index to start sorting from. list[lowindex...highindex]. (inclusive)
    * @param highindex index to stop sorting at. list[lowindex...highindex]. (exclusive)
    * @param sortOrder order to sort in. [ASCENDING, DESCENDING].
    * @param <E> Generic type that extends Comparable.
    */
   public static <E extends Comparable> void mergesort ( List< E > list, int lowindex, int highindex, SortOrder sortOrder ) {
      if(list == null  || sortOrder == null || (highindex < lowindex)) throw new IllegalArgumentException();
      if(lowindex < highindex){
         int mid = ( lowindex + highindex ) / 2;
         
         
         mergesort( list,lowindex,mid,sortOrder );
         mergesort( list,mid+1,highindex,sortOrder );
         
         merge(list,lowindex,mid,highindex,sortOrder);
      }
   }
   /**
    * Sorts a List using Merge sort Algorithm standard.
    * Takes in object array as argument instead of 4 arguments.
    * Still only accepts up to 4 arguments in order of List, int, int, Sortorder.<br>
    * <br>
    * Throws IllegalArgumentExpecion if arg.length is not equal to 4 or if any of the arguments are null.
    * @param arg Objects array that should only contain 4 elements in order of List, int, int, Sortorder.
    * @param <E> Generic type that should extend Comparable.
    */
   public static <E extends Comparable<E>> void mergesort(Object[] arg){
      if( arg.length != 4 )
         throw new IllegalArgumentException();
      for (Object o : arg)
         if(o == null)
            throw new IllegalArgumentException();
      
      List<E> arg0 = ( List< E > ) arg[0];
   
      mergesort( arg0, ( int ) arg[1], ( int ) arg[2], ( SortOrder ) arg[3] );
   }
   
   /**
    * Helper Method for mergesort. merges two arrays into one and places it back into the array. (destructive)
    * @param list List of elements to sort.
    * @param start index to start sorting from. list[start...middle]. (inclusive)
    * @param middle index that is a starting point or ending point for right and left respectively.
    * @param end index to stop sorting at. list[middle...end]. (exclusive)
    * @param sortOrder order to sort in. [ASCENDING, DESCENDING].
    * @param <E> Generic type that extends Comparable.
    */
   private static <E extends Comparable> void merge( List< E > list, int start, int middle, int end, SortOrder sortOrder ){
      
      List<E> leftList = new ArrayList<>();
      List<E> rightList = new ArrayList<>();
      
      for(int i = 0; i < (middle - start+1); i++){
         leftList.add( list.get( start+i ) );
      }
      
      for(int i = 0; i < (end - middle); i++){
         if(middle+1+i < list.size())
            rightList.add( list.get( middle+1+i ) );
         else
            rightList.add( list.get( list.size()-1-i ) );
      }
      
      
      int left=0,right=0;
      
      int currentIndex = start;
      
      while(left < leftList.size() && right < rightList.size()){
         int comparison = leftList.get( left ).compareTo( rightList.get( right ) );
         if((comparison > 0 && sortOrder == SortOrder.DESCENDING) || (sortOrder == SortOrder.ASCENDING && comparison <= 0)){
            list.set(currentIndex,leftList.get( left ));
            left++;
         }
         else {
            list.set( currentIndex, rightList.get(right) );
            right++;
         }
         currentIndex++;
      }
      
      while(left < leftList.size() && currentIndex < list.size()) list.set( currentIndex++, leftList.get(left++ ));
      while(right < rightList.size() && currentIndex < list.size()) list.set( currentIndex++, rightList.get(right++ ));
   }
   
   /**
    * Sorts a List using my sort Algorithm.
    * @param list List of elements to sort.
    * @param lowindex index to start sorting from. list[lowindex...highindex]. (inclusive)
    * @param highindex index to stop sorting at. list[lowindex...highindex]. (exclusive)
    * @param sortOrder order to sort in. [ASCENDING, DESCENDING].
    * @param <E> Generic type that extends Comparable.
    */
   public static <E extends Comparable<E>> void mysort ( List< E > list, int lowindex, int highindex, SortOrder sortOrder ) {
      if(list == null  || sortOrder == null || (highindex < lowindex)) throw new IllegalArgumentException();
      
   }
}