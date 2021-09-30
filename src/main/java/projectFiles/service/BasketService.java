package projectFiles.service;

import projectFiles.entity.Basket;
import projectFiles.service.exception.ServiceException;

import java.sql.SQLException;

public interface BasketService {
    /**
     * Function that inserts the user's basket in DataBase
     *
     * @param basket user's basket
     */
    void insertService(Basket basket) throws ServiceException;

    /**
     * Function that clears user's basket
     *
     * @param basket actual object of Basket class
     */
    void clearService(Basket basket) throws ServiceException;

    /**
     * Function that updates a data about the basket in DataBase
     *
     * @param basket user's basket
     */
    void updateService(Basket basket) throws ServiceException;

    /**
     * Function that gets user's basket by his id
     *
     * @param userId user's id
     * @return user's basket
     */
    Basket getUsersBasket(Integer userId) throws ServiceException;

    /**
     * Function that deletes basket by id
     *
     * @param productId the basket id
     */
    void deleteProductPosition(Integer productId) throws ServiceException;

    /**
     * Function that decreases quantity of product
     *
     * @param productId id of product
     */
    void buyPositionOfProduct(Integer productId) throws ServiceException, SQLException;
}
