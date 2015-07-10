# [Confitura 2015](http://tech.viacom.com/warsawsdc/confitura2015/)
## Duplicates
### Original description
You have *very big* list of elements. Please provide best solution to detect and remove duplicated elements.

Please provide a solution and **comments** about its benefits and drawbacks. Please give us complexity (`O(n)`, `O(n^2)`, `O(ln(n))`, ...). Please think about custom classes like:

```java
class Person {
    String name;
    int age;
}
```

You can check contest bye-laws [here](http://tech.viacom.com/warsawsdc/confitura2015/Regulamin_konkurs_Viacom_programmer_adventure_2015.pdf).

Check out our Confitura 2015 site [here](http://tech.viacom.com/warsawsdc/confitura2015/)

We are hiring! Visit our [career site](http://tech.viacom.com/careers/).

### Solution
The presented solution is based on `HashSet` to store pointers to unique values. It is assumed that the original list is provided as an instance of `LinkedList`. This allows cheap in-place modifications. Otherwise, a new instance is created. To check uniqueness, an instance of HashSet is used. In case of custom classes with poor `hashCode()` and `equals()` implementations (or without any), a wrapper can be used (`HashingWrapper<T>`), that can calculate hash code and compare values without modification of the original class. For the provided sample class (`Person`) there is a corresponding wrapper (`HashingPersonWrapper`).

Complexity of an average case is `O(n)`; the list needs to be scanned once and for each element there is one or two lookups in the hash set. Each lookup needs usually constant time (`O(1)`). In the worst case (when `hashCode()` returns the same code for each element), each hash set lookup costs `O(n)` read operations. As a result, complexity in the worst case is `O(n^2)`. Replacing `HashSet` with `TreeSet` would benefit in guaranteed `O(n*log(n))` complexity, but it would be worse in an average case.

If the original list is too big to fit in memory, this solution can be modified in such way:
- read the list from a file sequentially,
- in the HashSet store only hash codes and file offsets of the corresponding values. The values may need to be re-read to verify if two hash codes are identical because of a duplicate value or it is a coincidence.

Benefits:
- `O(n)` complexity in average case,
- with a wrapper can work with custom classes, that lack of `hashCode()` or `equals()` methods.

Drawbacks:
- `O(n^2)` in a worst case scenario,
- the whole list must fit in memory.