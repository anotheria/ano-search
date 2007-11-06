package net.anotheria.search.filteredsearch;

public interface CustomizeableFilter<T extends Filterable> extends Filter<T>{
	public void customize(FilterCustomization customization);
}
