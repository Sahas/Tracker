package com.trackit.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackit.tracker.dao.AssetDetailsDAO;
import com.trackit.tracker.domain.AssetDetails;

@Service("assetDetailsService")
@Transactional("transactionManager")
public class AssetDetailsService extends BaseDAOService<AssetDetails, AssetDetailsDAO> {

  @Autowired
  private AssetDetailsDAO assetDetailsDao;

  @Override
  protected AssetDetailsDAO getDao() {
    return this.assetDetailsDao;
  }


}
