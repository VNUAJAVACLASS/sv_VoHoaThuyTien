package vnua.fita.tthieu.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vnua.fita.tthieu.springboot.entity.Order;



public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("""
        select o from Order o
        left join fetch o.orderBook ob
        left join fetch ob.book
        where o.order_id = :id
    """)
    Optional<Order> findDetailById(@Param("id") Long id);
}
