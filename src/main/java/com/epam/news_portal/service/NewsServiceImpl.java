package com.epam.news_portal.service;

import com.epam.news_portal.dao.NewsDAO;
import com.epam.news_portal.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsDAO newsDAO;

    @Override
    @Transactional
    public List<News> getAllNews() {
        return newsDAO.getAllNews();
    }

    @Override
    @Transactional
    public void saveNews(News news) {
        newsDAO.saveNews(news);
    }

    @Override
    @Transactional
    public News getNews(Long id) {
        return newsDAO.getNews(id);
    }

    @Override
    @Transactional
    public void deleteNews(Long id) {
        newsDAO.deleteNews(id);
    }
}
