package com.sample.bae.student;

import java.util.List;

public interface FirstPractice {

  void setData(List<String> list);

  Double totalScoreOfMember(String name);

  String highestTotalScoreMember();

  String lowestTotalScoreMember();

  Double averageOf(String subject);

  String highestScoreMember(String subject);

  String lowestScoreMember(String subject);

}
