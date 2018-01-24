package com.trackit.tracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "DEVICE_TYPE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"TYPE_NAME"})
})
public class AssetType extends BaseEntity {

  /**
  *
  */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "TYPE_ID")
  private long id;

  @Column(name = "TYPE_NAME")
  private String type;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
