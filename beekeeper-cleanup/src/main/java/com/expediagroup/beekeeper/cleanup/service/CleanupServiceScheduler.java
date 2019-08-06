/**
 * Copyright (C) 2019 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.beekeeper.cleanup.service;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CleanupServiceScheduler {

  private static final Logger log = LoggerFactory.getLogger(CleanupServiceScheduler.class);

  private final CleanupService cleanupService;

  @Autowired
  public CleanupServiceScheduler(CleanupService cleanupService) {
    this.cleanupService = cleanupService;
  }

  @Scheduled(fixedDelayString = "${properties.scheduler-delay-ms}")
  public void scheduleCleanupWithFixedDelay() {
    Instant now = Instant.now();
    log.info("Started cleanup for instant {}", now.toString());
    cleanupService.cleanUp(now);
    log.info("Finished cleanup for instant {}", now.toString());
  }
}
