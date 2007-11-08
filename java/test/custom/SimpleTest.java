package test.custom;

import java.util.ArrayList;
import java.util.List;

import net.anotheria.search.filteredsearch.Filter;
import net.anotheria.search.filteredsearch.FilteringEngine;
import net.anotheria.search.filteredsearch.plainengine.PlainFilteringEngineFactory;

public class SimpleTest extends AbstractTest{
	public static void main(String a[]){
		getAllFemale();
		System.out.println("============================");
		getAllFemaleInRange(20, 25);
		System.out.println("============================");
		forEachMaleInListGet3FemalesWithin10YearsRange();
	}
	
	private static void getAllFemale(){
		System.out.println("Filtering only females");
		FilteringEngine<TestPerson> engine = PlainFilteringEngineFactory.createFilteringEngine();
		engine.addFilter(new FemaleFilter());
		List<TestPerson> results = engine.filter(testData, new TestPersonCustomization());
		System.out.println("Got "+results.size()+" results:");
		System.out.println(results);
	}


	private static void getAllFemaleInRange(int minAge, int maxAge){
		System.out.println("Filtering only females in age range: "+minAge+", "+maxAge);
		FilteringEngine<TestPerson> engine = PlainFilteringEngineFactory.createFilteringEngine();
		TestPersonCustomization customization = new TestPersonCustomization();
		customization.setMinAge(minAge);
		customization.setMaxAge(maxAge);
		engine.addFilter(new FemaleFilter());
		engine.addFilter(new AgeRangeFilter());
		List<TestPerson> results = engine.filter(testData, customization);
		System.out.println("Got "+results.size()+" results:");
		System.out.println(results);
	}
	
	private static void forEachMaleInListGet3FemalesWithin10YearsRange(){
		System.out.println("Getting a women for each man");
		//first, lets get the man
		FilteringEngine<TestPerson> engine = PlainFilteringEngineFactory.createFilteringEngine();
		engine.addFilterables(testData);
		
		List<Filter<TestPerson>> _tmp = new ArrayList<Filter<TestPerson>>(); _tmp.add(new MaleFilter());
		List<TestPerson> males = engine.filter(new TestPersonCustomization(), _tmp);
		System.out.println(" -- got "+males.size()+" males");
		
		engine.addFilter(new AgeRangeFilter());
		engine.addFilter(new FemaleFilter());
		
		int totalMatchCount = 0;
		
		for (TestPerson male : males){
			TestPersonCustomization c = new TestPersonCustomization();
			c.setMinAge(male.getAge()-5); c.setMaxAge(male.getAge()+5);
			List<TestPerson> matches = engine.filter(c, 3);
			totalMatchCount += matches.size();
			System.out.println("For "+male+" got "+matches.size()+" matches: "+matches);
		}
		
		System.out.println("Got total "+totalMatchCount+" for "+males.size()+" males.");
		
	}

}
