package com.trackit.tracker.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseEntity implements Serializable {
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -5475700851996804467L;

  /** The created user id. */
  @Column(name = "created_by")
  private String createdUserID;

  /** The created timestamp. */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_date")
  private Date createdTimestamp;

  /** The last updated user id. */
  @Column(name = "updated_by")
  private String lastUpdatedUserID;

  /** The last updated timstamp. */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_date")
  private Date lastUpdatedTimestamp;

  /**
   * Instantiates a new base entity.
   */
  public BaseEntity() {

  }

  /**
   * Gets the created user id.
   *
   * @return the created user id
   */
  public String getCreatedUserID() {
    return createdUserID;
  }

  /**
   * Sets the created user id.
   *
   * @param createdUserID the new created user id
   */
  public void setCreatedUserID(String createdUserID) {
    this.createdUserID = createdUserID;
  }

  /**
   * Gets the created timestamp.
   *
   * @return the created timestamp
   */
  public Date getCreatedTimestamp() {
    return createdTimestamp;
  }

  /**
   * Sets the created timestamp.
   *
   * @param createdTimestamp the new created timestamp
   */
  public void setCreatedTimestamp(Date createdTimestamp) {
    this.createdTimestamp = createdTimestamp;
  }

  /**
   * Gets the last updated user id.
   *
   * @return the last updated user id
   */
  public String getLastUpdatedUserID() {
    return lastUpdatedUserID;
  }

  /**
   * Sets the last updated user id.
   *
   * @param lastUpdatedUserID the new last updated user id
   */
  public void setLastUpdatedUserID(String lastUpdatedUserID) {
    this.lastUpdatedUserID = lastUpdatedUserID;
  }

  /**
   * Gets the last updated timstamp.
   *
   * @return the last updated timstamp
   */
  public Date getLastUpdatedTimestamp() {
    return lastUpdatedTimestamp;
  }

  /**
   * Sets the last updated timstamp.
   *
   * @param lastUpdatedTimstamp the new last updated timstamp
   */
  public void setLastUpdatedTimestamp(Date lastUpdatedTimestamp) {
    this.lastUpdatedTimestamp = lastUpdatedTimestamp;
  }
}
