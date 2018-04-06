package org.academiadecodigo.hackathon.cravo.services;

import org.academiadecodigo.hackathon.cravo.model.AbstractModel;

import java.util.List;

public interface CRUDService<T extends AbstractModel> extends Service {

    List<T> list();

    T get(Integer id);

    T save(T modelObject);

    void delete(Integer id);

}
