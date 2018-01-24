package com.trackit.tracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DEVICE_DETAILS")
public class DeviceDetails extends BaseEntity {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "DEVICE_ID")
  private long id;

  @Column(name = "DEVICE_NAME")
  private String name;

  @ManyToOne(targetEntity = DeviceType.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "DEVICE_TYPE", referencedColumnName = "TYPE_ID")
  private DeviceType deviceType;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DeviceType getDeviceTypeId() {
    return deviceType;
  }

  public void setDeviceTypeId(DeviceType deviceTypeId) {
    this.deviceType = deviceTypeId;
  }

}
