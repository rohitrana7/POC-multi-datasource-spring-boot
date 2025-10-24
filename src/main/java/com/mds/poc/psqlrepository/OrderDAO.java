package com.mds.poc.psqlrepository;

import com.mds.poc.psqlentity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Integer> {
}
