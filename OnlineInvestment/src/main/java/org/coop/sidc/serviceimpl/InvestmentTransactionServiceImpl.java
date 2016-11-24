package org.coop.sidc.serviceimpl;

import org.coop.sidc.domain.InvestmentTransaction;
import org.coop.sidc.repositories.InvestmentTransactionRepository;
import org.coop.sidc.service.InvestmentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvestmentTransactionServiceImpl implements InvestmentTransactionService{
	@Autowired
	InvestmentTransactionRepository investmentTransactionRepository;
	
	@Override
	public InvestmentTransaction save(InvestmentTransaction investmentTransaction) {
		return investmentTransactionRepository.save(investmentTransaction);
	}

}
