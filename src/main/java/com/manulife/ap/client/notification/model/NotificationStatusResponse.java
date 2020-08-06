package com.manulife.ap.client.notification.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * NotificationStatusResponse
 */
@Validated

public class NotificationStatusResponse   {
  @JsonProperty("content")
  private String content = null;

  @JsonProperty("createTimestamp")
  private String createTimestamp = null;

  @JsonProperty("notificationId")
  private String notificationId = null;

  @JsonProperty("status")
  private String status = null;

  public NotificationStatusResponse content(String content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   * @return content
  **/
  @ApiModelProperty(value = "")


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public NotificationStatusResponse createTimestamp(String createTimestamp) {
    this.createTimestamp = createTimestamp;
    return this;
  }

  /**
   * Get createTimestamp
   * @return createTimestamp
  **/
  @ApiModelProperty(value = "")


  public String getCreateTimestamp() {
    return createTimestamp;
  }

  public void setCreateTimestamp(String createTimestamp) {
    this.createTimestamp = createTimestamp;
  }

  public NotificationStatusResponse notificationId(String notificationId) {
    this.notificationId = notificationId;
    return this;
  }

  /**
   * Get notificationId
   * @return notificationId
  **/
  @ApiModelProperty(value = "")


  public String getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(String notificationId) {
    this.notificationId = notificationId;
  }

  public NotificationStatusResponse status(String status) {
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
    NotificationStatusResponse notificationStatusResponse = (NotificationStatusResponse) o;
    return Objects.equals(this.content, notificationStatusResponse.content) &&
        Objects.equals(this.createTimestamp, notificationStatusResponse.createTimestamp) &&
        Objects.equals(this.notificationId, notificationStatusResponse.notificationId) &&
        Objects.equals(this.status, notificationStatusResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, createTimestamp, notificationId, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationStatusResponse {\n");
    
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    createTimestamp: ").append(toIndentedString(createTimestamp)).append("\n");
    sb.append("    notificationId: ").append(toIndentedString(notificationId)).append("\n");
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

