package by.itclass.model.comparator;

import by.itclass.model.dto.NewsDTO;

import java.util.Comparator;

public class SortedNewsByLikesComparator implements Comparator<NewsDTO> {
    @Override
    public int compare(NewsDTO news1, NewsDTO news2) {
        return news2.getLikes() - news1.getLikes();
    }
}
