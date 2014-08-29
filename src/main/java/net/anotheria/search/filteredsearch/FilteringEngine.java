package net.anotheria.search.filteredsearch;

import java.util.List;
/**
 * This interface defines a filtering engine.
 * @author lrosenberg
 *
 * @param <T> the type of Filterable this engine is instantiated to work with.
 */
public interface FilteringEngine<T extends Filterable> {
	/**
	 * Filter previously set data with previously set filter set.
	 * @param customization
	 * @return
	 */
	List<T> filter(FilterCustomization customization);
	
	List<T> filter(List<T> data, FilterCustomization customization);

	List<T> filter(FilterCustomization customization, List<Filter<T>> filters);

	List<T> filter(List<T> data, List<Filter<T>> filters, FilterCustomization customization);

	List<T> filter(FilterCustomization customization, int maxHits);
	
	/**
	 * Filters the supplied data with the supplied customization and predefined set of filters and return no more hits than maxHists.
	 * @param data the data to filter
	 * @param customization the filter customization
	 * @param maxHits max number of hits
	 * @return a list of filterables which passed the filter
	 */
	List<T> filter(List<T> data, FilterCustomization customization, int maxHits);

	List<T> filter(FilterCustomization customization, List<Filter<T>> filters, int maxHits);

	/**
	 * Filters the given data with the given filters and the given customization. Returns a list of filterables with up to maxHits elements
	 * @param data the data to filter
	 * @param filters the filters to use
	 * @param customization the customization for the filters
	 * @param maxHits the number of max hits
	 * @return a list of filterable objects which passed the filter
	 */
	List<T> filter(List<T> data, List<Filter<T>> filters, FilterCustomization customization, int maxHits);
	/**
	 * Adds a filter to the engine.
	 * @param aFilter the filter to add
	 */
	void addFilter(Filter<T> aFilter);
	/**
	 * Removes a filter from the engine.
	 * @param aFilter a filter to remove
	 */
	void removeFilter(Filter<T> aFilter);
	
	/**
	 * Adds filters to the engine.
	 * @param someFilters
	 */
	void addFilters(List<Filter<T>> someFilters);
	/**
	 * Add filterable to the engine
	 * @param f
	 */
	void addFilterable(T f);
	/**
	 * Adds some filterable to the engine.
	 * @param someFilterables
	 */
	void addFilterables(List<T> someFilterables);
	/**
	 * Removes a filterable
	 * @param f
	 */
	void removeFilterable(T f);
	/**
	 * Removes some filterables
	 * @param someFilterables
	 */
	void removeFilterables(List<T> someFilterables);
	
}
