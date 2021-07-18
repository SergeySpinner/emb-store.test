package projectFiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import projectFiles.dao.DaoException;
import projectFiles.dao.impl.ProductDaoImpl;
import projectFiles.entity.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private ProductDaoImpl productDaoImpl;

    @Autowired
    public void setProductDaoImpl(ProductDaoImpl productDaoImpl){
        this.productDaoImpl = productDaoImpl;
    }

    public List<Product> findAll() throws ServiceException {
        try{
            List<Product> products = productDaoImpl.findAll();
            return products;
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public Product findById(Integer productId) throws ServiceException{
        try{
            return productDaoImpl.getById(productId);
        }catch (DaoException e){
            throw new ServiceException();
        }
    }
}
