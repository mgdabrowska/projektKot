package pl.kobietydokodu.koty.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kobietydokodu.koty.CatDAO;
import pl.kobietydokodu.koty.domain.Cat;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public String addCat(HttpServletRequest request, @ModelAttribute("catDto") @Valid CatDTO catDto, BindingResult result) {
        if(request.getMethod().equalsIgnoreCase("post") && !result.hasErrors()){
            Cat cat = new Cat();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            try{
                cat.setDateBirth(sdf.parse(catDto.getDateofBirth()));
            }catch (ParseException e){
                e.printStackTrace();
            }
            cat.setName(catDto.getName());
            cat.setWeight(catDto.getWeight());
            cat.setNameofMentor(catDto.getNameofOwner());
            catDAO.addCat(cat);
            return "redirect:/listodCats";
        }


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
