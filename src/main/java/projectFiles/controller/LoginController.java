package projectFiles.controller;

import projectFiles.entity.User;
import projectFiles.service.exception.ServiceException;
import projectFiles.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements Controller {

    private final UserService userService = new UserService();
    private final ProfileController profileController = new ProfileController();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userService.getByLogin(login);
        if (user.getPassword().equals(password)) {
            req.setAttribute("user", user);
            req.getSession().setAttribute("userId", user.getId());
            return profileController.execute(req, resp);
        } else {
            return new ControllerResultDto("error-403");
        }
    }
}