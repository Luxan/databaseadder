package com.decerto.databaseadder.services;

public interface IProcessingService<T> {

    public T process(T first, T second);

}
