package com.krawny.market.domain.repository;

import com.krawny.market.domain.DomainPurchase;
import com.krawny.market.persistence.entity.Purchase;

import java.util.List;
import java.util.Optional;

public interface DomainPurchaseRepository {
    List<DomainPurchase> getAll();
    Optional<List<DomainPurchase>> getByClient(String clientId);
    DomainPurchase save(DomainPurchase domainPurchase);
}
