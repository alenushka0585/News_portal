package com.epam.news_portal.controller;

import com.epam.news_portal.entity.News;
import com.epam.news_portal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/")
    public String showAllNews(Model model){

        List<News> newsList = newsService.getAllNews();
        System.out.println(newsList);
        model.addAttribute("allNews", newsList);

        return "all-news";
    }

    @RequestMapping("/addNewNews")
    public String addNewNews(Model model){

        News news = new News();
        model.addAttribute("news", news);

        return "news-info";
    }

    @RequestMapping("/saveNews")
    public String saveNews(@ModelAttribute("news") News news){

        newsService.saveNews(news);

        return "redirect:/";
    }

    @RequestMapping("/editInfo")
    public String updateNews(@RequestParam("newsId") Long id, Model model){

        News news = newsService.getNews(id);
        model.addAttribute("news", news);

        return "news-info";
    }

    @RequestMapping("/deleteNews")
    public String deleteNews(@RequestParam("newsId") Long id){

        newsService.deleteNews(id);

        return "redirect:/";
    }
}
