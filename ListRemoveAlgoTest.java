package subpkg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListRemoveAlgoTest {
	public static void main(String args[]) {
		List<Sample> sampleList = new ArrayList<>();
		// Adding two objects into List
		sampleList.add(new Sample(10, 20));
		sampleList.add(new Sample(30, 20));
		System.out.println("Hashcode for initial SampleList " + sampleList.hashCode());

		// ===============Test 1=========================
		// This element is not present in the list so hashcode should not change
		// after invocation of method.
		removeElement(sampleList, new Sample(40, 20));
		System.out.println("Hashcode for initial SampleList " + sampleList.hashCode());

		// ===============Test 2=========================
		// This element is present in the list so hashcode of original list is
		// changed after this call.
		removeElement(sampleList, new Sample(10, 20));
		// This means, everytime an element is removed from the original list, a
		// new list is created and returned back by List::remove method
		System.out.println("Hashcode for initial SampleList " + sampleList.hashCode());

		// ================Test 3=========================
		// Throws java.lang.IllegalStateException exception as iterator operates
		// tries to
		// remove from the same list (in memory).
		Iterator<Sample> sampleIterator = sampleList.iterator();
		while (sampleIterator.hasNext()) {
			sampleIterator.remove();
		}
	}

	public static void removeElement(List<Sample> inputList, Sample element) {
		inputList.remove(element);
	}
}

class Sample {
	int a;
	int b;

	Sample(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
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
		Sample other = (Sample) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sample [a=" + a + ", b=" + b + "]";
	}

}
