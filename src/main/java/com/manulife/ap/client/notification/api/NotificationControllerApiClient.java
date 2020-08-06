package com.manulife.ap.client.notification.api;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name="${notificationService.name}", url="${notificationService.url}")
public interface NotificationControllerApiClient extends NotificationControllerApi {
}