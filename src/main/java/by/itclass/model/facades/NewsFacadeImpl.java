package by.itclass.model.facades;

import by.itclass.model.dto.NewsDTO;
import by.itclass.model.dto.UserDTO;
import by.itclass.model.entities.Image;
import by.itclass.model.entities.News;
import by.itclass.model.entities.User;
import by.itclass.model.mapper.NewsMapper;
import by.itclass.model.mapper.UserMapper;
import by.itclass.model.services.NewsServiceImpl;

import java.util.Date;
import java.util.List;

public class NewsFacadeImpl implements NewsFacade {
    private NewsServiceImpl newsService;

    public NewsFacadeImpl() {
        newsService = new NewsServiceImpl();
    }

    @Override
    public NewsDTO get(int id) {
        News news = newsService.get(id);
        return NewsMapper.map(news);
    }

    @Override
    public List<NewsDTO> get(UserDTO userDTO) {
        User user = UserMapper.map(userDTO);
        List<News> newsList = newsService.get(user);
        return NewsMapper.map(newsList);
    }

    @Override
    public List<NewsDTO> get() {
        List<News> newsList = newsService.get();
        return NewsMapper.map(newsList);
    }

    @Override
    public void remove(NewsDTO newsDTO) {
        News news = NewsMapper.map(newsDTO);
        newsService.remove(news);
    }

    @Override
    public void refactor(NewsDTO newsDTO, String fileName, byte[] fileContent) {
        if (fileName.length() > 0) {
            newsDTO.setImage(new Image(fileName, fileContent));
        }
        News news = NewsMapper.map(newsDTO);
        newsService.refactor(news);
    }

    @Override
    public void like(int idNews, int idUser, String action) {
        newsService.like(idNews, idUser, action);
    }

    @Override
    public void add(NewsDTO newsDTO, int idUser, String fileName, byte[] fileContent) {
        News news = NewsMapper.map(newsDTO);
        news.setDate(new Date());
        news.setIdUser(idUser);
        news.setImage(new Image(fileName, fileContent));
        newsService.add(news);
    }
}
