package com.sample.bae.student.hye;

public class GradeCard1 {

  public GradeCard1(
    String name,
    Double koreanScore,
    Double mathScore,
    Double englishScore) {
    this.name = name;
    this.koreanScore = koreanScore;
    this.mathScore = mathScore;
    this.englishScore = englishScore;
  }

  public String name;
  public Double koreanScore;
  public Double mathScore;
  public Double englishScore;

  public Double totalScore() {
    return koreanScore + mathScore + englishScore;
  }
}
