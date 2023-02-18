package br.com.tasdua.orcasim.utils;

import br.com.tasdua.orcasim.repository.entities.CustumerEntity;

public class CustumerBuilderUtil {

    public static CustumerEntity buildCustumerEntity(){
        return CustumerEntity.builder()
                .name("Luiz")
                .id(1L)
                .build();
    }
}
