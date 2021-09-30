package projectFiles.service.impl;

import projectFiles.dao.*;
import projectFiles.dao.exception.DaoException;
import projectFiles.dao.impl.BasketDaoImpl;
import projectFiles.dao.impl.ProductDaoImpl;
import projectFiles.entity.Basket;
import projectFiles.service.BasketService;
import projectFiles.service.exception.ServiceException;
import projectFiles.utils.ConnectionPool;
import projectFiles.utils.ConnectionSingleton;

import java.sql.Connection;
import java.sql.SQLException;

public class BasketServiceImpl implements BasketService {
    private final BasketDao basketDao = new BasketDaoImpl();
    private final ProductDao productDao = new ProductDaoImpl();
    private final ConnectionPool connectionPool = ConnectionSingleton.getConnection();

    @Override
    public void insertService(Basket basket) throws ServiceException {
        try {
            basketDao.insertBasket(basket);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void clearService(Basket basket) throws ServiceException {
        try {
            basketDao.clearBasket(basket);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void updateService(Basket basket) throws ServiceException {
        try {
            basketDao.updateBasket(basket);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Basket getUsersBasket(Integer userId) throws ServiceException {
        try {
            return basketDao.getUsersBasket(userId);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void deleteProductPosition(Integer productId) throws ServiceException {
        try {
            basketDao.deletePositionOfBasket(productId);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void buyPositionOfProduct(Integer productId) throws ServiceException, SQLException {
        Connection connection = connectionPool.get();
        try {
            connection.setAutoCommit(false);
            productDao.updateCountById(productId, connection);
            basketDao.buyPositionOfBasket(productId, connection);
            connection.commit();
        } catch (DaoException e) {
            throw new ServiceException("Failed to make a transaction");
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException exception) {
                throw new ServiceException("Failed to rollback transaction");
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException exception) {
                throw new SQLException("Failed return autoCommit to true condition");
            }
        }
    }
}
