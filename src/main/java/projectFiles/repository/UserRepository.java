package projectFiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projectFiles.entity.spring.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAll();

    List<User> findByIdGreaterThan(Integer id);

    @Query(value = "select * from users where id <= :id_param", nativeQuery = true)
    List<User> testQuery(@Param("id_param") Integer id);

    @Query(value = "select * from users where id <= ?1", nativeQuery = true)
    List<User> testQuery2(Integer id);
}
