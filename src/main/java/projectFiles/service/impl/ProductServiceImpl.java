package projectFiles.service.impl;

import projectFiles.dao.ProductDao;
import projectFiles.dao.exception.DaoException;
import projectFiles.dao.impl.ProductDaoImpl;
import projectFiles.entity.Product;
import projectFiles.service.ProductService;
import projectFiles.service.exception.ServiceException;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> findAll() throws ServiceException {
        try {
            List<Product> products = productDao.findAll();
            return products;
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Product findById(Integer productId) throws ServiceException {
        try {
            return productDao.getById(productId);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void delete(Product product) throws ServiceException {
        try {
            productDao.delete(product);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }
}
