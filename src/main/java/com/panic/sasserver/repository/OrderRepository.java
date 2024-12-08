package com.panic.sasserver.repository;

import com.panic.sasserver.dto.OrderDTO;
import com.panic.sasserver.model.CustOrder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<CustOrder, Long> {
    @Query("""
            SELECT o from CustOrder o where o.userId = :userid
            """)
    List<CustOrder> findAllOrdersById(@Param("userid")Long userId, Pageable pageable);

    @Query("""
            SELECT o from CustOrder o where o.userId = :userid AND o.productId = :prodid
            """)
    List<CustOrder> findIfProductExists(@Param("userid") Long userId,@Param("prodid") Long productId);
}
