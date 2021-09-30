package projectFiles.controller;

import projectFiles.entity.Basket;
import projectFiles.entity.BasketState;
import projectFiles.entity.Product;
import projectFiles.service.impl.BasketServiceImpl;
import projectFiles.service.impl.ProductServiceImpl;
import projectFiles.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddBasketController implements Controller {
    private final ProductServiceImpl productServiceImpl = new ProductServiceImpl();
    private final BasketServiceImpl basketServiceImpl = new BasketServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        try {
            String productId = req.getParameter("productId");
            Product product = productServiceImpl.findById(Integer.parseInt(productId));
            Integer buyerId = (Integer) req.getSession().getAttribute("userId");

            Basket basket = new Basket(BasketState.ON_AGREEMENT.toString(), product, buyerId);
            basketServiceImpl.insertService(basket);
            List<Product> products = productServiceImpl.findAll();
            req.setAttribute("products", products);

            return new ControllerResultDto("shop-page");
        } catch (ServiceException e) {
            return new ControllerResultDto("error-500");
        }
    }
}
