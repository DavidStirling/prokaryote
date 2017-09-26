package org.cellprofiler.imageset.filter;

import org.cellprofiler.imageset.ImagePlaneDetailsStack;
import org.cellprofiler.imageset.Mocks;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Lee Kamentsky
 * 
 * Test all of the image predicates (color / monochrome / stack / stack frame)
 *
 */
public class TestImagePredicate {

	/**
	 * Test that the IPD with the given metadata key and value
	 * passes the filter
	 * 
	 * @param expression the filter expression
	 * @param key the metadata key
	 * @param value the value for the metadata key
	 */
	private void testPasses(String expression, ImagePlaneDetailsStack stack) {
		TestFilter.testSomething(expression, stack, true);
	}
	/**
	 * Test that the IPD with the given metadata key and value
	 * does not pass the filter
	 * 
	 * @param expression the filter expression
	 * @param key the metadata key
	 * @param value the value for the metadata key
	 */
	private void testDoesNotPass(String expression, ImagePlaneDetailsStack stack) {
		TestFilter.testSomething(expression, stack, false);
	}
	
	@Test
	public void testPasses() {
		testPasses("image does iscolor", Mocks.makeMockInterleavedStack());
		testPasses("image does iscolor", Mocks.makeMockColorStack(3));
		testPasses("image does ismonochrome", Mocks.makeMockMonochromeStack());
		testPasses("image does isstack", Mocks.makeMockColorStack(3));
		testPasses("image does isstackframe", Mocks.makeMockMonochromeStack());
	}
	@Test
	public void testDoesNotPass() {
		testDoesNotPass("image does iscolor", Mocks.makeMockMonochromeStack());
		testDoesNotPass("image does ismonochrome", Mocks.makeMockColorStack(3));
		testDoesNotPass("image does ismonochrome", Mocks.makeMockInterleavedStack());
		testDoesNotPass("image does isstack", Mocks.makeMockMonochromeStack());
		testDoesNotPass("image does isstack", Mocks.makeMockInterleavedStack());
		testDoesNotPass("image does isstackframe", Mocks.makeMockColorStack(3));
	}
}
