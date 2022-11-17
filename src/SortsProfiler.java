import java.util.List;
import java.util.Random;
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
	
	public static long profile( Object[] arg, Function< Object[], ? > f){
		
		long start = System.currentTimeMillis();
		f.apply( arg );
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
		System.out.println("Elements       bubblesort     ");
		for(int i = 0; i <= 20; i++ ){
			List<Integer> list = new Random().ints((int)Math.pow( 2,i ),-256,256).boxed().collect( Collectors.toList());
			
			Object[] arg = {list,0,list.size(), Sorts.SortOrder.ASCENDING};
			
			System.out.printf( "%d",1 );
			System.out.printf( "%10d", profile( arg, Sorts::mergesort ));
		}
		
		
	}
	
}
