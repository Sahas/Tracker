package com.trackit.tracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackit.tracker.dao.AssetDetailsDAO;
import com.trackit.tracker.dao.DeviceDetailsDAO;
import com.trackit.tracker.dao.TrackingDataDAO;
import com.trackit.tracker.domain.AssetDetails;
import com.trackit.tracker.domain.DeviceDetails;
import com.trackit.tracker.domain.TrackingData;

@Service("trackingDataService")
@Transactional("transactionManager")
public class TrackingDataService extends BaseDAOService<TrackingData, TrackingDataDAO> {

  @Autowired
  private TrackingDataDAO trackingDataDao;

  @Autowired
  private DeviceDetailsDAO deviceDetailsDao;

  @Autowired
  private AssetDetailsDAO assetDetailsDao;


  @Override
  protected TrackingDataDAO getDao() {
    return this.trackingDataDao;
  }

  public List<TrackingData> fetchLocationsByDeviceId(long id) {
    return this.trackingDataDao.fetchLocationsByDeviceId(id);
  }

  public List<TrackingData> fetchLocationsByAssetId(long id) {
    return this.trackingDataDao.fetchLocationsByAssetId(id);
  }

  public List<TrackingData> fetchLocationsByDeviceName(String name) {
    DeviceDetails device = this.deviceDetailsDao.getDeviceFromName(name);
    if (device != null) {
      return this.trackingDataDao.fetchLocationsByDeviceId(device.getId());
    }
    return new ArrayList<>();
  }

  public List<TrackingData> fetchLocationsByAssetName(String name) {
    AssetDetails asset = this.assetDetailsDao.getAssetFromName(name);
    if (asset != null) {
      return this.trackingDataDao.fetchLocationsByAssetId(asset.getId());
    }
    return new ArrayList<>();
  }


}
