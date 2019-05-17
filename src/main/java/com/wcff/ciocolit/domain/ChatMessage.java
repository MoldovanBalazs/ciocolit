package com.wcff.ciocolit.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class ChatMessage {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Long id;

    @Column(name = "topic")
    private String topic;

    @Column(name = "type")
    private MessageType type;

    @Column(name = "content")
    private String content;

    @Column(name = "sender")
    private String sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="chat_message_group_id")
    private ChatMessageGroup chatMessageGroup;

    @Column(name = "timeStamp")
    private Long timeStamp;


    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}

