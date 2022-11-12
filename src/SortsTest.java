import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SortsTest {
	
	@Test
	public void bubblesort0() {
		List< Integer > start = new ArrayList<>( Arrays.asList( 5,4,3,2,1 ) );
		List< Integer > list = new ArrayList<>( Arrays.asList( 5,4,3,2,1 ) );
		List<Integer> expected = new ArrayList<>( Arrays.asList( 1,2,3,4,5 ) );
		Sorts.bubblesort(list,0,5,Sorts.SortOrder.DESCENDING);
		if(!list.equals( expected ))
			fail(String.format( "FAILED: bubblesort(%s) -> %s, expected: %s",start,list,expected ));
 	}
	@Test
	public void bubblesort1() {
		List< Integer > start = new ArrayList<>( Arrays.asList( 1,2,3,4,5 ) );
		List< Integer > list = new ArrayList<>( Arrays.asList( 1,2,3,4,5 ) );
		List<Integer> expected = new ArrayList<>( Arrays.asList( 5,4,3,2,1 ) );
		Sorts.bubblesort(list,0,5,Sorts.SortOrder.ASCENDING);
		if(!list.equals( expected ))
			fail(String.format( "FAILED: bubblesort(%s) -> %s, expected: %s",start,list,expected ));
	}
	@Test
	public void bubblesortNullArg() {
		List< Integer > start = null;
		List< Integer > list = null;
		try {
			Sorts.bubblesort(list,0,1,Sorts.SortOrder.DESCENDING);
			fail(String.format( "FAILED: bubblesort(%s) did not throw IllegalArgumentException",start));
		}catch ( IllegalArgumentException e ){
			//expected
		}
		catch ( Exception e ){
			fail(String.format( "FAILED: bubblesort(%s) threw %s",start,e));
		}
	}
	
	@Test
	public void insertionsort() {
	}
	
	@Test
	public void selectionsort() {
	}
	
	@Test
	public void mergesort() {
	}
	
	@Test
	public void mysort() {
	}
}