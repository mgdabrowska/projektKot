package pl.kobietydokodu.koty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kobietydokodu.koty.CatDAO;
//import pl.kobietydokodu.koty.CatDAO;
//import pl.kobietydokodu.koty.CatDAO;

@Controller
public class KotyController {

@Autowired
  CatDAO catDAO;


    @RequestMapping("/glowny")
    public String przykladModelu(Model model) {
        model.addAttribute("message", " To jest jakaś super informacja");

        return "glowny";
    }

    @RequestMapping("/addCat")
    public String addCat(Model model) {
        return "addCat";
    }

    @RequestMapping("/listofCats")
    public String listCat(Model model) {
        model.addAttribute("cats",catDAO.getCats());
        return "listofCats";
    }

    @RequestMapping("/cat-{id}")
    public String detailsCat(@PathVariable("id") int id,  Model model){
        model.addAttribute("cat", catDAO.getCatById(id));
        return "details";
}
}
