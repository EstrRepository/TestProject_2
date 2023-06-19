package by.itclass.listener;

import by.itclass.model.db.HibernateManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//Поднимаем сразу Hibernate
@WebListener
public class AppInitializedListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HibernateManager.buildSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateManager.closeSessionFactory();
    }
}
