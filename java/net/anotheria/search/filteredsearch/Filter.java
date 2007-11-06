package net.anotheria.search.filteredsearch;

public interface Filter<T extends Filterable> {
	public boolean mayPass(T toFilter);
	
	public int getPerformance();
}
