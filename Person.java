// A class representing a person with ID, name, and birth year. 
// Implements Comparable for comparison.
// Task 3
public class Person implements Comparable<Person> {
	private String id;
	private String firstName;
	private String lastName;
	private int birthYear;

	// Constructor to initialize the Person object.
	public Person(String id, String firstName, String lastName, int birthYear) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
	}

	// Getter methods for all fields.
	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getBirthYear() {
		return birthYear;
	}

	// Implementing the compareTo method to compare Person objects by ID.
	@Override
	public int compareTo(Person other) {
		
		// Compare based on the ID (lexicographically).
		return this.id.compareTo(other.id);
	}

	// Overriding equals method to be consistent with compareTo.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Person person = (Person) obj;
		return id.equals(person.id);
	}

	// Overriding toString method to provide a clear output when printing Person.
	@Override
	public String toString() {
		return "Person{ID='" + id + "', Name='" + firstName + " " + lastName + "', Birth Year=" + birthYear + "}";
	}
}
