package maven_bild_tool.Java.src.test.java.com.github.vitalliuss.helloci;


import maven_bild_tool.Java.src.main.java.com.github.vitalliuss.helloci.App;
import maven_bild_tool.Java.src.main.java.com.github.vitalliuss.helloci.EmptyClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 * @author vitali_shulha
 */
public class AppTest {

	@Test
	public void testShouldBePassed() {
		assertTrue(true);
	}

	@Test
	public void testShouldBeFailed() {
		assertTrue(false);
	}

	@Ignore("Not implemented yet")
	@Test
	public void testShouldBeSKipped() {
		assertTrue(true);
	}
	
	@Test
	public void testAnotherMethod() {
		App.doNothing();
	}
	
	@Test
	public void testAnotherClass() {
		EmptyClass.emptyMethod();
	}
}
