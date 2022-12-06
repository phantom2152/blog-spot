package com.mslab.user_service.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class User {
    @Id
    @Column(name = "ID")
    private String userID;
    @Column(name= "USERNAME",length = 25)
    private String username;
    @Column(name= "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;

    @Transient
    private List<Blog> blogs = new ArrayList<>();
}
