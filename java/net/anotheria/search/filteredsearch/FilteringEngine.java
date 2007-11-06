package net.anotheria.search.filteredsearch;

import java.util.List;

public interface FilteringEngine {
	public List<Filterable> filter(FilterCustomization customization);
	
	public List<Filterable> filter(List<Filterable> data, FilterCustomization customization);

	public List<Filterable> filter(List<Filterable> data, List<Filter> filters, FilterCustomization customization);

	public void addFilter(Filter aFilter);
	
	public void removeFilter(Filter aFilter);
	
	public void addFilters(List<Filter> someFilters);
	
	public void addFilterable(Filterable f);
	
	public void addFilterables(List<Filterable> someFilterables);

	public void removeFilterable(Filterable f);
	
	public void removeFilterables(List<Filterable> someFilterables);
	
}
