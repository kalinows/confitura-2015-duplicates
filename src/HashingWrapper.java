
public interface HashingWrapper<T> {
	@Override
	boolean equals(Object obj);
	boolean areEqual(T first, T second);
	@Override
	int hashCode();
}
