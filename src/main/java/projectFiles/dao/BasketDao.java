package projectFiles.dao;

import projectFiles.entity.Basket;

public interface BasketDao {
    void insertBasket(Basket basket) throws DaoException;

    void clearBasket(Basket basket) throws DaoException;

    void deletePositionOfBasket(Integer id) throws DaoException;

    void updateBasket(Basket basket) throws DaoException;

    Basket getUsersBasket(Integer userId) throws DaoException;
}
