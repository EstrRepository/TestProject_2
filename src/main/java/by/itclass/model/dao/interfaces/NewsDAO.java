package by.itclass.model.dao.interfaces;

import by.itclass.model.entities.News;
import by.itclass.model.entities.User;

import java.util.List;

public interface NewsDAO {
    News get(int id);
    List<News> getList(User user);
    List<News> getList();
    void delete(News news);
    void update(News news);
    void likes(int idNews, int idUser, String action);
    void save(News news);
}
