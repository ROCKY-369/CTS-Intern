package com.example.model;

public class Trainee {
  private int id;
  private String name;
  private String email;

  public int getId() {
    return id;
  }

  public Trainee(int id, String name, String email, String serviceLine) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.serviceLine = serviceLine;
  }

  @Override
  public String toString() {
    return (
      "Trainee [email=" +
      email +
      ", id=" +
      id +
      ", name=" +
      name +
      ", serviceLine=" +
      serviceLine +
      "]"
    );
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getServiceLine() {
    return serviceLine;
  }

  public void setServiceLine(String serviceLine) {
    this.serviceLine = serviceLine;
  }

  private String serviceLine;
}
