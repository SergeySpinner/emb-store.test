package projectFiles.controller;

import projectFiles.api.WeatherData;
import projectFiles.api.WeatherInfo;
import projectFiles.entity.User;
import projectFiles.entity.UserRole;
import projectFiles.service.exception.ServiceException;
import projectFiles.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProfileController implements Controller {

    final UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        WeatherData weather = WeatherInfo.getWeather();
        User user = userService.getById(userId);
        req.setAttribute("currentTemp", weather.getTemperature().getTemp());
        req.setAttribute("minimumTemp", weather.getTemperature().getTemp_min());
        req.setAttribute("maximumTemp", weather.getTemperature().getTemp_max());
        req.setAttribute("humidity", weather.getTemperature().getHumidity());
        req.getSession().setAttribute("user", user);
        if(user.getRole() == UserRole.ADMIN)
            return new ControllerResultDto("admin");
        else if(user.getRole() == UserRole.MANUFACTURER)
            return new ControllerResultDto("manufacturer");
        else
            return new ControllerResultDto("user");
    }
}
