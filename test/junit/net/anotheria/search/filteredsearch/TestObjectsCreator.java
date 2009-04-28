package net.anotheria.search.filteredsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestObjectsCreator {
	public static final List<TestPerson> create(int amount){
		List<TestPerson> ret = new ArrayList<TestPerson>();
		Random rnd = new Random(System.currentTimeMillis());
		
		for (int i=0; i<amount; i++){
			String id = ""+(i+1);
			int age = rnd.nextInt(40)+20;
			boolean male = rnd.nextBoolean();
			ret.add(new TestPerson(id,male,age));
		}
		
		
		return ret;
	}
}
