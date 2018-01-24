package com.trackit.tracker.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.trackit.tracker.domain.AssetType;

@Repository("assetTypeDao")
public class AssetTypeDAO extends BaseDAO<AssetType> {

  @Autowired
  @Qualifier(value = "sessionFactory")
  private SessionFactory sessionFactory;
  public AssetTypeDAO() {
    super(AssetType.class);
  }

  @Override
  public SessionFactory getSessionFactory() {
    return this.sessionFactory;
  }

  public String getAssetTypeFromTypeId(long id) {
    return find(id).getType();
  }
}
