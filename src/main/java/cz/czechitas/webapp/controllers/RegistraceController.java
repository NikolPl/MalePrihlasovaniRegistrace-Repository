package cz.czechitas.webapp.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import cz.czechitas.webapp.*;
import cz.czechitas.webapp.Form.*;

@Controller
public class RegistraceController {

    UzivateleRepository uzivatele = new UzivateleRepository();

    @RequestMapping("/registrace")
    public ModelAndView zobrazRegistraci() {
        ModelAndView registrace = new ModelAndView("registrace");
        return registrace;
    }

    @RequestMapping(value = "/registrace", method = RequestMethod.POST)
    public ModelAndView vlozRegistraci(ClovekReg novyUzivatel) {
        Clovek novyClovek = new Clovek(novyUzivatel.getKrestniJmeno(),novyUzivatel.getPrijmeni(),novyUzivatel.getEmail(),
                novyUzivatel.getTelefon(),novyUzivatel.getHeslo(),novyUzivatel.getHeslo2());

        // registrace pouze, jestliže uvedený email ještě registrován není a zároveň obě hesla jsou shodná a ukáže se rovnou přihlášení
        boolean kontrola = uzivatele.vyhledejUzivatele(novyClovek.getEmail());
        if (kontrola == false && novyClovek.getHeslo().equals(novyClovek.getHeslo2())) {
            uzivatele.pridejCloveka(novyClovek);
            ModelAndView registrace = new ModelAndView("redirect:/prihlaseni");
            return registrace;
        }
        else {
            ModelAndView registrace = new ModelAndView("redirect:/registrace");
            return registrace;                                                              
        }
    }
}
