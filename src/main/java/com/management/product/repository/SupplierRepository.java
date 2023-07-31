package com.management.product.repository;

import com.management.product.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

Optional<Supplier> findById(Long id);
}
