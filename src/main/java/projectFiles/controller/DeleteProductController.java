package projectFiles.controller;

import projectFiles.entity.Product;
import projectFiles.service.impl.ProductServiceImpl;
import projectFiles.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteProductController implements Controller{
    private final ShopController shopController = new ShopController();
    private final ProductServiceImpl productServiceImpl = new ProductServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        try {
            String productId = req.getParameter("productId");
            Product product = productServiceImpl.findById(Integer.parseInt(productId));
            productServiceImpl.delete(product);

            List<Product> products = productServiceImpl.findAll();
            req.setAttribute("products", products);

            return shopController.execute(req, resp);
        } catch (ServiceException e) {
            return new ControllerResultDto("error-500");
        }
    }
}
