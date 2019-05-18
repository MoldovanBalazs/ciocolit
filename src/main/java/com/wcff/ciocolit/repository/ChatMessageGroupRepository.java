package com.wcff.ciocolit.repository;

import com.wcff.ciocolit.domain.ChatMessage;
import com.wcff.ciocolit.domain.ChatMessageGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatMessageGroupRepository extends CrudRepository<ChatMessageGroup, Long> {

    ChatMessageGroup findByChatName(String name);

}
