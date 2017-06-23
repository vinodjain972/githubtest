import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class TestLamba {

	public static void main(String[] args) {
		// the signature is matched with the functional interface the interface
		// should contain at least one abstract method
		Calculator c = (a, b) -> a + b;
		System.out.println("Sum of two number is " + c.add(10, 20));
		
		//using bi consumer for the same purpose
		BiFunction<Integer,Integer,Integer> biF = (a, b) -> a + b;
		System.out.println("Using Bifunction for the same thing " +biF.apply(30, 40));
		
		BiConsumer<Integer,Integer> biConsume= (a,b)->System.out.println("using biConsumer "+(a+b));
		biConsume.accept(40, 50);
		
	}

	@FunctionalInterface
	public interface Calculator {
		int add(int a, int b);
	}
}
