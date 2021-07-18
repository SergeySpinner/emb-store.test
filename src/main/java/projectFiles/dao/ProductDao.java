package projectFiles.dao;

import projectFiles.dao.exception.DaoException;
import projectFiles.entity.Product;

import java.util.List;

public interface ProductDao {
    Integer create(Product product) throws DaoException;

    void delete(Product product) throws DaoException;

    List<Product> findAll() throws DaoException;

    Product getById(Integer id) throws DaoException;
}
