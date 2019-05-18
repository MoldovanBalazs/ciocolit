package com.wcff.ciocolit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

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

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "telephoneNumber")
    private String telephoneNumber;

    @Column(name = "position")
    private String position;

    @ManyToMany(mappedBy = "userList", fetch = FetchType.LAZY)
    private List<Task> taskList = new ArrayList<>();

    @Column(name = "photo")
    private Byte[] photo;

    public User() { }
}
