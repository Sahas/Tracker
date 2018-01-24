package com.trackit.tracker.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.trackit.tracker.domain.DeviceDetails;

@Repository("deviceDetailsDao")
public class DeviceDetailsDAO extends BaseDAO<DeviceDetails> {

  private static final String DEVICE_NAME = "DEVICE_NAME";

  @Autowired
  @Qualifier(value = "sessionFactory")
  private SessionFactory sessionFactory;

  public DeviceDetailsDAO() {
    super(DeviceDetails.class);
  }

  @Override
  public SessionFactory getSessionFactory() {
    return this.sessionFactory;
  }

  public DeviceDetails getDeviceFromName(String name) {
    List<DeviceDetails> devices = findByCriteria(Restrictions.eq(DEVICE_NAME, name));
    if (devices != null) {
      return devices.get(0);
    }
    return null;
  }
}
