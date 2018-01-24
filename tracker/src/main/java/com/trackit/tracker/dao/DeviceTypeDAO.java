package com.trackit.tracker.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.trackit.tracker.domain.DeviceType;

@Repository("deviecTypeDao")
public class DeviceTypeDAO extends BaseDAO<DeviceType> {

  @Autowired
  @Qualifier(value = "sessionFactory")
  private SessionFactory sessionFactory;

  public DeviceTypeDAO() {
    super(DeviceType.class);
  }

  @Override
  public SessionFactory getSessionFactory() {
    return this.sessionFactory;
  }

  public String getDeviceTypeFromTypeId(long id) {
    return find(id).getType();
  }
}
