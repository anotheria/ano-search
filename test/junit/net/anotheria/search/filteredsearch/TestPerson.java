package net.anotheria.search.filteredsearch;

import net.anotheria.search.filteredsearch.Filterable;

public class TestPerson implements Filterable{
	private boolean male;
	private int age;
	private String id;
	
	public TestPerson(String anId, boolean aMale, int anAge){
		id = anId;
		male = aMale;
		age = anAge;
	}
	
	public String toString(){
		return "id: "+getId()+", male: "+isMale()+", age: "+getAge();
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
