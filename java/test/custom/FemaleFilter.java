package test.custom;

public class FemaleFilter extends GenderFilter{
	protected boolean requiredMale(){
		return false;
	}
}
