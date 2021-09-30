package projectFiles.controller;

import projectFiles.api.WeatherData;
import projectFiles.api.WeatherInfo;
import projectFiles.entity.Product;
import projectFiles.entity.User;
import projectFiles.entity.UserRole;
import projectFiles.service.impl.ProductServiceImpl;
import projectFiles.service.exception.ServiceException;
import projectFiles.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ProfileController implements Controller {

    private final UserServiceImpl userServiceImpl = new UserServiceImpl();
    private final ProductServiceImpl productServiceImpl = new ProductServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        WeatherData weather = WeatherInfo.getWeather();
        User user = userServiceImpl.getById(userId);
        req.setAttribute("currentTemp", weather.getTemperature().getTemp());
        req.setAttribute("minimumTemp", weather.getTemperature().getTemp_min());
        req.setAttribute("maximumTemp", weather.getTemperature().getTemp_max());
        req.setAttribute("humidity", weather.getTemperature().getHumidity());
        req.getSession().setAttribute("user", user);
        if(user.getRole() == UserRole.ADMIN)
            return new ControllerResultDto("admin");
        else if(user.getRole() == UserRole.MANUFACTURER){
            List<Product> productsFindAll = productServiceImpl.findAll();
            List<Product> resultProducts = productsFindAll.stream()
                    .filter(i -> i.getCreatorId() == user.getId())
                    .collect(Collectors.toList());

            req.setAttribute("products", resultProducts);
            return new ControllerResultDto("manufacturer");
        }
        else
            return new ControllerResultDto("user");
    }
}
