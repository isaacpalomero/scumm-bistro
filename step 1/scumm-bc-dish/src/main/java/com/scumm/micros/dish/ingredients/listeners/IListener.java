package com.scumm.micros.dish.ingredients.listeners;

@FunctionalInterface
public interface IListener<T> {
    void success(T item) throws Exception;
}
