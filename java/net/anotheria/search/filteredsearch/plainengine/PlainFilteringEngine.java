package net.anotheria.search.filteredsearch.plainengine;

import java.util.ArrayList;
import java.util.List;

import net.anotheria.search.filteredsearch.CustomizeableFilter;
import net.anotheria.search.filteredsearch.Filter;
import net.anotheria.search.filteredsearch.FilterCustomization;
import net.anotheria.search.filteredsearch.Filterable;
import net.anotheria.search.filteredsearch.FilteringEngine;

public class PlainFilteringEngine<T extends Filterable> implements FilteringEngine<T>{
	
	private ArrayList<Filter<T>> filters;
	private ArrayList<T> data;
	
	PlainFilteringEngine() {
		filters = new ArrayList<Filter<T>>();
		data = new ArrayList<T>();
	}

	@Override public void addFilter(Filter<T> filter) {
		for (int i=0; i<filters.size(); i++){
			if (filter.getPerformance()>filters.get(i).getPerformance()){
				filters.add(i, filter);
				return;
			}
		}
		filters.add(filter);
	}

	@Override public void addFilterable(T f) {
		data.add(f);
		
	}

	@Override public void addFilterables(List<T> someFilterables) {
		data.addAll(someFilterables);
		
	}

	@Override public void addFilters(List<Filter<T>> someFilters) {
		for (Filter<T> f : someFilters)
			addFilter(f);
		
	}

	@Override public List<T> filter(FilterCustomization customization) {
		return filter(data, customization);
	}

	@Override public List<T> filter(List<T> someData, FilterCustomization customization) {
		return filter(someData, filters, customization);
	}

	@Override public List<T> filter(List<T> someData, List<Filter<T>> someFilters,
			FilterCustomization customization) {
		
		for (Filter<T> f : someFilters){
			if (f instanceof CustomizeableFilter)
				((CustomizeableFilter<T>)f).customize(customization);
		}
		
		ArrayList<T> ret = new ArrayList<T>(someData.size()<100 ? 100 : someData.size() / 10);
		boolean mayPass = false;
		for (T entry : someData){
			mayPass = true;
			for (Filter<T> f : someFilters){
				mayPass = f.mayPass(entry);
				if (!mayPass)
					break;
			}
			if (mayPass)
				ret.add(entry);
		}
			
		
		
		return ret;
	}

	@Override public void removeFilter(Filter<T> filter) {
		filters.remove(filter);
		
	}

	@Override public void removeFilterable(T f) {
		data.remove(f);
		
	}

	@Override public void removeFilterables(List<T> someFilterables) {
		data.removeAll(someFilterables);
		
	}

	@Override public List<T> filter(FilterCustomization customization, int maxHits) {
		return filter(data, customization, maxHits);
	}

	@Override public List<T> filter(List<T> data, FilterCustomization customization,
			int maxHits) {
		return filter(data, filters, customization, maxHits);
	}

	@Override public List<T> filter(List<T> someData, List<Filter<T>> someFilters,
			FilterCustomization customization, int maxHits) {

		for (Filter<T> f : someFilters){
			if (f instanceof CustomizeableFilter)
				((CustomizeableFilter<T>)f).customize(customization);
		}
		
		ArrayList<T> ret = new ArrayList<T>(maxHits);
		boolean mayPass = false;
		int hits = 0;
		for (int i=0; i<someData.size() && hits < maxHits; i++ ){
			T entry = someData.get(i);
			mayPass = true;
			for (Filter<T> f : someFilters){
				mayPass = f.mayPass(entry);
				if (!mayPass)
					break;
			}
			if (mayPass){
				ret.add(entry);
				hits++;
			}
		}
			
		
		
		return ret;
	}

	@Override public List<T> filter(FilterCustomization customization, List<Filter<T>> filters, int maxHits) {
		return filter(data, filters, customization, maxHits);
	}

	@Override public List<T> filter(FilterCustomization customization, List<Filter<T>> filters) {
		return filter(data, filters, customization);
	}


}
