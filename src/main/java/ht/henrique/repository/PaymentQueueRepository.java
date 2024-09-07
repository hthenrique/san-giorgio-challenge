package ht.henrique.repository;

import ht.henrique.model.database.Charge;
import ht.henrique.model.database.PaymentQueue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentQueueRepository extends JpaRepository<PaymentQueue, Long> {

    List<PaymentQueue> findByStatus(String status);
}
