import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class DuplicateRemoverTest {
	private DuplicateRemover remover = new DuplicateRemover();

	@Test
	public void testRemoveDuplicatesTrivial() {
		Person person = new Person("Alice", 20);
		LinkedList<Person> singleton = new LinkedList<>(Arrays.asList(person ));
		assertEquals(singleton, remover.removeDuplicates(singleton));
	}
	
	@Test
	public void testRemoveDuplicatesOneDuplicate() {
		Person person1 = new Person("Alice", 20);
		Person person2 = new Person("Alice", 20);
		LinkedList<Person> list = new LinkedList<>(Arrays.asList(person1, person2));
		List<Person> result = remover.removeDuplicates(list);
		assertEquals(1, result.size());
		assertTrue(HashingPersonWrapper.staticAreEqual(person1, result.get(0)));
	}
	
	@Test
	public void testRemoveDuplicatesMoreDuplicates() {
		Person person1 = new Person("Alice", 20);
		Person person2 = new Person("Alice", 20);
		Person person3 = new Person("Bob", 20);
		Person person4 = new Person("Bob", 45);
		Person person5 = new Person("Alice", 20);
		List<Person> list = Arrays.asList(person1, person2, person3, person4, person5);
		List<Person> result = remover.removeDuplicates(list);
		assertEquals(3, result.size());
		assertTrue(HashingPersonWrapper.staticAreEqual(person1, result.get(0)));
		assertTrue(HashingPersonWrapper.staticAreEqual(person3, result.get(1)));
		assertTrue(HashingPersonWrapper.staticAreEqual(person4, result.get(2)));
	}

}
