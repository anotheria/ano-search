package net.anotheria.search.filteredsearch.plainengine;

import java.util.ArrayList;
import java.util.List;

import net.anotheria.search.filteredsearch.Filter;
import net.anotheria.search.filteredsearch.FilterCustomization;
import net.anotheria.search.filteredsearch.Filterable;
import net.anotheria.search.filteredsearch.FilteringEngine;

public class PlainFilteringEngine<T extends Filterable> implements FilteringEngine<T>{
	
	private ArrayList<Filter> filters;
	private ArrayList<T> data;
	
	PlainFilteringEngine() {
		filters = new ArrayList<Filter>();
		data = new ArrayList<T>();
	}

	public void addFilter(Filter filter) {
		for (int i=0; i<filters.size(); i++){
			if (filter.getPerformance()>filters.get(i).getPerformance()){
				filters.add(i, filter);
				return;
			}
		}
		filters.add(filter);
	}

	public void addFilterable(T f) {
		data.add(f);
		
	}

	public void addFilterables(List<T> someFilterables) {
		data.addAll(someFilterables);
		
	}

	public void addFilters(List<Filter> someFilters) {
		for (Filter f : someFilters)
			addFilter(f);
		
	}

	public List<T> filter(FilterCustomization customization) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> filter(List<T> data, FilterCustomization customization) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> filter(List<T> data, List<Filter> filters,
			FilterCustomization customization) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeFilter(Filter filter) {
		filters.remove(filter);
		
	}

	public void removeFilterable(T f) {
		data.remove(f);
		
	}

	public void removeFilterables(List<T> someFilterables) {
		data.removeAll(someFilterables);
		
	}


}
