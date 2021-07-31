package projectFiles.controller;

import projectFiles.service.BasketService;
import projectFiles.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class BuyingOfProductController implements Controller {

    private final ShowBasketPageController sbpc = new ShowBasketPageController();
    private BasketService basketService = new BasketService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        try {
            Integer productId = Integer.parseInt(req.getParameter("productId"));
            basketService.buyPositionOfProduct(productId);

            return sbpc.execute(req, resp);
        } catch (ServiceException | SQLException e) {
            return new ControllerResultDto("error-500");
        }
    }
}
