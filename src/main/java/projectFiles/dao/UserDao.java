package projectFiles.dao;

import projectFiles.dao.exception.DaoException;
import projectFiles.entity.User;

import java.util.List;

public interface UserDao {
    /**
     * Function that adds new user in DataBase
     *
     * @param user prepared object of User class
     * @return user's id
     */
    Integer create(User user) throws DaoException;

    /**
     * Function that deletes user from DataBase
     *
     * @param user prepared object of User class
     */
    void delete(User user) throws DaoException;

    /**
     * Function that gets all existed users
     *
     * @return list of users
     */
    List<User> findAll() throws DaoException;

    /**
     * Function that finds user by his id
     *
     * @param id user's id
     * @return user according to id
     */
    User getById(Integer id) throws DaoException;

    /**
     * Function that finds user by his login
     *
     * @param login user's login
     * @return user according to login
     */
    User getByLogin(String login) throws DaoException;

    /**
     * Function that finds user by his mail address
     *
     * @param email user's mail address
     * @return user according to mail address
     */
    User getByEmail(String email) throws DaoException;
}
