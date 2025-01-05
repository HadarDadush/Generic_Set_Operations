import java.util.ArrayList;
import java.util.Iterator;

// Task 1 
// A generic set class using ArrayList to store unique elements and basic set operations.
public class GenericSet<T extends Comparable<T>> {
	
	private ArrayList<T> elements;

	// Default constructor - initializes an empty set.
	public GenericSet() {
		elements = new ArrayList<>();
	}

	// Constructor - initializes a set from an array.
	public GenericSet(T[] items) {
		elements = new ArrayList<>();
		for (T item : items) {
			insert(item);
		}
	}

	// Adds an element to the set (if not already present).
	public void insert(T item) {
		if (!elements.contains(item)) {
			elements.add(item);
		}
	}

	// Removes an element from the set (if present).
	public void delete(T item) {
		elements.remove(item);
	}

	// Checks if an element is a member of the set.
	public boolean isMember(T item) {
		return elements.contains(item);
	}

	// Checks if the set is a subset of another set.
	public boolean isSubset(GenericSet<T> otherSet) {
		for (T item : otherSet.elements) {
			if (!this.isMember(item)) {
				return false;
			}
		}
		return true;
	}

	// Performs the union of this set with another set.
	public void union(GenericSet<T> otherSet) {
		for (T item : otherSet.elements) {
			insert(item);
		}
	}

	// Performs the intersection of this set with another set.
	public void intersect(GenericSet<T> otherSet) {
		elements.removeIf(item -> !otherSet.isMember(item));
	}

	// Returns an iterator for the set.
	public Iterator<T> iterator() {
		return elements.iterator();
	}

	// Returns a string representation of the set.
	@Override
	public String toString() {
		return elements.toString();
	}

	// Returns the size of the set.
	public int size() {
		return elements.size();
	}

	// Method to find the minimum element in the set.
	public T findMin() {
		if (elements.isEmpty()) {
			return null;
		}

		// Assume the first element is the minimum.
		T min = elements.get(0);

		for (T item : elements) {
			if (item instanceof Comparable) {
				
				// Cast item to Comparable<T> and compare.
				Comparable<T> comparableItem = (Comparable<T>) item;
				if (comparableItem.compareTo(min) < 0) {
					min = item;
				}
			}
		}
		return min;
	}
}
