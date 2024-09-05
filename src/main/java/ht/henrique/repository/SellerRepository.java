package ht.henrique.repository;

import ht.henrique.model.database.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    Seller findBy_codSeller(String _codSeller);
}
