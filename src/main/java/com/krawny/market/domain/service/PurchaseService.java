package com.krawny.market.domain.service;

import com.krawny.market.domain.DomainPurchase;
import com.krawny.market.domain.repository.DomainPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private DomainPurchaseRepository domainPurchaseRepository;

    public List<DomainPurchase> getAll(){
        return domainPurchaseRepository.getAll();
    }

    public Optional<List<DomainPurchase>> getByClient(String clientId){
        return domainPurchaseRepository.getByClient(clientId);
    }

    public DomainPurchase save(DomainPurchase domainPurchase){
        return domainPurchaseRepository.save(domainPurchase);
    }
}
