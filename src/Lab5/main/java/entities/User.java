package com.spbstu.selenidePageObject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String login;
    String password;
    String name;
}
