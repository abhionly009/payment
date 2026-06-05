package com.agh.Payment.repository;

import com.agh.Payment.entity.PaymentEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessedEventRepository extends JpaRepository<PaymentEvent, String> {
}
