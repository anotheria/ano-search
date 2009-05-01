package net.anotheria.search.filteredsearch;

/**
 * A customizeable filter is basically a filter which can be configured from outside.
 * For example, a maleOnly filter is not customizeable, neither is femaleOnly filter, but 
 * genderFilter is customizeable.
 * @author lrosenberg
 *
 * @param <T>
 */
public interface CustomizeableFilter<T extends Filterable> extends Filter<T>{
	/**
	 * Called by the engine to customize the filter prior to a filtering run.
	 * @param customization
	 */
	void customize(FilterCustomization customization);
}
