package com.trackit.tracker.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.trackit.tracker.domain.TrackingData;

@Repository("trackingDataDao")
public class TrackingDataDAO extends BaseDAO<TrackingData> {

  private final String deviceId = "DEVICE_ID";
  private final String assetId = "ASSET_ID";

  @Autowired
  @Qualifier(value = "sessionFactory")
  private SessionFactory sessionFactory;

  public TrackingDataDAO() {
    super(TrackingData.class);
  }

  public List<TrackingData> fetchLocationsByDeviceId(long id) {
    return findByCriteria(Restrictions.eq(deviceId, id));
  }

  public List<TrackingData> fetchLocationsByAssetId(long id) {
    return findByCriteria(Restrictions.eq(assetId, id));
  }

  @Override
  public SessionFactory getSessionFactory() {
    return this.sessionFactory;
  }
}
