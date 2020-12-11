import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

class PrimitiveStreams {

	void totalQuantity(List<Item> items) {
		Optional<Integer> resOpt =  items.stream()
			.map(item -> item.quantity)
			.reduce(Integer::sum);

	}

	// Similarly we have DoubleStream & LongStream too!

	void intStreamTotal(int[] ints) {
		IntStream intStream = IntStream.of(ints);
		OptionalInt res = intStream.reduce((a, b) -> a + b);
	}

	void totalQuantityWithConversion(List<Item> items) {
		int total =  items.stream()
			.mapToInt(Item::getQuantity)
			.sum();

	}

	public static void main(String[] args) {

	}
}

class Item {
	int quantity;

	int getQuantity() {
		return quantity;
	}
}