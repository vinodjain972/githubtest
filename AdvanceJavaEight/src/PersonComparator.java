import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class PersonComparator {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(new Person("Ankit", 1, "Keshorey"), new Person("Babbu", 2, "Jain"),
				new Person("Tinku ", 3, "Chaudhary"), new Person("Pintu", 4, "Jain"));
		// Using normal java 7
		List<Person> sorterdList = sortList(personList);
		printListPerson(sorterdList);

		List<Person> sorterdListWithJava8 = sortListWithJava8(personList);
		printListPersonWithJava8(sorterdListWithJava8);

		// only jain
		sorterdListWithJava8.stream().filter(p -> p.getLastName().equals("Jain"))
				.forEach(p -> System.out.println("--------->only jain" + p));

		List<String> nameList = new ArrayList<>();
		nameList.add("tita");
		nameList.add("bunty");
		nameList.add("chunnu");
		nameList.add(null);
		
		
		try {
			if (nameList.stream().anyMatch(p -> p.equals("titu"))) {
				System.out.println("titu is present");
			}
		} catch (NullPointerException ex) {
			System.out.println("result not present");
		}
		Stream<String> nameModified=nameList.stream().map(p->p+" modified");
		nameModified.forEach(p -> System.out.println(" " + p));
	}

	private static void printListPersonWithJava8(List<Person> sorterdList) {
		sorterdList.stream().forEach(p -> System.out.println("with java8 " + p));
	}

	private static List<Person> sortListWithJava8(List<Person> personList) {
		Collections.sort(personList, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		return personList;
	}

	private static void printListPerson(List<Person> sorterdList) {
		for (Person person : sorterdList) {
			System.out.println(person);
		}

	}

	private static List<Person> sortList(List<Person> personList) {
		Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		
		return personList;
	}

}
