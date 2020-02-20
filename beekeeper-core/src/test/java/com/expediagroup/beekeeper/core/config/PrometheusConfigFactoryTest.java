/**
 * Copyright (C) 2020 Expedia, Inc.
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
package com.expediagroup.beekeeper.core.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import io.micrometer.prometheus.PrometheusConfig;

public class PrometheusConfigFactoryTest {

  private static final String DEFAULT_PREFIX = "beekeeper";

  private PrometheusConfigFactory prometheusConfigFactory = new PrometheusConfigFactory();

  @Test
  public void typicalPrometheusConfig() {
    PrometheusConfig prometheusConfig = prometheusConfigFactory.newInstance();
    assertThat(prometheusConfig.prefix()).isEqualTo(DEFAULT_PREFIX);
  }

  @Test
  public void overriddenPrefix() {
    String prefix = "overridden";
    prometheusConfigFactory.setPrefix(prefix);
    PrometheusConfig prometheusConfig = prometheusConfigFactory.newInstance();
    assertThat(prometheusConfig.prefix()).isEqualTo(prefix);
  }
}