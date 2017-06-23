package org.vinodjain.javabrains.personservice;

import java.util.ArrayList;
import java.util.List;


public class PersonService {

	List<Person> personList = new ArrayList<Person>();

	public List<Person> getPersonList() {
		personList.add(new Person(1, "Vaibhav", "rajnandGao", "410092"));
		personList.add(new Person(2, "Vinod", "pune", "410191"));
		personList.add(new Person(3, "aparna", "belgium", "410092"));
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

}
