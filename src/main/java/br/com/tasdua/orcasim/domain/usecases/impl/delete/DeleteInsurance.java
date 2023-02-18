package br.com.tasdua.orcasim.domain.usecases.impl.delete;

import br.com.tasdua.orcasim.domain.entities.Insurance;
import br.com.tasdua.orcasim.domain.enums.ErrosCodeEnum;
import br.com.tasdua.orcasim.domain.excptions.InsuranceException;
import br.com.tasdua.orcasim.domain.usecases.IITemDelete;
import br.com.tasdua.orcasim.mappers.RepositoryDomainMapper;
import br.com.tasdua.orcasim.repository.InsuranceRepository;

public class DeleteInsurance implements IITemDelete<Long, InsuranceException> {


    private InsuranceRepository insuranceRepository;
    private RepositoryDomainMapper repositoryDomainMapper;

    public DeleteInsurance(InsuranceRepository insuranceRepository,
                           RepositoryDomainMapper repositoryDomainMapper) {
        this.insuranceRepository = insuranceRepository;
        this.repositoryDomainMapper = repositoryDomainMapper;
    }


    @Override
    public void deleteItem(Long id) throws InsuranceException {
        var insurance = findInsurance(id);
        insurance.setActive(false);
        insuranceRepository.save(
                repositoryDomainMapper.convertToInsuranceEntity(insurance)
        );
    }

    private Insurance findInsurance(Long id) throws InsuranceException {
        return repositoryDomainMapper.convertToInsurance(
                insuranceRepository.findById(id)
                        .orElseThrow(() -> new InsuranceException(ErrosCodeEnum.INSURANCE_NOT_FOUND))
        );
    }
}
