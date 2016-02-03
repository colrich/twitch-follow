package io.gridbug.twitch.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.gridbug.twitch.repositories.TwitchUserRepository;

@Configuration
@ComponentScan(basePackageClasses = {TwitchUserRepository.class, LocalJpaRepositoryConfig.class})
public class RepositoryConfig {
}

