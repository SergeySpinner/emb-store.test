package projectFiles.controller;

import projectFiles.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException;
}
