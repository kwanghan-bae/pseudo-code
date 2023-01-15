package com.sample.bae.student.kwang;

public class GradeCard {

  public GradeCard(
    String name,
    Long koreanScore,
    Long mathScore,
    Long englishScore) {
    this.name = name;
    this.koreanScore = koreanScore;
    this.mathScore = mathScore;
    this.englishScore = englishScore;
  }

  public String name;
  public Long koreanScore;
  public Long mathScore;
  public Long englishScore;

  public Long getTotalScore() {
    return koreanScore + mathScore + englishScore;
  }
}
