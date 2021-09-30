package projectFiles.dao;

import projectFiles.dao.exception.DaoException;
import projectFiles.entity.Basket;

import java.sql.Connection;

public interface BasketDao {
    /**
     * Function that inserts the user's basket in DataBase
     *
     * @param basket user's basket
     */
    void insertBasket(Basket basket) throws DaoException;

    /**
     * Function that clears user's basket
     *
     * @param basket actual object of Basket class
     */
    void clearBasket(Basket basket) throws DaoException;

    /**
     * Function that deletes basket by id
     *
     * @param id the basket id
     */
    void deletePositionOfBasket(Integer id) throws DaoException;

    /**
     * Function that updates a data about the basket in DataBase
     *
     * @param basket user's basket
     */
    void updateBasket(Basket basket) throws DaoException;

    /**
     * Function that gets user's basket by his id
     *
     * @param userId user's id
     * @return user's basket
     */
    Basket getUsersBasket(Integer userId) throws DaoException;

    /**
     * Function that decreases quantity of product.
     * This function are transactional, so its uses connection with appropriate parameters
     *
     * @param basketId   id of product
     * @param connection connection with parameters
     */
    void buyPositionOfBasket(Integer basketId, Connection connection) throws DaoException;
}
