package org.cellprofiler.imageset.filter;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Leek
 *
 */
public class IsJPEGPredicate extends AbstractTerminalPredicate<String> {
	final static public String SYMBOL = "isjpeg";
	final static private Set<String> jpegExtensions = 
		Collections.unmodifiableSet(
				new HashSet<String>(Arrays.asList("jpg", "jpeg")));
	public IsJPEGPredicate() {
		super(String.class);
	}

	/* (non-Javadoc)
	 * @see org.cellprofiler.imageset.filter.FilterPredicate#getSymbol()
	 */
	public String getSymbol() {
		return SYMBOL;
	}

	/* (non-Javadoc)
	 * @see org.cellprofiler.imageset.filter.FilterPredicate#eval(java.lang.Object)
	 */
	public boolean eval(String candidate) {
		return jpegExtensions.contains(candidate.toLowerCase());
	}

}
