package pl.kobietydokodu.koty.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kobietydokodu.koty.CatDAO;
import pl.kobietydokodu.koty.domain.Cat;
import pl.kobietydokodu.koty.controllers.CatDTO;

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

    @GetMapping ("/addCat")
    public String addCatForm(@ModelAttribute("catDto") CatDTO catDTO) {
        return "addCat";
    }
    @PostMapping ("/addCat")
    public String addCat(@ModelAttribute("catDto") @Valid CatDTO catDto, BindingResult result) {

        if (!result.hasErrors()) {
            Cat cat = new Cat();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            try {
                cat.setDateBirth(sdf.parse(catDto.getDateofBirth()));
            } catch (ParseException e) {
                result.rejectValue("dateofBirth", "invalid.date", "Invalid date format. Please use dd.MM.yyyy.");
            }
            if (!result.hasErrors()) {
                cat.setName(catDto.getName());
                cat.setWeight(catDto.getWeight());
                cat.setNameofMentor(catDto.getNameofOwner());
                catDAO.addCat(cat);
                return "redirect:/listofCats";
            }

        }
            return "addCat";
        }


    @GetMapping("/listofCats")
    public String listCats(Model model) {
        model.addAttribute("cats",catDAO.getCats());
        return "listofCats";
    }

    @GetMapping("/cat-{id}")
    public String detailsCat(@PathVariable("id") int id,  Model model){
        model.addAttribute("cat", catDAO.getCatById(id));
        return "details";
}
}
