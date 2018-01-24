package com.trackit.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackit.tracker.dao.DeviceTypeDAO;
import com.trackit.tracker.domain.DeviceType;

@Transactional("transactionManager")
@Service("deviceTypeService")
public class DeviceTypeService extends BaseDAOService<DeviceType, DeviceTypeDAO> {

  @Autowired
  private DeviceTypeDAO deviceTypeDao;

  @Override
  protected DeviceTypeDAO getDao() {
    return this.deviceTypeDao;
  }

}
