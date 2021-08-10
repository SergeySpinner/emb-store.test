package projectFiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projectFiles.entity.spring.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select p.id, p.prodname, p.price, p.prodquantity, p.prodinfo" +
            " from basket b inner join products p on p.id = b.productid where b.userid = ?1 order by p.id", nativeQuery = true)
    List<Product> getUsersBasket(Integer id);

    List<Product> findAll();

    void deleteById(Integer productId);

    Product getById(Integer productId);
}