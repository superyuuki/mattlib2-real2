package xyz.auriium.mattlib2.nt;

import java.util.function.Supplier;

/**
 * Public supplier delegate so that generated classes can access the lambdas contained within this class
 * If ByteBuddy tries to bind a normal lambda to the return values of the generated delegate class
 * it will not be able to, because the lambda can sometimes be created in the body of a method and therefore be hidden
 * from ByteBuddy. However hiding the lambda inside this class will give us access to private lambdas
 * in exchange for a little overhead due to the invocation passing through here
 * @param <T>
 */
public class InvocationSupplier<T> implements Supplier<T> {

    final Supplier<T> delegate;

    public InvocationSupplier(Supplier<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public T get() {
        return delegate.get();
    }
}
