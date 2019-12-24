package ru.hh.kazan.models;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor

public class ResumeData {
  private String firstName;
  private String lastName;
  private String phone;
  private String cityName;
  private String dateOfBirth;
  private String monthOfBirth;
  private String yearOfBirth;
  private Boolean gender;
  private String skills;
  private String position;
}
