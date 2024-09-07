package ht.henrique.repository;

import ht.henrique.model.database.Charge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargeRepository extends JpaRepository<Charge, Long> {

    Charge findBy_codCharge(String _codCharge);
}
