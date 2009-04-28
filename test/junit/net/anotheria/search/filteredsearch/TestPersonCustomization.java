package net.anotheria.search.filteredsearch;

import net.anotheria.search.filteredsearch.FilterCustomization;

public class TestPersonCustomization implements FilterCustomization{
	private int minAge;
	private int maxAge;
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
}
