package by.itclass.controllers.abstracs;

import by.itclass.model.facades.UserFacade;
import by.itclass.model.facades.UserFacadeImpl;

import javax.servlet.annotation.WebServlet;

//Уровень абстракции над контроллерами, обрабатывающими запросы для User сущностей
@WebServlet(name = "AbstractUserController")
public abstract class AbstractUserController extends AbstractController {
    //Вводим общее описание, которое будет наследоваться другими контроллерами
    protected UserFacade userFacade;

    public AbstractUserController() {
        userFacade = new UserFacadeImpl();
    }
}
