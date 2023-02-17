package br.com.tasdua.orcasim.configs;

import br.com.tasdua.orcasim.domain.usercases.ICreateNewInsurance;
import br.com.tasdua.orcasim.domain.usercases.impl.CreateNewInsurance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserCasesConfig {

    @Bean
    public ICreateNewInsurance createCreateNewInsuranceUserCase(){
        return new CreateNewInsurance();
    }

}
