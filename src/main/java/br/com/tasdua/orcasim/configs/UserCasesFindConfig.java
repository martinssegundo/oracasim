package br.com.tasdua.orcasim.configs;

import br.com.tasdua.orcasim.domain.entities.Insurance;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;
import br.com.tasdua.orcasim.domain.usecases.IITemFinder;
import br.com.tasdua.orcasim.domain.usecases.impl.find.InsuramceFinder;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class UserCasesFindConfig {


    @Bean
    @Qualifier("insuramceFinder")
    public IITemFinder<Long, InsuranceException, Insurance> createFindInsurance(InsuranceRepository insuranceRepository,
                                                                                RepositoryDomainMapper repositoryDomainMapper){

        return new InsuramceFinder(insuranceRepository,repositoryDomainMapper);
    }
}
