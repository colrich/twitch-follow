package io.gridbug.twitch.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import io.gridbug.twitch.domain.TwitchUser;

public interface TwitchUserRepository extends PagingAndSortingRepository<TwitchUser, String> {
}
