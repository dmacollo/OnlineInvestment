package org.coop.sidc.repositories;

import java.util.List;

import org.coop.sidc.domain.InvestmentTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentTransactionRepository extends CrudRepository<InvestmentTransaction,Long>{
}
