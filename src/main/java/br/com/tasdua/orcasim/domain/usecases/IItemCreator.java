package br.com.tasdua.orcasim.domain.usecases;

public interface IItemCreator<T,Y extends Throwable> {

    T create(T t) throws Y;
}
