package com.trackit.tracker.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.trackit.tracker.domain.AssetDetails;
import com.trackit.tracker.domain.AssetType;
import com.trackit.tracker.domain.DeviceDetails;
import com.trackit.tracker.domain.DeviceType;
import com.trackit.tracker.domain.TrackingData;
import com.trackit.tracker.exception.ExceptionFormatter;

@Controller
public class DeviceTrackerController {

  @Autowired
  private DeviceTrackerHandler deviceTrackerHandler;

  @RequestMapping(value="sendLocationData", method={RequestMethod.POST})
  public @ResponseBody void recordLocation(HttpServletRequest request, HttpServletResponse response,
      @RequestBody List<TrackingData> locationData) {
    this.deviceTrackerHandler.recordLocation(locationData);
  }

  @RequestMapping(value = "registerDevice", method = {RequestMethod.POST, RequestMethod.PUT})
  public @ResponseBody void registerDevice(HttpServletRequest request, HttpServletResponse response,
      @RequestBody DeviceDetails deviceDetails) {
    this.deviceTrackerHandler.registerDevice(deviceDetails);
  }

  @RequestMapping(value = "deviceType", method = {RequestMethod.POST, RequestMethod.PUT})
  @ResponseBody
  public void addDeviceType(HttpServletRequest request, HttpServletResponse response,
      @RequestBody DeviceType deviceType) {
    this.deviceTrackerHandler.addDeviceType(deviceType);
  }

  @RequestMapping(value = "deviceType", method = {RequestMethod.DELETE})
  public @ResponseBody void removeDeviceType(HttpServletRequest request,
      HttpServletResponse response,
      @RequestBody DeviceType deviceType) {
    this.deviceTrackerHandler.deleteDeviceType(deviceType);
  }

  @RequestMapping(value = "registerAsset", method = {RequestMethod.POST, RequestMethod.PUT})
  public @ResponseBody void registerAsset(HttpServletRequest request, HttpServletResponse response,
      @RequestBody AssetDetails assetDetails) {
    this.deviceTrackerHandler.registerAsset(assetDetails);
  }

  @RequestMapping(value = "assetType", method = {RequestMethod.POST, RequestMethod.PUT})
  public @ResponseBody void addAssetType(HttpServletRequest request, HttpServletResponse response,
      @RequestBody AssetType assetType) {
    this.deviceTrackerHandler.addAssetType(assetType);
  }

  @RequestMapping(value = "check", method = {RequestMethod.GET})
  public @ResponseBody String check(HttpServletRequest request, HttpServletResponse response) {
    return "Working!!";
  }

  @RequestMapping(value = "assetType", method = {RequestMethod.DELETE})
  public @ResponseBody void deleteAssetType(HttpServletRequest request,
      HttpServletResponse response,
      @RequestBody AssetType assetType) {
    this.deviceTrackerHandler.deleteAssetType(assetType);
  }

  @RequestMapping(value = "getLocations/device/id/{deviceId}", method = {RequestMethod.GET})
  public @ResponseBody List<TrackingData> fetchLocationsOfDevice(HttpServletRequest request,
      HttpServletResponse response, @PathVariable final long deviceId) {
    return this.deviceTrackerHandler.fetchLocationsOfDevice(deviceId);
  }

  @RequestMapping(value = "getLocations/device/name/{deviceName}", method = {RequestMethod.GET})
  public @ResponseBody List<TrackingData> fetchLocationsOfDeviceByName(HttpServletRequest request,
      HttpServletResponse response, @PathVariable final String deviceName) {
    return this.deviceTrackerHandler.fetchLocationsOfDeviceByName(deviceName);
  }

  @RequestMapping(value = "getLocations/asset/id/{assetId}", method = {RequestMethod.GET})
  public @ResponseBody List<TrackingData> fetchLocationsOfAsset(HttpServletRequest request,
      HttpServletResponse response, @PathVariable final long assetId) {
    return this.deviceTrackerHandler.fetchLocationsOfDevice(assetId);
  }

  @RequestMapping(value = "getLocations/asset/name/{assetName}", method = {RequestMethod.GET})
  public @ResponseBody List<TrackingData> fetchLocationsOfAssetByName(HttpServletRequest request,
      HttpServletResponse response, @PathVariable final String assetName) {
    return this.deviceTrackerHandler.fetchLocationsOfDeviceByName(assetName);
  }


  @ExceptionHandler
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ExceptionFormatter handleLocationDataValidation(
      MethodArgumentNotValidException exception) {
    return formatExceptionResponse("Request Body not valid. Please check", exception.getMessage());
  }


  private ExceptionFormatter formatExceptionResponse(String msg, String exceptionStr) {
    ExceptionFormatter errorVal = new ExceptionFormatter(msg);
    errorVal.addValidationException(exceptionStr);
    return errorVal;
  }
}
