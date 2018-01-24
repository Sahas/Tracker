package com.trackit.tracker.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.trackit.tracker.domain.AssetDetails;

@Repository("assetDetailsDao")
public class AssetDetailsDAO extends BaseDAO<AssetDetails> {

  private static final String ASSET_NAME = "ASSET_NAME";

  @Autowired
  @Qualifier(value = "sessionFactory")
  private SessionFactory sessionFactory;

  public AssetDetailsDAO() {
    super(AssetDetails.class);
  }

  @Override
  public SessionFactory getSessionFactory() {
    return this.sessionFactory;
  }

  public AssetDetails getAssetFromName(String name) {
    List<AssetDetails> assets = findByCriteria(Restrictions.eq(ASSET_NAME, name));
    if (assets != null) {
      return assets.get(0);
    }
    return null;
  }
}
