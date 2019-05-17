package com.wcff.ciocolit.repository;

import com.wcff.ciocolit.domain.ChatMessage;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {

}
