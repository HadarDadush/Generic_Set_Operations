import java.util.Random;
import java.util.Scanner;

// A program that performs operations on generic sets.
public class GenericSetOperations {
	public static void main(String[] args) {
		
		// Task 2
		final int SIZE_VALUE = 10;
		final int MAX_RANDOM = 101;

		// Create 3 sets of Integer.
		GenericSet<Integer> set1 = new GenericSet<>();
		GenericSet<Integer> set2 = new GenericSet<>();
		GenericSet<Integer> set3 = new GenericSet<>();

		// Fill each set with 10 unique random values between 0 and 100.
		Random random = new Random();
		while (set1.size() < SIZE_VALUE) {
			set1.insert(random.nextInt(MAX_RANDOM));
		}
		while (set2.size() < SIZE_VALUE) {
			set2.insert(random.nextInt(MAX_RANDOM));
		}
		while (set3.size() < SIZE_VALUE) {
			set3.insert(random.nextInt(MAX_RANDOM));
		}

		// Display the content of each set.
		System.out.println("Task 2:");
		System.out.println("\n---------- Set 1 ----------");
		System.out.println(set1);
		System.out.println("\n---------- Set 2 ----------");
		System.out.println(set2);
		System.out.println("\n---------- Set 3 ----------");
		System.out.println(set3);

		// Perform union of set1 and set2, then display the result.
		set1.union(set2);
		System.out.println("\nUnion of Set 1 and Set 2:");
		System.out.println(set1);

		// Perform intersection of the union with set3, then display the result.
		set1.intersect(set3);
		System.out.println("\nIntersection of Union (Set 1 + Set 2) and Set 3:");
		System.out.println(set1);

		// Input two numbers from the user and create a fourth set.
		Scanner scanner = new Scanner(System.in);
		Integer num1 = null, num2 = null;

		// Add exception handling for invalid input.
		while (num1 == null || num2 == null) {
			try {
				System.out.print("\nEnter two numbers to create a fourth set: ");
				num1 = Integer.parseInt(scanner.nextLine());
				num2 = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Please enter valid integers.");
			}
		}

		GenericSet<Integer> set4 = new GenericSet<>(new Integer[] { num1, num2 });

		// Check if set4 is a subset of set1, set2, or set3.
		System.out.println("Is Set 4 a Subset of Set 1? " + set1.isSubset(set4));
		System.out.println("Is Set 4 a Subset of Set 2? " + set2.isSubset(set4));
		System.out.println("Is Set 4 a Subset of Set 3? " + set3.isSubset(set4));

		// Input a number from the user and perform actions on the sets.
		Integer num3 = null;

		// Add exception handling for invalid input.
		while (num3 == null) {
			try {
				System.out.print("\nEnter a number to perform actions: ");
				num3 = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Please enter a valid integer.");
			}
		}

		// Check if the number is a member of set1.
		System.out.println("Is " + num3 + " a Member of Set 1? " + set1.isMember(num3));

		// Insert the number into set2 and display the result.
		set2.insert(num3);
		System.out.println("Set 2 After Inserting " + num3 + ": " + set2);

		// Delete the number from set3 and display the result.
		set3.delete(num3);
		System.out.println("Set 3 After Deleting " + num3 + ": " + set3);

		scanner.close();

		// Task 3
		// Create a set for Person objects.
		GenericSet<Person> personSet = new GenericSet<>();

		// Add 5 Person objects to the set.
		personSet.insert(new Person("12345", "John", "Doe", 1990));
		personSet.insert(new Person("23456", "Jane", "Doe", 1992));
		personSet.insert(new Person("34567", "Alice", "Smith", 1985));
		personSet.insert(new Person("45678", "Bob", "Johnson", 1995));
		personSet.insert(new Person("56789", "Charlie", "Brown", 1980));

		// Display the set of Person objects.
		System.out.println("\n-------------------------------------");
		System.out.println("\nTask 3:");
		System.out.println("\nSet of Persons:");
		System.out.println(personSet);

		// Find and display the minimum element in the set.
		Person minPerson = personSet.findMin();
		System.out.println("\nThe person with the smallest ID is:");
		System.out.println(minPerson);

	}

}
