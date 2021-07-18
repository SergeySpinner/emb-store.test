package projectFiles.service;

import org.springframework.context.annotation.Bean;
import projectFiles.dao.impl.BasketDaoImpl;
import projectFiles.dao.DaoException;
import projectFiles.entity.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {
    BasketService basketService;
    private BasketDaoImpl basketDaoImpl;

    @Autowired
    public void setBasketDaoImpl(BasketDaoImpl basketDaoImpl) {
        this.basketDaoImpl = basketDaoImpl;
        basketService = new BasketService();
    }

    @Bean
    public BasketService getBasketService() {
        return basketService;
    }

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
