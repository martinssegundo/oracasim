package br.com.tasdua.orcasim.configs;

import br.com.tasdua.orcasim.domain.usecases.IITemDelete;
import br.com.tasdua.orcasim.domain.usecases.impl.delete.DeleteInsurance;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesDeleteConfig {

    @Bean
    @Qualifier("deleteInsurance")
    public IITemDelete createDeleteInsurance(InsuranceRepository insuranceRepository,
                                             RepositoryDomainMapper repositoryDomainMapper){
        return new DeleteInsurance(insuranceRepository, repositoryDomainMapper);
    }

}
