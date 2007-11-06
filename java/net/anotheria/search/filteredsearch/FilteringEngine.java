package net.anotheria.search.filteredsearch;

import java.util.List;

public interface FilteringEngine<T extends Filterable> {
	public List<T> filter(FilterCustomization customization);
	
	public List<T> filter(List<T> data, FilterCustomization customization);

	public List<T> filter(List<T> data, List<Filter> filters, FilterCustomization customization);

	public void addFilter(Filter aFilter);
	
	public void removeFilter(Filter aFilter);
	
	public void addFilters(List<Filter> someFilters);
	
	public void addFilterable(T f);
	
	public void addFilterables(List<T> someFilterables);

	public void removeFilterable(T f);
	
	public void removeFilterables(List<T> someFilterables);
	
}
