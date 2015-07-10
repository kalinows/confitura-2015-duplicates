/**
 * A HashingWrapper implementation for a concrete class, Person.
 */
public class HashingPersonWrapper implements HashingWrapper<Person> {
	private final Person wrapped;
	private final int precalculatedHash;

	public HashingPersonWrapper(Person wrapped) {
		if (wrapped == null) {
			throw new NullPointerException("Wrapped object cannot be null");
		}
		this.wrapped = wrapped;
		this.precalculatedHash = precalculateHash();
	}
	
	@Override
	public int hashCode() {
		return precalculatedHash;
	}

	private int precalculateHash() {
		final int prime = 31;
		int result = 1;
		result = prime * result + wrapped.getAge();
		result = prime * result + ((wrapped.getName() == null) ? 0 : wrapped.getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashingPersonWrapper other = (HashingPersonWrapper) obj;
		if (wrapped == null) {
			if (other.wrapped != null)
				return false;
		} else if (!areEqual(wrapped, other.wrapped))
			return false;
		return true;
	}


	@Override
	public boolean areEqual(Person first, Person second) {
		return staticAreEqual(first, second);
	}

	/**
	 * A convenience method that can be used also outside this class.
	 */
	public static boolean staticAreEqual(Person first, Person second) {
		if (first == second)
			return true;
		if (first == null || second == null)
			return false;
		if (first.getClass() != second.getClass())
			return false;
		if (first.getAge() != second.getAge())
			return false;
		if (first.getName() == null) {
			if (second.getName() != null)
				return false;
		} else if (!first.getName().equals(second.getName()))
			return false;
		return true;
	}
}
