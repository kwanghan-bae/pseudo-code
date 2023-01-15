package com.sample.bae.student;

import com.sample.bae.student.kwang.FirstPracticeImplKwang;
import java.util.ArrayList;
import java.util.List;

public class PracticeVerifier {

  public static void main(String[] args) {
    FirstPractice firstPractice = new FirstPracticeImplKwang();
    List<String> data = new ArrayList<>();
    data.add("철수,국어:90,수학:5,영어:100");
    data.add("영수,국어:67,수학:55,영어:92");
    data.add("순희,국어:99,수학:42,영어:10");
    data.add("영철,국어:28,수학:33,영어:88");
    data.add("수인,국어:49,수학:100,영어:22");
    firstPractice.setData(data);
    try {
      verify(firstPractice);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static void verify(FirstPractice practice) {
    boolean isPass = practice.totalScoreOfMember("철수") == 195
      && practice.totalScoreOfMember("영수") == 214
      && practice.totalScoreOfMember("순희") == 151
      && practice.totalScoreOfMember("영철") == 149
      && practice.totalScoreOfMember("수인") == 171
      && practice.highestTotalScoreMember().equals("영수")
      && practice.lowestTotalScoreMember().equals("영철")
      && practice.averageOf("국어") == 66.6d
      && practice.averageOf("수학") == 47.0d
      && practice.averageOf("영어") == 62.4d
      && practice.highestScoreMember("국어").equals("순희")
      && practice.highestScoreMember("수학").equals("수인")
      && practice.highestScoreMember("영어").equals("철수")
      && practice.lowestScoreMember("국어").equals("영철")
      && practice.lowestScoreMember("수학").equals("철수")
      && practice.lowestScoreMember("영어").equals("순희");

    if (!isPass) {
      throw new RuntimeException("무엇인가 오류가 있어요!");
    }
    System.out.println("합격 입니다.\n수고하셨습니다.");
  }
}
