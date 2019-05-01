package cz.czechitas.webapp.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import cz.czechitas.webapp.*;
import cz.czechitas.webapp.Form.*;

@Controller
public class PrihlaseniController {

    UzivateleRepository uzivatele = new UzivateleRepository();

    @RequestMapping(value = "/prihlaseni", method = RequestMethod.GET)
    public ModelAndView zobrazPrihlaseni(){
        ModelAndView ukazPrihlaseni = new ModelAndView("prihlaseni");
        ukazPrihlaseni.addObject("uzivatel","");
        ukazPrihlaseni.addObject("sdeleni","ahoj");
        return ukazPrihlaseni;
    }

    @RequestMapping(value = "/prihlaseni", method = RequestMethod.POST)
    public ModelAndView PrihlasSe(ClovekPrihlas prihlasenyClovek) {
        Clovek uzivatel = uzivatele.porovnejUzivatele(prihlasenyClovek.getEmail(),prihlasenyClovek.getHeslo());

        //úspěšné přihlášení
        if (uzivatele.overeni(uzivatel) == true) {
            ModelAndView prihlaseni = new ModelAndView("redirect:/welcome");
            return prihlaseni;
        }
        else {

            //vrátí zpět na přihlášení s vyplněným mailem, pokud zadá špatné heslo
            if (uzivatele.vyhledejUzivatele(prihlasenyClovek.getEmail()) == true)
            {
                ModelAndView prihlaseni = new ModelAndView("prihlaseni");
                prihlaseni.addObject("uzivatel",prihlasenyClovek.getEmail());
                return prihlaseni;
            }

            // pokud nenajde email přihlašovaného - hodí na registraci
            else {
                ModelAndView prihlaseni = new ModelAndView("redirect:/registrace");
                return prihlaseni;
            }
        }
    }
}
