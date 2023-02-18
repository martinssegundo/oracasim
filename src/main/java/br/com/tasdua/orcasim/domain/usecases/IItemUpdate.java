package br.com.tasdua.orcasim.domain.usecases;

public interface IItemUpdate<T,Y extends Throwable> {
    T update(T t) throws Y;
}
