package projectFiles.dao;

import projectFiles.dao.exception.DaoException;
import projectFiles.entity.Product;

import java.sql.Connection;
import java.util.List;

public interface ProductDao {
    /**
     * Function that creates new product
     *
     * @param product prepared object of Product class
     * @return generated product id
     */
    Integer create(Product product) throws DaoException;

    /**
     * Function that deletes product from DataBase
     *
     * @param product prepared object of Product class
     */
    void delete(Product product) throws DaoException;

    /**
     * Function that gets all existed products
     *
     * @return list of all products
     */
    List<Product> findAll() throws DaoException;

    /**
     * Function that receives product from DataBase by id
     *
     * @param id product id
     * @return product according to id
     */
    Product getById(Integer id) throws DaoException;

    /**
     * Function that updates quantity of product.
     * This function are transactional, so its uses connection with appropriate parameters
     *
     * @param id         product id
     * @param connection connection with parameters
     */
    void updateCountById(Integer id, Connection connection) throws DaoException;

}
