package by.itclass.model.facades;

import by.itclass.model.dto.NewsDTO;
import by.itclass.model.dto.UserDTO;

import java.util.List;

public interface NewsFacade {
    NewsDTO get(int id);

    List<NewsDTO> get(UserDTO userDTO);

    List<NewsDTO> get();

    void remove(NewsDTO news);

    void refactor(NewsDTO news, String fileName, byte[] fileContent);

    void like(int idNews, int idUser, String action);

    void add(NewsDTO news, int idUser, String fileName, byte[] fileContent);
}
