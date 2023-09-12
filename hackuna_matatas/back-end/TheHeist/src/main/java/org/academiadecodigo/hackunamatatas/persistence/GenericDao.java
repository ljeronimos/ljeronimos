package org.academiadecodigo.hackunamatatas.persistence;

import org.academiadecodigo.hackunamatatas.model.Worker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDao<T> {

    private Class<T> modelType;

    protected EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public GenericDao(Class<T> modelType) {
        this.modelType = modelType;
    }

    public T saveOrUpdate(T modelObject){
        return em.merge(modelObject);
    }


    public T find(Integer id){
        return em.find(modelType,id);
    }



}
