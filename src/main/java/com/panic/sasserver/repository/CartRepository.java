package com.panic.sasserver.repository;

import com.panic.sasserver.dto.CartItemDTO;
import com.panic.sasserver.model.CartItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
    @Query("""
            SELECT c from CartItem c where c.userId = :userid
            """)
    List<CartItem> findAllByUser(@Param("userid") Long userid);

    @Modifying
    @Query("""
            DELETE FROM CartItem c WHERE c.userId = :userid
            """)
    void deleteAllByUserId(@Param("userid") Long userid);
}
