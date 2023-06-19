package by.itclass.model.mapper;

import by.itclass.model.dto.NewsDTO;
import by.itclass.model.entities.News;

import java.util.ArrayList;
import java.util.List;

public class NewsMapper {
    public static News map(NewsDTO newsDTO) {
        return new News(newsDTO.getId(), newsDTO.getTitle(), newsDTO.getText(), newsDTO.getDate(), newsDTO.getLikes(), newsDTO.getDislikes(), newsDTO.getImage());
    }

    public static NewsDTO map(News news) {
        return new NewsDTO(news.getId(), news.getTitle(), news.getText(), news.getDate(),
                news.getLikes(), news.getDislikes(), news.getImage());
    }

    public static List<NewsDTO> map(List<News> newsList) {
        List<NewsDTO> newsListDTO = new ArrayList<>();
        for (News news : newsList) {
            NewsDTO newsDTO = NewsMapper.map(news);
            newsListDTO.add(newsDTO);
        }
        return newsListDTO;
    }
}
