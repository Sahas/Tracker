package com.trackit.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.trackit.tracker.dao.BaseDAO;

@Transactional("transactionManager")
@Qualifier(value = "transactionManager")
abstract class BaseDAOService<E, T extends BaseDAO<E>> {

  public void save(E entity) {
    getDao().saveEntity(entity);
  }

  public void saveOrUpdate(E entity) {
    getDao().saveOrUpdateEntity(entity);
  }

  public void update(E entity) {
    getDao().updateEntity(entity);
  }

  public void delete(E entity) {
    getDao().deleteEntity(entity);
  }

  public void saveAll(List<E> entityList) {
    for (E entity : entityList) {
      saveOrUpdate(entity);
    }
  }

  public List<E> getAll() {
    return getDao().getEntityList();
  }

  public E getById(long id) {
    return getDao().find(id);
  }

  public int deleteAll() {
    return getDao().deleteAll();
  }

  protected abstract T getDao();
}
