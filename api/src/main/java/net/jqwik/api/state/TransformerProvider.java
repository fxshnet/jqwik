package net.jqwik.api.state;

import java.util.function.*;

import org.apiguardian.api.*;
import org.jetbrains.annotations.*;

import net.jqwik.api.*;

import static org.apiguardian.api.API.Status.*;

/**
 * Provide an arbitrary of {@linkplain Transformer transformer} for values of type {@code T} in the context of {@linkplain Chain chains}.
 * The provided arbitrary of transformer can depend on the previous state
 * which can be retrieved using the first {@linkplain Supplier supplier} argument of the function.
 *
 * @param <T> The type of state to be transformed in a chain
 *
 * @see Chain
 * @see Transformer
 */
@FunctionalInterface
@API(status = EXPERIMENTAL, since = "1.7.0")
public interface TransformerProvider<T> extends Function<Supplier<T>, Arbitrary<Transformer<T>>> {

	Predicate<?> NO_PRECONDITION = ignore -> false;

	/**
	 * Override this method if the applicability of the provided transformers depends on the previous state
	 *
	 * @return a predicate with input {@code T}
	 */
	@SuppressWarnings("unchecked")
	default Predicate<T> precondition() {
		return (Predicate<T>) NO_PRECONDITION;
	}
}
