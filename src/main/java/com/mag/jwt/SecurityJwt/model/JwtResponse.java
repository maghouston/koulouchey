package com.mag.jwt.SecurityJwt.model;

public class JwtResponse {
    private String token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private Long id;
    private String login;

    public JwtResponse() {}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtResponse(String token, Long id, String login) {
        this.token = token;
        this.id = id;
        this.login = login;
    }
}
