package com.example.cameldemo.route;

/**
 * ClassName: User <br/>
 * Description: <br/>
 * date: 2021/11/22 10:47 上午<br/>
 *
 * @author tooru<br />
 */
public class User {

    private Integer id;

    private String name;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}