package com.kr.caption.effective.effective79c;

public interface SetObserverFixed<E> {
    // Invoked when an element is added to the observable set
    void added(ObservableSetFixed<E> set, E element);
}