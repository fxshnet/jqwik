package net.jqwik.api.state;

import java.util.function.*;

import org.apiguardian.api.*;

import static org.apiguardian.api.API.Status.*;

@FunctionalInterface
@API(status = EXPERIMENTAL, since = "1.7.0")
public interface Transformer<T> extends Function<T, T> {

	/**
	 * Describe the transformation this {@linkplain Transformer} is doing in a human understandable way
	 * @return non-empty String
	 */
	default String transformation() {
		return toString();
	}
}
