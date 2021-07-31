package projectFiles.service;

import projectFiles.dao.exception.DaoException;
import projectFiles.dao.impl.UserDaoImpl;
import projectFiles.entity.User;
import org.springframework.stereotype.Service;
import projectFiles.service.exception.ServiceException;

@Service
public class UserService {
    private UserDaoImpl userDaoImpl = new UserDaoImpl();

    public User getByLogin(String name) throws ServiceException {
        try {
            return userDaoImpl.getByLogin(name);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public Integer createUser(User user) throws ServiceException {
        try {
            return userDaoImpl.create(user);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public User getByEmail(String email) throws ServiceException {
        try {
            return userDaoImpl.getByEmail(email);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public User getById(Integer id) throws ServiceException {
        try {
            return userDaoImpl.getById(id);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

}
