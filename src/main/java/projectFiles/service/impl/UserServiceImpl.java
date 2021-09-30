package projectFiles.service.impl;

import projectFiles.dao.UserDao;
import projectFiles.dao.exception.DaoException;
import projectFiles.dao.impl.UserDaoImpl;
import projectFiles.entity.User;
import org.springframework.stereotype.Service;
import projectFiles.service.UserService;
import projectFiles.service.exception.ServiceException;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User getByLogin(String login) throws ServiceException {
        try {
            return userDao.getByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Integer createUser(User user) throws ServiceException {
        try {
            return userDao.create(user);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public User getByEmail(String email) throws ServiceException {
        try {
            return userDao.getByEmail(email);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public User getById(Integer id) throws ServiceException {
        try {
            return userDao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

}
