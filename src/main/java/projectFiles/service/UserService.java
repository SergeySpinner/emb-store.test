package projectFiles.service;

import projectFiles.entity.User;
import projectFiles.service.exception.ServiceException;

public interface UserService {
    /**
     * Function that finds user by his login
     *
     * @param login user's login
     * @return user according to login
     */
    User getByLogin(String login) throws ServiceException;

    /**
     * Function that adds new user in DataBase
     *
     * @param user prepared object of User class
     * @return user's id
     */
    Integer createUser(User user) throws ServiceException;

    /**
     * Function that finds user by his mail address
     *
     * @param email user's mail address
     * @return user according to mail address
     */
    User getByEmail(String email) throws ServiceException;

    /**
     * Function that finds user by his id
     *
     * @param id user's id
     * @return user according to id
     */
    User getById(Integer id) throws ServiceException;
}
