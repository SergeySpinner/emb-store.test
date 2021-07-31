package projectFiles.dao.impl;

import org.springframework.stereotype.Repository;
import projectFiles.utils.ConnectionPool;
import projectFiles.dao.exception.DaoException;
import projectFiles.dao.ProductDao;
import projectFiles.entity.Product;
import projectFiles.utils.ConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    private static final String PRODUCT_FIELD_FULL = "id, prodname, price, prodquantity, prodinfo";
    private static final String PRODUCT_FIELD = "prodname ,price, prodquantity, prodinfo";
    private static final String SELECT_ALL = "select " + PRODUCT_FIELD_FULL + " from \"Product\"";
    private static final String SELECT_BY_ID = "select " + PRODUCT_FIELD_FULL + " from \"Product\" where id = ?";

    private static final String INSERT_SQL = "insert into \"Product\"(" + PRODUCT_FIELD + ") values(?,?,?,?)";
    private static final String DELETE_SQL = "delete from \"Product\" where id = ?";
    private static final String UPDATE_COUNT = "update \"Product\" set prodquantity = ? where id = ?";

    private static final String SELECT_QUANTITY = "select \"Product\".prodquantity from \"Product\" " +
            "inner join \"Basket\" on \"Basket\".productid = \"Product\".id " +
            "where \"Basket\".id = ?";
//    private DataSource dataSource;
//
//    @Autowired
//    public void setProductDaoImpl(DataSource dataSource){
//        this.dataSource = dataSource;
//    }
    private ConnectionPool connectionPool = ConnectionSingleton.getConnection();

    @Override
    public Integer create(Product product) throws DaoException {
        try (
                Connection connection = connectionPool.get();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getProdQuantity());
            preparedStatement.setString(4, product.getProdInfo());

            preparedStatement.execute();
            Integer generatedKey = 0;

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                generatedKey = resultSet.getInt(1);
            }

            return generatedKey;

        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public void delete(Product product) throws DaoException {
        try (
                Connection connection = connectionPool.get();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)
        ) {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public List<Product> findAll() throws DaoException {
        List<Product> products = new ArrayList<>();
        try (
                Connection connection = connectionPool.get();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL)
        ) {
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("prodname"),
                        resultSet.getInt("price"),
                        resultSet.getInt("prodquantity"),
                        resultSet.getString("prodinfo")
                ));
            }

        } catch (SQLException e) {
            throw new DaoException();
        }
        return products;
    }

    @Override
    public Product getById(Integer id) throws DaoException {
        try (
                Connection connection = connectionPool.get(); //null
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Product(resultSet.getInt("id"),
                        resultSet.getString("prodname"),
                        resultSet.getInt("price"),
                        resultSet.getInt("prodquantity"),
                        resultSet.getString("prodinfo")
                );
            }
        } catch (SQLException e) {
            throw new DaoException();
        }
        return null;
    }

    @Override
    public void updateCountById(Integer productId, Connection connectionTemp) throws DaoException {
        try(Connection connection = connectionTemp;
            PreparedStatement quantityStatement = connection.prepareStatement(SELECT_QUANTITY);
            PreparedStatement updateStatement = connection.prepareStatement(UPDATE_COUNT)
        ) {
            quantityStatement.setInt(1, productId);
            ResultSet resultSet = quantityStatement.executeQuery();
            Integer quantityOfCurrentProduct = resultSet.getInt("prodquantity");
            if(quantityOfCurrentProduct == 0)
                throw new DaoException("Failed to buy product");
            else {
                updateStatement.setInt(1, --quantityOfCurrentProduct);
                updateStatement.setInt(2, productId);
                updateStatement.execute();
            }
        } catch (SQLException exception) {
            throw new DaoException("Failed to perform operation ProductDaoImpl.updateCountById");
        }
    }


}
