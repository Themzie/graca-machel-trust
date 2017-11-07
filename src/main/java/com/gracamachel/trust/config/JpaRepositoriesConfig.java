package com.gracamachel.trust.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by thembelani on 11/3/17.
 */
@Configuration
@EnableJpaRepositories("com.gracamachel.trust.repository")
public class JpaRepositoriesConfig {
}
