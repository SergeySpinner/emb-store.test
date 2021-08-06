package projectFiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectFiles.entity.spring.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
}