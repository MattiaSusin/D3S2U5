package mattiasusin.D2S2U5.services;

import mattiasusin.D2S2U5.entities.Autore;
import mattiasusin.D2S2U5.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {
    private List<Autore> autoreList = new ArrayList<>();

    // 1. TROVA TUTTI
    public List<Autore> findAll() {
        return this.autoreList;
    }

    // 2. TROVA CON ID
    public Autore findById(int autoreId) throws ClassNotFoundException {
        Autore found = null;
        for (Autore autore : this.autoreList) {
            if (autore.getId() == autoreId) found = autore;
        }
        if (found == null) throw new ClassNotFoundException();
        return found;

    }

    // 3. CREA
    public Autore saveAutore(Autore body) {
        Random rd = new Random();
        body.setId(rd.nextInt(1, 100));
        body.setEmail(rd.toString());
        body.setAvatar(rd.toString());
        body.setDataDiNascita(rd.nextInt());
        this.autoreList.add(body);
        return body;
    }

    // 4. TROVA CON ID E MODIFICA
    public Autore findByIdAndUpdate(int autoreId, Autore updateAutore) {
        Autore found = null;
        for (Autore autore : this.autoreList) {
            if (autore.getId() == autoreId) {
                found = autore;
                found.setNome(updateAutore.getNome());
                found.setCognome(updateAutore.getCognome());
                found.setEmail(updateAutore.getEmail());
                found.setDataDiNascita(updateAutore.getDataDiNascita());
                found.setAvatar(updateAutore.getAvatar());
            }
        }
        if (found == null) throw new NotFoundException(autoreId);
        return found;
    }

    // 5. DELETE
    public void findByIdAndDelete(int autoreId) {
        Autore found = null;
        for (Autore autore : this.autoreList) {
            if (autore.getId() == autoreId) found = autore;
        }
        if (found == null) throw new NotFoundException(autoreId);
        this.autoreList.remove(found);
    }
}