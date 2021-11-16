package com.progmatic.homework.Homework2.models;

public enum ProfileType {
    admin(UserAuthority.read, UserAuthority.write,UserAuthority.delete, UserAuthority.add),
    moderator(UserAuthority.read, UserAuthority.write, UserAuthority.delete),
    user(UserAuthority.read, UserAuthority.write);

    public final UserAuthority[] AUTHORITIES;

    ProfileType(UserAuthority... authorities) {
        AUTHORITIES = authorities;
    }
}
