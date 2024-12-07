package com.panic.sasserver.repository;

import com.panic.sasserver.model.AppUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);

    @Modifying
    @Transactional
    @Query("UPDATE AppUser u SET u.address = :address WHERE u.email = :email")
    Boolean updateAddressByEmail(@Param("email") String email, @Param("address") String address);
}
