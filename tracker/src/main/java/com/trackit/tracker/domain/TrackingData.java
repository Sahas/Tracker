package com.trackit.tracker.domain;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
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
@Table(name = "TRACKING_DATA")
public class TrackingData {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "TRACKING_ID")
  private long id;

  @Column(name = "LAT", nullable = false)
  private BigDecimal latitude;

  @Column(name = "LNG", nullable = false)
  private BigDecimal longitude;

  @Column(name = "SPEED")
  private float speed;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "DEVICE_ID")
  private DeviceDetails deviceId;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "ASSET_ID")
  private AssetDetails assetId;

  @Column(name = "TIMESTAMP")
  private ZonedDateTime timestamp;

  @Column(name = "METADATA")
  private String metadata;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }

  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  public float getSpeed() {
    return speed;
  }

  public void setSpeed(float speed) {
    this.speed = speed;
  }

  public DeviceDetails getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(DeviceDetails deviceId) {
    this.deviceId = deviceId;
  }

  public AssetDetails getAssetId() {
    return assetId;
  }

  public void setAssetId(AssetDetails assetId) {
    this.assetId = assetId;
  }

  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(ZonedDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public String getMetadata() {
    return metadata;
  }

  public void setMetadata(String metadata) {
    this.metadata = metadata;
  }
}
