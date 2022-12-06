package com.mslab.blog_service.model;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Blog {
    @Id
    @Column(name = "BLOG_ID")
    private String blogID;
    @Column(name = "USER_ID")
    private String userID;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "BODY")
    private String body;
}
