package com.trackit.tracker.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trackit.tracker.domain.AssetDetails;
import com.trackit.tracker.domain.AssetType;
import com.trackit.tracker.domain.DeviceDetails;
import com.trackit.tracker.domain.DeviceType;
import com.trackit.tracker.domain.TrackingData;
import com.trackit.tracker.service.AssetDetailsService;
import com.trackit.tracker.service.AssetTypeService;
import com.trackit.tracker.service.DeviceDetailsService;
import com.trackit.tracker.service.DeviceTypeService;
import com.trackit.tracker.service.TrackingDataService;

@Component
public class DeviceTrackerHandler {

  @Autowired
  private TrackingDataService trackingDataService;

  @Autowired
  private DeviceDetailsService deviceDetailsService;

  @Autowired
  private AssetDetailsService assetDetailsService;

  @Autowired
  private DeviceTypeService deviceTypeService;

  @Autowired
  private AssetTypeService assetTypeService;

  public void recordLocation(List<TrackingData> locationData) {
    this.trackingDataService.saveAll(locationData);
  }

  public void registerDevice(DeviceDetails deviceDetails) {
    this.deviceDetailsService.saveOrUpdate(deviceDetails);
  }

  public void registerAsset(AssetDetails assetDetails) {
    this.assetDetailsService.save(assetDetails);
  }

  public List<DeviceType> getAllDeviceTypes() {
    return this.deviceTypeService.getAll();
  }

  public DeviceType getDeviceType(long id) {
    return this.deviceTypeService.getById(id);
  }

  public void addDeviceType(DeviceType deviceType) {
    this.deviceTypeService.saveOrUpdate(deviceType);
  }

  public void updateDeviceType(DeviceType deviceType) {
    this.deviceTypeService.update(deviceType);
  }

  public void deleteDeviceType(DeviceType deviceType) {
    this.deviceTypeService.delete(deviceType);
  }

  public void addAssetType(AssetType assetType) {
    this.assetTypeService.save(assetType);
  }

  public void deleteAssetType(AssetType assetType) {
    this.assetTypeService.delete(assetType);
  }

  public List<TrackingData> fetchLocationsOfDevice(long deviceId) {
    return this.trackingDataService.fetchLocationsByDeviceId(deviceId);
  }

  public List<TrackingData> fetchLocationsOfDeviceByName(String deviceName) {
    return this.trackingDataService.fetchLocationsByDeviceName(deviceName);
  }

  public List<TrackingData> fetchLocationsOfAsset(long assetId) {
    return this.trackingDataService.fetchLocationsByAssetId(assetId);
  }

  public List<TrackingData> fetchLocationsOfAssetByName(String name) {
    return this.trackingDataService.fetchLocationsByAssetName(name);
  }

}
