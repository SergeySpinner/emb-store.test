package projectFiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectFiles.entity.spring.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    void deleteById(Integer userId);

    List<User> findAll();

    User getById(Integer userId);

    User getByLogin(String userLogin);

    User getUserByMailContact(String mail);

//    List<User> findByIdGreaterThan(Integer id);
//
//    @Query(value = "select * from users where id <= :id_param", nativeQuery = true)
//    List<User> testQuery(@Param("id_param") Integer id);
//
//    @Query(value = "select * from users where id <= ?1", nativeQuery = true)
//    List<User> testQuery2(Integer id);
}
