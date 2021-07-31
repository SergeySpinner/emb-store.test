package projectFiles.dao;

import projectFiles.dao.exception.DaoException;
import projectFiles.entity.Basket;

import java.sql.Connection;

public interface BasketDao {
    void insertBasket(Basket basket) throws DaoException;

    void clearBasket(Basket basket) throws DaoException;

    void deletePositionOfBasket(Integer id) throws DaoException;

    void updateBasket(Basket basket) throws DaoException;

    Basket getUsersBasket(Integer userId) throws DaoException;

    void buyPositionOfBasket(Integer basketId, Connection connection) throws DaoException;
}
