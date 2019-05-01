package cz.czechitas.webapp.controllers;

import java.util.*;
import java.util.concurrent.*;
import javax.swing.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import com.sun.org.apache.bcel.internal.generic.*;
import cz.czechitas.webapp.*;
import cz.czechitas.webapp.Form.*;

@Controller
public class HlavniController {

    UzivateleRepository uzivatele = new UzivateleRepository();

    @RequestMapping("/")
    public ModelAndView zobrazIndex() {
        ModelAndView index = new ModelAndView("index");
        return index;

    }

    @RequestMapping (value = "/welcome") 
    public ModelAndView ukazWelcome(){
        ModelAndView welcome = new ModelAndView("welcome");
        return welcome;
    }

    @RequestMapping ("/vsichni")
    public ModelAndView zobrazVsechny(){
        ModelAndView vsichni = new ModelAndView("vsichni");
        vsichni.addObject("seznamVsech",uzivatele);
        return vsichni;
    }
    




}
