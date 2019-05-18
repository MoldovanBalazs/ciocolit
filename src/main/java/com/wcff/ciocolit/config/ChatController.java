package com.wcff.ciocolit.config;

import com.wcff.ciocolit.domain.ChatMessage;
import com.wcff.ciocolit.domain.ChatMessageGroup;
import com.wcff.ciocolit.repository.ChatMessageGroupRepository;
import com.wcff.ciocolit.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@Controller
public class ChatController {

    @Autowired
    private ChatMessageGroupRepository chatMessageGroupRepository;

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage, @PathVariable String publi) {
        Long id = new Long(1L);
        ChatMessageGroup messageGroup = chatMessageGroupRepository.findById(id).get();
        System.out.println(messageGroup.getChatName());
        messageGroup.setMessageList(chatMessageRepository.findAllByChatMessageGroup(messageGroup));
        chatMessage.setChatMessageGroup(messageGroup);
        chatMessage.setTimeStamp(new Date().getTime());
        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/{topic}")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor,
                               @DestinationVariable String topic ) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
