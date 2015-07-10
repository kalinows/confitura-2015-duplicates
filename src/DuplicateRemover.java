import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class DuplicateRemover {
	/**
	 * Remove duplicate in place if the input list is a LinkedList. Otherwise, a copy is returned.
	 */
	public <T> List<T> removeDuplicates(List<T> list) {
		if (!(list instanceof LinkedList<?>)) {
			list = new LinkedList<>(list);
		}
		Set<HashingWrapper<T>> unique = new HashSet<>(list.size());
		for (Iterator<T> it = list.iterator(); it.hasNext(); ) {
			T element = it.next();
			HashingWrapper<T> wrapper = createHashingWrapper(element);
			if (unique.contains(wrapper)) {
				it.remove();
			} else {
				unique.add(wrapper);
			}
		}
		return list;
	}
	
	/**
	 * Provide a wrapper for the given class. This can help manage 
	 * classes without hashCode() or equals() methods.
	 * There can be a separate factory to create such a wrapper.
	 */
	private <T> HashingWrapper<T> createHashingWrapper(T element) {
		if (element.getClass() == Person.class) {
			return (HashingWrapper<T>) new HashingPersonWrapper((Person) element);
		}
		throw new IllegalArgumentException("Type not supported");
		
	}
}
