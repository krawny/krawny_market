package com.krawny.market.persistence;

import com.krawny.market.domain.DomainPurchase;
import com.krawny.market.domain.repository.DomainPurchaseRepository;
import com.krawny.market.persistence.crud.PurchaseCrudRepository;
import com.krawny.market.persistence.entity.Purchase;
import com.krawny.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements DomainPurchaseRepository {

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<DomainPurchase> getAll() {
        List<Purchase> purchases = (List<Purchase>) purchaseCrudRepository.findAll();
        return purchaseMapper.toDomainPurchases(purchases);
    }

    @Override
    public Optional<List<DomainPurchase>> getByClient(String clientId) {
        return purchaseCrudRepository.findByIdClient(clientId)
                .map(purchases -> purchaseMapper.toDomainPurchases(purchases));
    }

    @Override
    public DomainPurchase save(DomainPurchase domainPurchase) {
        Purchase purchase = purchaseMapper.toPurchase(domainPurchase);
        purchase.getProductPurchaseList().forEach(productPurchase -> productPurchase.setPurchase(purchase));

        return purchaseMapper.toDomainPurchase(purchaseCrudRepository.save(purchase));
    }
}
