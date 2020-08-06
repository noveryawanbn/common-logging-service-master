package com.manulife.ap.client.notification.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * NotificationResponse
 */
@Validated

public class NotificationResponse   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("errorcode")
  private String errorcode = null;

  @JsonProperty("msgid")
  private String msgid = null;

  @JsonProperty("status")
  private String status = null;

  public NotificationResponse description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public NotificationResponse errorcode(String errorcode) {
    this.errorcode = errorcode;
    return this;
  }

  /**
   * Get errorcode
   * @return errorcode
  **/
  @ApiModelProperty(value = "")


  public String getErrorcode() {
    return errorcode;
  }

  public void setErrorcode(String errorcode) {
    this.errorcode = errorcode;
  }

  public NotificationResponse msgid(String msgid) {
    this.msgid = msgid;
    return this;
  }

  /**
   * Get msgid
   * @return msgid
  **/
  @ApiModelProperty(value = "")


  public String getMsgid() {
    return msgid;
  }

  public void setMsgid(String msgid) {
    this.msgid = msgid;
  }

  public NotificationResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationResponse notificationResponse = (NotificationResponse) o;
    return Objects.equals(this.description, notificationResponse.description) &&
        Objects.equals(this.errorcode, notificationResponse.errorcode) &&
        Objects.equals(this.msgid, notificationResponse.msgid) &&
        Objects.equals(this.status, notificationResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, errorcode, msgid, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationResponse {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    errorcode: ").append(toIndentedString(errorcode)).append("\n");
    sb.append("    msgid: ").append(toIndentedString(msgid)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

