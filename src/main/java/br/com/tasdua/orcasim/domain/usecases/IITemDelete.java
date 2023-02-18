package br.com.tasdua.orcasim.domain.usecases;

public interface IITemDelete<T,Y extends Throwable>{

    void deleteItem(T t) throws Y;
}
