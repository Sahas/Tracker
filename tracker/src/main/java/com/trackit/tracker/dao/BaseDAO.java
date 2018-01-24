package com.trackit.tracker.dao;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseDAO<T> {

  private Class<T> entityClass;

  public BaseDAO(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  public abstract SessionFactory getSessionFactory();

  public Class<T> getEntityClass() {
    return this.entityClass;
  }

  public void saveEntity(T entity) {
    this.getCurrentSession().save(entity);
  }

  public Session getCurrentSession() {
    return getSessionFactory().getCurrentSession();
  }

  public List<T> getAll() {
    return list(getCurrentSession().createQuery("from " + getEntityClass().getName()));
  }

  @SuppressWarnings("unchecked")
  public List<T> list(Query queryObj) {
    return queryObj.list();
  }

  /**
   * Update entity.
   *
   * @param entity the entity
   */
  public void updateEntity(T entity) {
    getCurrentSession().update(entity);
  }

  /**
   * Merge entity
   *
   * @param entity
   */
  public void mergeEntity(T entity) {
    getCurrentSession().merge(entity);
  }

  /**
   * Delete entity.
   *
   * @param entity the entity
   */
  public void deleteEntity(T entity) {
    getCurrentSession().delete(entity);
  }

  /**
   * Save or update entity.
   *
   * @param entity the entity
   */
  public void saveOrUpdateEntity(T entity) {
    getCurrentSession().saveOrUpdate(entity);
  }
  /**
   * Gets the blob from bytes.
   *
   * @param contentBytes the content bytes
   * @return the blob from bytes
   */
  public Blob getBlobFromBytes(byte[] contentBytes) {
    return Hibernate.getLobCreator(getCurrentSession()).createBlob(contentBytes);
  }
  /**
   * Find all.
   *
   * @return the list
   */
  public List<T> findAll() {
    return list(getCurrentSession().createQuery("from " + getEntityClass().getName()));
  }

  /**
   * Deletes all rows.
   *
   * @return Number of rows affected
   */
  public int deleteAll() {
    return getCurrentSession().createQuery("delete from " + getEntityClass().getName())
        .executeUpdate();
  }

  /**
   * Find.
   *
   * @param id the id
   * @return the t
   */
  @SuppressWarnings("unchecked")
  public T find(long id) {
    return (T)getCurrentSession().get(getEntityClass(), id);
  }

  /**
   * Find by criteria.
   *
   * @param criterion the criterion
   * @return the list
   */
  public List<T> findByCriteria(Criterion criterion) {
    Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
    criteria.add(criterion);
    return list(criteria);
  }

  /**
   * Find by criteria.
   *
   * @param criterion the criterion
   * @return the list
   */
  public List<T> findByCriteria(Criterion... criterions) {
    Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
    for (Criterion criterion : criterions) {
      criteria.add(criterion);
    }
    return list(criteria);
  }

  /**
   * Gets the entity list.
   *
   * @return the entity list
   */
  public List<T> getEntityList() {
    return list(getCurrentSession().createCriteria(getEntityClass()));
  }

  /**
   * Bulk update.
   *
   * @param queryString the query string
   * @param namedParam the namedParam
   * @param value the value
   * @return the int
   */
  public int bulkUpdate(String queryString, String namedParam, Object value) {
    Query queryObj = createHQLWithParams(queryString, namedParam, value);
    return Integer.valueOf(queryObj.executeUpdate());
  }

  /**
   * Bulk update.
   *
   * @param querystr the querystr
   * @param namedParams the namedParams map
   * @return the int
   */
  public int bulkUpdate(String querystr, Map<String, Object> namedParams) {
    Query queryObj = createHQLWithParams(querystr, namedParams);
    return Integer.valueOf(queryObj.executeUpdate());
  }

  /**
   * Find.
   *
   * @param querystr the querystr
   * @param namedParams the namedParams map
   * @return the list
   */
  public List<T> find(String querystr, Map<String, Object> namedParams) {
    Query queryObj = createHQLWithParams(querystr, namedParams);
    return list(queryObj);
  }

  /**
   * Find.
   *
   * @param queryString the query string
   * @return the list
   */
  public List<T> find(String queryString) {
    return find(queryString, null);
  }

  /**
   * Find.
   *
   * @param queryString the query string
   * @param namedParameter the named param
   * @param value the value
   * @return the list
   */
  public List<T> find(String queryString, String namedParameter, Object val) {
    Query queryObj = createHQLWithParams(queryString, namedParameter, val);
    return list(queryObj);
  }

  @SuppressWarnings("unchecked")
  public List<T> list(Criteria criteria) {
    return criteria.list();
  }

  public <U> U firstOrNull(List<U> list) {
    return list.size() > 0 ? list.get(0) : null;
  }

  public int deleteByQuery(String querystr, String namedParam, Object value) {
    Query queryObj = createHQLWithParams(querystr, namedParam, value);
    return queryObj.executeUpdate();
  }

  public int deleteByQuery(String querystr, Map<String, Object> namedParams) {
    Query queryObj = createHQLWithParams(querystr, namedParams);
    return queryObj.executeUpdate();
  }

  /**
   * Creates the hql with params.
   *
   * @param querystr the querystr
   * @param vals the vals
   * @return the query
   */
  private Query createHQLWithParams(String querystr, Map<String, Object> namedParams) {
    Query queryObj = getCurrentSession().createQuery(querystr);
    if (namedParams != null) {
      for (Map.Entry<String, Object> entry : namedParams.entrySet()) {
        queryObj.setParameter(entry.getKey(), entry.getValue());
      }
    }
    return queryObj;
  }

  private Query createHQLWithParams(String querystr, String namedParam, Object val) {
    Query queryObj = getCurrentSession().createQuery(querystr);
    if (StringUtils.isNotBlank(namedParam)) {
      queryObj.setParameter(namedParam, val);
    }
    return queryObj;
  }
}
