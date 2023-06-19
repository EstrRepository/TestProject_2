package by.itclass.controllers.abstracs;

import by.itclass.model.facades.NewsFacade;
import by.itclass.model.facades.NewsFacadeImpl;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AbstractNewsController")
public abstract class AbstractNewsController extends AbstractController {
    protected NewsFacade newsFacade;

    public AbstractNewsController() {
        newsFacade = new NewsFacadeImpl();
    }
}
