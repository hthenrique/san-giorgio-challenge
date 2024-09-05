package ht.henrique.repository;

import ht.henrique.model.database.Charge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChargeRepository extends JpaRepository<Charge, Long> {

    Optional<Charge> findBy_codCharge(String _codCharge);
}
