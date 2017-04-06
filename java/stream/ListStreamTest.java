import org.junit.*;
import java.util.*;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

public class ListStreamTest {

	List<String> coll;

	@Before
	public void init(){
		coll = Arrays.asList("1","2","3","4","5");
	}

	@Test
	public void simpleCollectionTest(){
		List<String> l1 = coll.stream().filter(st -> st.equals("3")).collect(Collectors.toList());
		List<String> l2 = coll.stream().filter(st -> st.equals("33")).collect(Collectors.toList());
		assertThat(l2.isEmpty(), is(true));

	}


}	
