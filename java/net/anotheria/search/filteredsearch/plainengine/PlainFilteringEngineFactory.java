package net.anotheria.search.filteredsearch.plainengine;

import net.anotheria.search.filteredsearch.Filterable;
import net.anotheria.search.filteredsearch.FilteringEngine;

public class PlainFilteringEngineFactory{
	public static <T extends Filterable> FilteringEngine<T> createFilteringEngine(){
		return new PlainFilteringEngine<T>();
	}
}
