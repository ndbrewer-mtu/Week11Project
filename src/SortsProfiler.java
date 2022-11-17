import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * This is the ProfileSorts assignment.
 *
 * @author Nathan Brewer
 * CS1131, 11/16/2022
 * The Week11Project project.
 */
public class SortsProfiler {
	
	public static int numIterations = 10;
	
	public static long profile( Object[] arg, Consumer< Object[]> c){
		
		long start = System.currentTimeMillis();
		c.accept( arg );
		long end = System.currentTimeMillis();
		return end-start;
	}
	
	
	/**
	 * The main method is called auto-magically by Java to start the program.
	 * <Description here>
	 *
	 * @param args Contains a list of command-line arguments.
	 */
	public static void main( String[] args ) {
		String ele="Elements",mys="mysort", merg="mergesort",sel="selectionsort",ins="insertionsort",bub="bubblesort";
		System.out.printf("%15s  %15s  %15s  %15s  %15s  %15s%n",ele,mys,merg,sel,ins,bub);
		for(int i = 0; i <= 20; i++ ){
			int Elements = (int) Math.pow( 2,i );
			System.out.printf( "%15d",Elements ); // Elements in the List
			
			long my = 0; // my sort is not implemented yet.
			for(int j = 0 ; j < numIterations; j++){
				List<Integer> list = new Random().ints(Elements,-256,256).boxed().collect( Collectors.toList());
				Object[] arg = {list,0,list.size(), Sorts.SortOrder.ASCENDING};
				my += profile( arg, Sorts::mysort );
			}
			System.out.printf( "%15dms", my / numIterations);
			
			long Merge = 0;
			for(int j = 0 ; j < numIterations; j++){
				List<Integer> list = new Random().ints(Elements,-256,256).boxed().collect( Collectors.toList());
				Object[] arg = {list,0,list.size(), Sorts.SortOrder.ASCENDING};
				Merge += profile( arg, Sorts::mergesort );
			}
			System.out.printf( "%15dms", Merge / numIterations);
			
			long Insertion = 0;
			for(int j = 0 ; j < numIterations; j++){
				List<Integer> list = new Random().ints(Elements,-256,256).boxed().collect( Collectors.toList());
				Object[] arg = {list,0,list.size(), Sorts.SortOrder.ASCENDING};
				Insertion += profile( arg, Sorts::insertionsort );
			}
			System.out.printf( "%15dms", Insertion / numIterations);
			
			long Selection = 0;
			for(int j = 0 ; j < numIterations; j++){
				List<Integer> list = new Random().ints(Elements,-256,256).boxed().collect( Collectors.toList());
				Object[] arg = {list,0,list.size(), Sorts.SortOrder.ASCENDING};
				Selection += profile( arg, Sorts::selectionsort );
			}
			System.out.printf( "%15dms", Selection / numIterations);
			
			long Bubble = 0;
			for(int j = 0 ; j < numIterations; j++){
				List<Integer> list = new Random().ints(Elements,-256,256).boxed().collect( Collectors.toList());
				Object[] arg = {list,0,list.size(), Sorts.SortOrder.ASCENDING};
				Bubble += profile( arg, Sorts::bubblesort );
			}
			System.out.printf( "%15dms", Bubble / numIterations);
			
			System.out.println();
		}
		
		System.out.println("Finished");
	}
	
}
