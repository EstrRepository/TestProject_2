package by.itclass.model.services;

import by.itclass.model.entities.News;
import by.itclass.model.entities.User;

import java.util.List;

public interface NewsService {
    News get(int id);

    List<News> get(User user);

    List<News> get();

    void remove(News news);

    void refactor(News news);

    void like(int idNews, int idUser, String action);

    void add(News news);
}
