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

    @OneToMany(mappedBy = "chat_group")
    private List<ChatMessage> messageList = new ArrayList<>();

    public ChatMessageGroup() {}
}
