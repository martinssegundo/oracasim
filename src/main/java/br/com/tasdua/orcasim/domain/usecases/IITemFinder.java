package br.com.tasdua.orcasim.domain.usecases;

import br.com.tasdua.orcasim.domain.excptions.CarNotFoundException;

public interface IITemFinder<T,Y extends Throwable, Z> {

    Z findByIdenrification(T t) throws Y;

}
