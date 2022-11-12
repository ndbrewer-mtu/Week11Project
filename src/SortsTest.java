import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SortsTest {
	
	//Bubble Sort =====================================================
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
	}//Bubble Sort =====================================================
	
	//Insert Sort =====================================================
	@Test
	public void insertionsortNullArg() {
		List< Integer > start = null;
		List< Integer > list = null;
		try {
			Sorts.insertionsort(list,0,1,Sorts.SortOrder.DESCENDING);
			fail(String.format( "FAILED: insertionsort(%s) did not throw IllegalArgumentException",start));
		}catch ( IllegalArgumentException e ){
			//expected
		}
		catch ( Exception e ){
			fail(String.format( "FAILED: insertionsort(%s) threw %s",start,e));
		}
	}
	@Test
	public void insertionsort0() {
		List< Integer > start = new ArrayList<>( Arrays.asList( 5,4,3,2,1 ) );
		List< Integer > list = new ArrayList<>( Arrays.asList( 5,4,3,2,1 ) );
		List<Integer> expected = new ArrayList<>( Arrays.asList( 1,2,3,4,5 ) );
		Sorts.insertionsort(list,0,5,Sorts.SortOrder.ASCENDING);
		if(!list.equals( expected ))
			fail(String.format( "FAILED: insertionsort(%s) -> %s, expected: %s",start,list,expected ));
	}
	@Test
	public void insertionsort1() {
		List< Integer > start = new ArrayList<>( Arrays.asList( 1,2,3,4,5 ) );
		List< Integer > list = new ArrayList<>( Arrays.asList( 1,2,3,4,5 ) );
		List<Integer> expected = new ArrayList<>( Arrays.asList( 5,4,3,2,1 ) );
		Sorts.insertionsort(list,0,5,Sorts.SortOrder.DESCENDING);
		if(!list.equals( expected ))
			fail(String.format( "FAILED: insertionsort(%s) -> %s, expected: %s",start,list,expected ));
	}
	//Insert Sort =====================================================
	
	//Selection Sort =====================================================
	@Test
	public void selectionsortNullArg() {
		List< Integer > start = null;
		List< Integer > list = null;
		try {
			Sorts.selectionsort(list,0,1,Sorts.SortOrder.DESCENDING);
			fail(String.format( "FAILED: selectionsort(%s) did not throw IllegalArgumentException",start));
		}catch ( IllegalArgumentException e ){
			//expected
		}
		catch ( Exception e ){
			fail(String.format( "FAILED: selectionsort(%s) threw %s",start,e));
		}
	}
	@Test
	public void selectionsort0() {
		List< Integer > start = new ArrayList<>( Arrays.asList( 5,4,3,2,1 ) );
		List< Integer > list = new ArrayList<>( Arrays.asList( 5,4,3,2,1 ) );
		List<Integer> expected = new ArrayList<>( Arrays.asList( 1,2,3,4,5 ) );
		Sorts.selectionsort(list,0,5,Sorts.SortOrder.ASCENDING);
		if(!list.equals( expected ))
			fail(String.format( "FAILED: selectionsort(%s) -> %s, expected: %s",start,list,expected ));
	}
	@Test
	public void selectionsort1() {
		List< Integer > start = new ArrayList<>( Arrays.asList( 1,2,3,4,5 ) );
		List< Integer > list = new ArrayList<>( Arrays.asList( 1,2,3,4,5 ) );
		List<Integer> expected = new ArrayList<>( Arrays.asList( 5,4,3,2,1 ) );
		Sorts.selectionsort(list,0,5,Sorts.SortOrder.DESCENDING);
		if(!list.equals( expected ))
			fail(String.format( "FAILED: selectionsort(%s) -> %s, expected: %s",start,list,expected ));
	}
	//Selection Sort =====================================================
	
	//Merge Sort =====================================================
	@Test
	public void mergesortNullArg() {
		List< Integer > start = null;
		List< Integer > list = null;
		try {
			Sorts.mergesort(list,0,1,Sorts.SortOrder.DESCENDING);
			fail(String.format( "FAILED: mergesort(%s) did not throw IllegalArgumentException",start));
		}catch ( IllegalArgumentException e ){
			//expected
		}
		catch ( Exception e ){
			fail(String.format( "FAILED: mergesort(%s) threw %s",start,e));
		}
	}
	@Test
	public void mergesort0() {
		List< Integer > start = new ArrayList<>( Arrays.asList( 5,4,3,2,1,0 ) );
		List< Integer > list = new ArrayList<>( Arrays.asList( 5,4,3,2,1,0 ) );
		List<Integer> expected = new ArrayList<>( Arrays.asList( 0,1,2,3,4,5 ) );
		Sorts.mergesort(list,0,5,Sorts.SortOrder.ASCENDING);
		if(!list.equals( expected ))
			fail(String.format( "FAILED: mergesort(%s) -> %s, expected: %s",start,list,expected ));
	}
	@Test
	public void mergesort1() {
		List< Integer > start = new ArrayList<>( Arrays.asList( 1,2,3,4,5 ) );
		List< Integer > list = new ArrayList<>( Arrays.asList( 1,2,3,4,5 ) );
		List<Integer> expected = new ArrayList<>( Arrays.asList( 5,4,3,2,1 ) );
		Sorts.mergesort(list,0,5,Sorts.SortOrder.DESCENDING);
		if(!list.equals( expected ))
			fail(String.format( "FAILED: mergesort(%s) -> %s, expected: %s",start,list,expected ));
	}
	//Merge Sort =====================================================
	
	@Test
	public void mysort() {
	}
}