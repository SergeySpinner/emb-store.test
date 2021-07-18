package projectFiles.service;

import projectFiles.dao.impl.BasketDaoImpl;
import projectFiles.dao.exception.DaoException;
import projectFiles.entity.Basket;

public class BasketService {
    private BasketDaoImpl basketDaoImpl = new BasketDaoImpl();

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
}
