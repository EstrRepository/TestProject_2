package by.itclass.model.services;

import by.itclass.model.dao.impl.NewsDAOHibernateImpl;
import by.itclass.model.dao.interfaces.NewsDAO;
import by.itclass.model.entities.News;
import by.itclass.model.entities.User;
import java.util.List;

public class NewsServiceImpl implements NewsService{
    private NewsDAO newsDAO;

    public NewsServiceImpl() {
        newsDAO = new NewsDAOHibernateImpl();
    }

    @Override
    public News get(int id) {
        return newsDAO.get(id);
    }

    @Override
    public List<News> get(User user) {
        return newsDAO.getList(user);
    }

    @Override
    public List<News> get() {
        return newsDAO.getList();
    }

    @Override
    public void remove(News news) {
        newsDAO.delete(news);
    }

    @Override
    public void refactor(News news) {
        newsDAO.update(news);
    }

    @Override
    public void like(int idNews, int idUser, String action) {
        newsDAO.likes(idNews, idUser, action);
    }

    @Override
    public void add(News news) {
        newsDAO.save(news);
    }

}
