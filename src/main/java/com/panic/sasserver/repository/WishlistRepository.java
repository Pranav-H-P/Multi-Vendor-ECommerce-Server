package com.panic.sasserver.repository;

import com.panic.sasserver.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistItem, Long> {
}
