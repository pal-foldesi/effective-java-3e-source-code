package effectivejava.concurrency.avoid_excessive_synchronization;

// Set observer callback interface
public interface SetObserver<E> {
    // Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}
