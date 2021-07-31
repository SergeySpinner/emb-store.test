package projectFiles.service;

import projectFiles.dao.impl.BasketDaoImpl;
import projectFiles.dao.exception.DaoException;
import projectFiles.dao.impl.ProductDaoImpl;
import projectFiles.entity.Basket;
import projectFiles.service.exception.ServiceException;
import projectFiles.utils.ConnectionPool;
import projectFiles.utils.ConnectionSingleton;

import java.sql.Connection;
import java.sql.SQLException;

public class BasketService {
    private BasketDaoImpl basketDaoImpl = new BasketDaoImpl();
    private ProductDaoImpl productDaoImpl = new ProductDaoImpl();
    private ConnectionPool connectionPool = ConnectionSingleton.getConnection();

    public void insertService(Basket basket) throws ServiceException {
        try {
            basketDaoImpl.insertBasket(basket);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

//    public void deleteService() throws ServiceException{
//        try {
//            basketDao.deletePositionOfBasket();
//        } catch (DaoException e){
//            throw new ServiceException();
//        }
//    }

    public void clearService(Basket basket) throws ServiceException {
        try {
            basketDaoImpl.clearBasket(basket);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public void updateService(Basket basket) throws ServiceException {
        try {
            basketDaoImpl.updateBasket(basket);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public Basket getUsersBasket(Integer userId) throws ServiceException {
        try {
            return basketDaoImpl.getUsersBasket(userId);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public void deleteProductPosition(Integer productId) throws ServiceException {
        try {
            basketDaoImpl.deletePositionOfBasket(productId);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public void buyPositionOfProduct(Integer productId) throws ServiceException, SQLException {
        Connection connection = connectionPool.get();
        try {
            connection.setAutoCommit(false);
            productDaoImpl.updateCountById(productId, connection);
            basketDaoImpl.buyPositionOfBasket(productId, connection);
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
