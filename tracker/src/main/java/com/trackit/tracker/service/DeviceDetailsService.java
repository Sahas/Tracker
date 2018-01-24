package com.trackit.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackit.tracker.dao.DeviceDetailsDAO;
import com.trackit.tracker.domain.DeviceDetails;

@Service("deviceDetailsService")
@Transactional("transactionManager")
public class DeviceDetailsService extends BaseDAOService<DeviceDetails, DeviceDetailsDAO> {

  @Autowired
  private DeviceDetailsDAO deviceDetailsDao;

  @Override
  protected DeviceDetailsDAO getDao() {
    return this.deviceDetailsDao;
  }

}
