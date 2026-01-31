package com.tnsif.Shoppingmall.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ShopsRepository extends JpaRepository<Shops, Long> {
List<Shops> findByStatus(String status);
}