package net.anotheria.search.filteredsearch;

public interface Filter {
	public boolean mayPass(Filterable toFilter);
	
	public int getPerformance();
}
