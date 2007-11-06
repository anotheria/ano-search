package test.custom;

import net.anotheria.search.filteredsearch.Filter;
import net.anotheria.search.filteredsearch.FilterPerformance;

public abstract class GenderFilter implements Filter<TestPerson>{

	public int getPerformance() {
		return FilterPerformance.SUPERFAST;
	}

	public boolean mayPass(TestPerson toFilter) {
		return toFilter.isMale()==requiredMale();
	}
	
	protected abstract boolean requiredMale();
	
}
