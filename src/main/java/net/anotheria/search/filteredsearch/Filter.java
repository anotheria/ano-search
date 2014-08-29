package net.anotheria.search.filteredsearch;

/**
 * A filter is a gate which lets only those Filterable pass, which are satisfying the criteria. 
 * There are simple filter (for example gender filter), which check for hardcoded values and 
 * customizeable filters, which check for parameterized values, i.e. age ranges.
 * @author lrosenberg
 * 
 * @param <T> type of the Filterable the Filter understands.
 */
public interface Filter<T extends Filterable> {
	/**
	 * Returns true if the Filterable object has passed the filter.
	 */
	public boolean mayPass(T toFilter);
	
	/**
	 * Returns the performance of the filter. Greater is better (faster). Fast filters are executed prior to the 
	 * @return
	 */
	public int getPerformance();
}
