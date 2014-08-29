package net.anotheria.search.filteredsearch;

public class FemaleFilter extends GenderFilter{
	protected boolean requiredMale(){
		return false;
	}
}
