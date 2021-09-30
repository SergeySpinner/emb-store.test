package projectFiles.controller;

import projectFiles.entity.Product;
import projectFiles.service.impl.BasketServiceImpl;
import projectFiles.service.impl.ProductServiceImpl;
import projectFiles.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteBasketItemController implements Controller {
    private BasketServiceImpl basketServiceImpl = new BasketServiceImpl();
    private ProductServiceImpl productServiceImpl = new ProductServiceImpl();
    private ShowBasketPageController sbpc = new ShowBasketPageController();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        try {
            Integer basketProductId = Integer.parseInt(req.getParameter("productId"));
            basketServiceImpl.deleteProductPosition(basketProductId);

            List<Product> products = productServiceImpl.findAll();

            req.setAttribute("products", products);

            return sbpc.execute(req, resp);
        } catch (ServiceException e) {
            return new ControllerResultDto("error-500");
        }
    }
}
