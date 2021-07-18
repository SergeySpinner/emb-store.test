package projectFiles.dao;

import projectFiles.dao.exception.DaoException;
import projectFiles.entity.User;
import java.util.List;

public interface UserDao {
    Integer create(User user) throws DaoException;

    void delete(User user) throws DaoException;

    List<User> findAll() throws DaoException;

    User getById(Integer id) throws DaoException;

    User getByLogin(String login) throws DaoException;

    User getByEmail(String email) throws DaoException;
}
