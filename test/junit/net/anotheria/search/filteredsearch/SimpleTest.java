package net.anotheria.search.filteredsearch;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static junit.framework.Assert.*;

import net.anotheria.search.filteredsearch.Filter;
import net.anotheria.search.filteredsearch.FilteringEngine;
import net.anotheria.search.filteredsearch.plainengine.PlainFilteringEngineFactory;

public class SimpleTest{
	
	protected static List<TestPerson> testData = TestObjectsCreator.create(100);
	
	@Test public void getAllFemale(){
		FilteringEngine<TestPerson> engine = PlainFilteringEngineFactory.createFilteringEngine();
		engine.addFilter(new FemaleFilter());
		List<TestPerson> results = engine.filter(testData, new TestPersonCustomization());
		for (TestPerson p : results)
			if (p.isMale())
				fail("Filter result is male: "+p);
	}


	@Test public void getAllFemaleInRange(){
		int minAge = 20;
		int maxAge = 25;
		FilteringEngine<TestPerson> engine = PlainFilteringEngineFactory.createFilteringEngine();
		TestPersonCustomization customization = new TestPersonCustomization();
		customization.setMinAge(minAge);
		customization.setMaxAge(maxAge);
		engine.addFilter(new FemaleFilter());
		engine.addFilter(new AgeRangeFilter());
		List<TestPerson> results = engine.filter(testData, customization);
		for (TestPerson p : results){
			if (p.isMale())
				fail("Filter result is male: "+p);
			if (p.getAge()<minAge || p.getAge()>maxAge)
				fail("Filter result is out of age range");
		}
	}
	
	@Test public void forEachMaleInListGet3FemalesWithin10YearsRange(){
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
