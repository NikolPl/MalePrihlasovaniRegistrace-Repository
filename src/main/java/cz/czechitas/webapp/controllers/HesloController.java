package cz.czechitas.webapp.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import cz.czechitas.webapp.Form.*;

@Controller
public class HesloController {

    @RequestMapping("/zapomenute-heslo")
    public ModelAndView zobrazZapHeslo() {
        ModelAndView zapHeslo = new ModelAndView("zapomenute-heslo");
        return zapHeslo;
    }

    @RequestMapping (value = "/zapomenute-heslo", method = RequestMethod.POST)
    public ModelAndView zapHeslo(ClovekHeslo clovekHeslo) {
        ModelAndView zapHeslo = new ModelAndView("redirect:/prihlaseni");

        return zapHeslo;
    }
}
