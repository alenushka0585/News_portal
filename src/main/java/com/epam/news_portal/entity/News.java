package com.epam.news_portal.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_id_generator")
    @SequenceGenerator(name = "news_id_generator", sequenceName = "NEWS_INCREMENT", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "news_date")
    private Date news_date;

    @Column(name = "brief")
    private String brief;

    @Column(name = "content")
    private String content;

    public News() {
    }

    public News(String title, Date date, String brief, String content) {
        this.title = title;
        this.news_date = date;
        this.brief = brief;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getNews_date() {
        return news_date;
    }

    public void setNews_date(Date date) {
        this.news_date = date;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", news_date=" + news_date +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        return id != null ? id.equals(news.id) : news.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
