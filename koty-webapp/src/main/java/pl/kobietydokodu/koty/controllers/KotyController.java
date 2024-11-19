package main.java.pl.kobietydokodu.koty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kobietydokodu.koty.CatDAO;

@Controller
public class KotyController {

@Autowired
private CatDAO catDAO;


@RequestMapping
public String metoda(){
    return "glowny";
}
}
