package com.epam.news_portal.dao;

import com.epam.news_portal.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDAOImpl implements NewsDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<News> getAllNews() {

        Session session = sessionFactory.getCurrentSession();
        List<News> newsList = session.createQuery("from News", News.class).getResultList();

        return newsList;
    }

    @Override
    public void saveNews(News news) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(news);
    }

    @Override
    public News getNews(Long id) {
        Session session = sessionFactory.getCurrentSession();
        News news = session.get(News.class, id);

        return news;
    }

    @Override
    public void deleteNews(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<News> query = session.createQuery("delete from News " +
                "where id=:newsId");
        query.setParameter("newsId", id);
        query.executeUpdate();
    }
}
