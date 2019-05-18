package com.wcff.ciocolit.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ChatMessageGroup {

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

    @Column(name = "chat_name")
    private String chatName;

    @OneToMany(mappedBy = "chatMessageGroup", fetch = FetchType.EAGER)
    private List<ChatMessage> messageList = new ArrayList<>();

    public ChatMessageGroup() {}
}
