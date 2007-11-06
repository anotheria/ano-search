package net.anotheria.search.filteredsearch;

import java.util.List;

public interface FilteringEngine<T extends Filterable> {
	public List<T> filter(FilterCustomization customization);
	
	public List<T> filter(List<T> data, FilterCustomization customization);

	public List<T> filter(FilterCustomization customization, List<Filter<T>> filters);

	public List<T> filter(List<T> data, List<Filter<T>> filters, FilterCustomization customization);

	public List<T> filter(FilterCustomization customization, int maxHits);
	
	public List<T> filter(List<T> data, FilterCustomization customization, int maxHits);

	public List<T> filter(FilterCustomization customization, List<Filter<T>> filters, int maxHits);

	public List<T> filter(List<T> data, List<Filter<T>> filters, FilterCustomization customization, int maxHits);

	public void addFilter(Filter<T> aFilter);
	
	public void removeFilter(Filter<T> aFilter);
	
	public void addFilters(List<Filter<T>> someFilters);
	
	public void addFilterable(T f);
	
	public void addFilterables(List<T> someFilterables);

	public void removeFilterable(T f);
	
	public void removeFilterables(List<T> someFilterables);
	
}
