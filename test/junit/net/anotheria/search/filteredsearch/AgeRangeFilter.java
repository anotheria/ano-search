package net.anotheria.search.filteredsearch;

import net.anotheria.search.filteredsearch.CustomizeableFilter;
import net.anotheria.search.filteredsearch.FilterCustomization;
import net.anotheria.search.filteredsearch.FilterPerformance;

public class AgeRangeFilter implements CustomizeableFilter<TestPerson>{
	
	private int minAge;
	private int maxAge;

	public void customize(FilterCustomization customization) {
		minAge = ((TestPersonCustomization)customization).getMinAge();
		maxAge = ((TestPersonCustomization)customization).getMaxAge();
		
	}

	public int getPerformance() {
		return FilterPerformance.FAST;
	}

	public boolean mayPass(TestPerson toFilter) {
		return toFilter.getAge()<=maxAge && toFilter.getAge()>=minAge;
	}

}
