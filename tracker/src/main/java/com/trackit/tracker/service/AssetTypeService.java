package com.trackit.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackit.tracker.dao.AssetTypeDAO;
import com.trackit.tracker.domain.AssetType;

@Service("assetTypeService")
@Transactional("transactionManager")
public class AssetTypeService extends BaseDAOService<AssetType, AssetTypeDAO> {

  @Autowired
  private AssetTypeDAO assetTypeDao;

  @Override
  protected AssetTypeDAO getDao() {
    return this.assetTypeDao;
  }

}
