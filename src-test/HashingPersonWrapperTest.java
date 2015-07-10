import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class HashingPersonWrapperTest {
	
	private Person alice1;
	private Person alice2;
	private Person bob;
	private HashingPersonWrapper aliceWrap1;
	private HashingPersonWrapper aliceWrap2;
	private HashingPersonWrapper bobWrap;

	@Before
	public void setUp() {
		alice1 = new Person("Alice", 33);
		alice2 = new Person("Alice", 33);
		bob = new Person("Bob", 40);
		aliceWrap1 = new HashingPersonWrapper(alice1);
		aliceWrap2 = new HashingPersonWrapper(alice2);
		bobWrap = new HashingPersonWrapper(bob);
	}

	@Test
	public void testHashCode() {
		assertEquals(aliceWrap1.hashCode(), aliceWrap2.hashCode());
		assertNotEquals(aliceWrap1.hashCode(), bobWrap.hashCode());
	}

	@Test
	public void testEqualsObject() {
		assertEquals(aliceWrap1, aliceWrap2);
		assertNotEquals(aliceWrap1, bobWrap);
	}

	@Test
	public void testStaticAreEqual() {
		assertTrue(HashingPersonWrapper.staticAreEqual(alice1, alice2));
		assertFalse(HashingPersonWrapper.staticAreEqual(alice1, bob));
	}

}
