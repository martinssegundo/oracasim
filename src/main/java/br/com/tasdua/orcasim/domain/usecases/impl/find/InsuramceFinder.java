package br.com.tasdua.orcasim.domain.usecases.impl.find;

import br.com.tasdua.orcasim.domain.entities.Insurance;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;
import br.com.tasdua.orcasim.domain.usecases.IITemFinder;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.InsuranceRepository;

public class InsuramceFinder implements IITemFinder<Long, InsuranceException, Insurance> {

    private InsuranceRepository insuranceRepository;
    private RepositoryDomainMapper repositoryDomainMapper;


    public InsuramceFinder(InsuranceRepository insuranceRepository,
                           RepositoryDomainMapper repositoryDomainMapper){
        this.insuranceRepository = insuranceRepository;
        this.repositoryDomainMapper = repositoryDomainMapper;
    }

    @Override
    public Insurance findByIdenrification(Long identification) {
        return null;
    }


}
