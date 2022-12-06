package com.mslab.user_service.model;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Blog {

    private String blogID;
    private String userID;
    private String title;
    private String body;
}
