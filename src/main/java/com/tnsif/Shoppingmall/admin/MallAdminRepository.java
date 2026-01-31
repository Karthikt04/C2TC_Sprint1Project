package com.tnsif.Shoppingmall.admin;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MallAdminRepository extends JpaRepository<MallAdmin, Long> {
MallAdmin findByUsernameAndPassword(String username, String password);
}
