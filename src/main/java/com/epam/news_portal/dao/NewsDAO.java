package com.epam.news_portal.dao;

import com.epam.news_portal.entity.News;

import java.util.List;

public interface NewsDAO {
    public List<News> getAllNews();

    public void saveNews(News news);

    public News getNews(Long id);

    public void deleteNews(Long id);
}
