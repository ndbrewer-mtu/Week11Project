import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This is the ProfileSorts assignment.
 * <Description here>
 *
 * @author Nathan Brewer
 * <p>
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
		String ele="Elements", merg="mergesort",sel="selectionsort",ins="insertionsort";
		System.out.printf("%15s  %15s  %15s  %15s%n",ele,merg,sel,ins);
		for(int i = 0; i <= 20; i++ ){
			System.out.printf( "%15d",(int) Math.pow( 2,i ) );
			long Merge = 0;
			for(int j = 0 ; j < numIterations; j++){
				List<Integer> list = new Random().ints((int)Math.pow( 2,i ),-256,256).boxed().collect( Collectors.toList());
				Object[] arg = {list,0,list.size(), Sorts.SortOrder.ASCENDING};
				Merge += profile( arg, Sorts::mergesort );
			}
			System.out.printf( "%15dms", Merge / numIterations);
			
			long Insertion = 0;
			for(int j = 0 ; j < numIterations; j++){
				List<Integer> list = new Random().ints((int)Math.pow( 2,i ),-256,256).boxed().collect( Collectors.toList());
				Object[] arg = {list,0,list.size(), Sorts.SortOrder.ASCENDING};
				Insertion += profile( arg, Sorts::insertionsort );
			}
			System.out.printf( "%15dms", Insertion / numIterations);
			
			long Selection = 0;
			for(int j = 0 ; j < numIterations; j++){
				List<Integer> list = new Random().ints((int)Math.pow( 2,i ),-256,256).boxed().collect( Collectors.toList());
				Object[] arg = {list,0,list.size(), Sorts.SortOrder.ASCENDING};
				Selection += profile( arg, Sorts::selectionsort );
			}
			System.out.printf( "%15dms", Selection / numIterations);
			
			
			
			System.out.println();
		}
		
		
	}
	
}
