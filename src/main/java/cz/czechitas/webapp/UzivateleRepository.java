package cz.czechitas.webapp;

import java.util.*;
import java.util.concurrent.*;

public class UzivateleRepository {

    private List<Clovek> uzivatele = new CopyOnWriteArrayList<>();

    public UzivateleRepository ()
    {   uzivatele.add(new Clovek("Nikol", "Plav", "n.plav@gmail.com", "600", "12345", "12345"));
        uzivatele.add(new Clovek("TePic", "Nazdar", "aho@cas.cz", "600", "12345", "12345"));
    }

    //najde uživatele dle emailu a hesla
    public synchronized Clovek porovnejUzivatele (String email, String heslo)
    {
        for (Clovek osoba : uzivatele){
            if (osoba.getEmail().equals(email) && osoba.getHeslo().equals(heslo))
            {
                return osoba;
            }
        }
        return null;
    }

    // najde uživatele jen podle emailu
    public synchronized boolean vyhledejUzivatele (String email)
    {
        for (Clovek osoba : uzivatele) {
            if (osoba.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean overeni(Clovek osubka){
        if (osubka == null){
            return false;
        }
        else {
            return true;
        }
    }

    public synchronized void pridejCloveka (Clovek clovek)
    {
          uzivatele.add(clovek);
    }
}
