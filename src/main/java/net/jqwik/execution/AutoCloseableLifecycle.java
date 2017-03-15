package net.jqwik.execution;

import net.jqwik.api.*;

public class AutoCloseableLifecycle implements ExampleLifecycle, PropertyLifecycle {
	@Override
	public void doFinally(TestContext exampleDescriptor, Object testInstance) throws Throwable {
		if (testInstance instanceof AutoCloseable) {
			AutoCloseable closeable = (AutoCloseable) testInstance;
			closeable.close();
		}
	}
}
