import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.ArrayList;
import java.util.List;

public class Sorts {
   public enum SortOrder { 
      ASCENDING(1),
      DESCENDING(-1);
      public final int order;
      SortOrder(int order){
         this.order = order;
      }
   }

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

   public static <E extends Comparable<E>> void insertionsort ( List< E > list, int lowindex, int highindex, SortOrder sortOrder ) {
      if(list == null  || sortOrder == null || (highindex < lowindex)) throw new IllegalArgumentException();
      for(int i = lowindex ; i < highindex; i++){
         E currentElement = list.get( i );
         int k;
         for(k = i - 1; k >= lowindex && list.get( k ).compareTo( currentElement) == sortOrder.order; k--)
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
            if (list.get( i ).compareTo(list.get( minIndex )) == -sortOrder.order)
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
         
         merge(list,lowindex,mid,highindex,sortOrder);
      }
   }
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

   public static <E extends Comparable<E>> void mysort ( List< E > list, int lowindex, int highindex, SortOrder sortOrder ) {
      if(list == null  || sortOrder == null || (highindex < lowindex)) throw new IllegalArgumentException();
      
   }
}