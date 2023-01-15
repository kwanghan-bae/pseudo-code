package com.sample.bae.student.kwang;

import com.sample.bae.student.FirstPractice;
import java.util.ArrayList;
import java.util.List;

public class FirstPracticeImplKwang implements FirstPractice {

  // "철수,국어:90,수학:5,영어:100"
  // "영수,국어:67,수학:55,영어:92"
  // "순희,국어:99,수학:42,영어:10"
  // "영철,국어:28,수학:33,영어:88"
  // "수인,국어:49,수학:100,영어:22"
  private List<GradeCard> gradeCards = new ArrayList<>();

  @Override
  public void setData(List<String> list) {
    for (String line : list) {
      String[] tokens = line.split(",");
      String name = tokens[0];
      Long koreanScore = Long.parseLong(tokens[1].split(":")[1]);
      Long mathScore = Long.parseLong(tokens[2].split(":")[1]);
      Long englishScore = Long.parseLong(tokens[3].split(":")[1]);
      gradeCards.add(
        new GradeCard(
          name,
          koreanScore,
          mathScore,
          englishScore
        )
      );
    }
  }

  @Override
  public Long totalScoreOfMember(String name) {
//    return gradeCards.stream()
//      .filter(gradeCard -> gradeCard.name.equals(name))
//      .map(GradeCard::getTotalScore)
//      .findFirst()
//      .orElseThrow(RuntimeException::new);

    GradeCard targetCard = null;
    for (GradeCard gradeCard : gradeCards) {
      if (gradeCard.name.equals(name)) {
        targetCard = gradeCard;
      }
    }
    if (targetCard == null) {
      throw new RuntimeException("잘못된 이름입니다.");
    }

    return targetCard.getTotalScore();
  }

  @Override
  public String highestTotalScoreMember() {
    GradeCard highestGradCard = null;

    for (GradeCard gradeCard : gradeCards) {
      if (highestGradCard == null) {
        highestGradCard = gradeCard;
      }
      if (highestGradCard.getTotalScore() < gradeCard.getTotalScore()) {
        highestGradCard = gradeCard;
      }
    }
    return highestGradCard.name;
  }

  @Override
  public String lowestTotalScoreMember() {

    GradeCard lowestGradCard = null;

    for (GradeCard gradeCard : gradeCards) {
      if (lowestGradCard == null) {
        lowestGradCard = gradeCard;
      }
      if (lowestGradCard.getTotalScore() > gradeCard.getTotalScore()) {
        lowestGradCard = gradeCard;
      }
    }
    return lowestGradCard.name;
  }

  @Override
  public Double averageOf(String subject) {
    int sizeOfMembers = gradeCards.size();
    Long baseScore = 0L;
    switch (subject) {
      case "국어":
        for (GradeCard gradeCard : gradeCards) {
          baseScore += gradeCard.koreanScore;
        }
        break;
      case "수학":
        for (GradeCard gradeCard : gradeCards) {
          baseScore += gradeCard.mathScore;
        }
        break;
      case "영어":
        for (GradeCard gradeCard : gradeCards) {
          baseScore += gradeCard.englishScore;
        }
        break;
      default:
        throw new RuntimeException("잘못된 입력값 입니다.");
    }

    return baseScore.doubleValue() / sizeOfMembers;
  }

  @Override
  public String highestScoreMember(String subject) {
    GradeCard highScoreOfSubject = null;
    for (GradeCard gradeCard : gradeCards) {
      if (highScoreOfSubject == null) {
        highScoreOfSubject = gradeCard;
      }
      switch (subject) {
        case "국어":
          if (highScoreOfSubject.koreanScore < gradeCard.koreanScore) {
            highScoreOfSubject = gradeCard;
          }
          break;
        case "수학":
          if (highScoreOfSubject.mathScore < gradeCard.mathScore) {
            highScoreOfSubject = gradeCard;
          }
          break;
        case "영어":
          if (highScoreOfSubject.englishScore < gradeCard.englishScore) {
            highScoreOfSubject = gradeCard;
          }
          break;
        default:
          throw new RuntimeException("잘못된 입력값 입니다.");
      }
    }
    return highScoreOfSubject.name;
  }

  @Override
  public String lowestScoreMember(String subject) {
    GradeCard lowScoreOfSubject = null;
    for (GradeCard gradeCard : gradeCards) {
      if (lowScoreOfSubject == null) {
        lowScoreOfSubject = gradeCard;
      }
      switch (subject) {
        case "국어":
          if (lowScoreOfSubject.koreanScore > gradeCard.koreanScore) {
            lowScoreOfSubject = gradeCard;
          }
          break;
        case "수학":
          if (lowScoreOfSubject.mathScore > gradeCard.mathScore) {
            lowScoreOfSubject = gradeCard;
          }
          break;
        case "영어":
          if (lowScoreOfSubject.englishScore > gradeCard.englishScore) {
            lowScoreOfSubject = gradeCard;
          }
          break;
        default:
          throw new RuntimeException("잘못된 입력값 입니다.");
      }
    }
    return lowScoreOfSubject.name;
  }
}
