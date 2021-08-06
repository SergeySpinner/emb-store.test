package projectFiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectFiles.entity.spring.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
