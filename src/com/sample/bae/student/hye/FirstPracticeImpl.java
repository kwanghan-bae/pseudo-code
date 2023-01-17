package com.sample.bae.student.hye;

import java.util.ArrayList;
import java.util.List;


import com.sample.bae.student.FirstPractice;

public class FirstPracticeImpl implements FirstPractice {

	private List<GradeCard1> gradeCard1 = new ArrayList<>();

	@Override
	public void setData(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			String[] slice = list.get(i).split(",");

			String name = slice[0];

			Double koreanScore = Double.parseDouble(slice[1].split(":")[1]);
			Double mathScore = Double.parseDouble(slice[2].split(":")[1]);
			Double englishScore = Double.parseDouble(slice[3].split(":")[1]);

			gradeCard1.add(new GradeCard1(

					name, koreanScore, mathScore, englishScore));

		} // for-end

	}// setDAta-end

	@Override
	public Double totalScoreOfMember(String name) {
	    GradeCard1 studentCard = null;
	    for(int i=0; i<gradeCard1.size(); i++) {
	    if (gradeCard1.get(i).name.equals(name)) {
	    	
	        studentCard = gradeCard1.get(i);
	    }
	
	    }
	    
	    if(studentCard ==null) {
	    	throw new RuntimeException("잘못된 이름이다.");
	    }
		return studentCard.totalScore();

	}

	@Override
	public String highestTotalScoreMember() {

		GradeCard1 highestGradCard = null;

		for (int i = 0; i < gradeCard1.size(); i++) {
			GradeCard1 gradeCard = gradeCard1.get(i);
			if (highestGradCard == null) {
				highestGradCard = gradeCard;
			}
			if (highestGradCard.totalScore() < gradeCard.totalScore()) {
				highestGradCard = gradeCard;
			}
		}
		return highestGradCard.name;
	}

	@Override
	public String lowestTotalScoreMember() {
		GradeCard1 lowestScoreMember = null;

		for (int i = 0; i < gradeCard1.size(); i++) {
			GradeCard1 gradeCard = gradeCard1.get(i);
			if (lowestScoreMember == null) {
				lowestScoreMember = gradeCard;
			}
			if (lowestScoreMember.totalScore() > gradeCard.totalScore()) {
				lowestScoreMember = gradeCard;
			}
		}
		return lowestScoreMember.name;
	}

	@Override
	public Double averageOf(String subject) {

		int MembersInwon = gradeCard1.size();
		Double baseScore = 0d;
		switch (subject) {
		case "국어":
			for (int i = 0; i < gradeCard1.size(); i++) {
				GradeCard1 gradeCard = gradeCard1.get(i);
				baseScore += gradeCard.koreanScore;
			}
			break;
		case "수학":
			for (int i = 0; i < gradeCard1.size(); i++) {
				GradeCard1 gradeCard = gradeCard1.get(i);
				baseScore += gradeCard.mathScore;
			}
			break;

		case "영어":
			for (int i = 0; i < gradeCard1.size(); i++) {
				GradeCard1 gradeCard = gradeCard1.get(i);
				baseScore += gradeCard.englishScore;
			}
			break;
		default : 
			throw new RuntimeException("해당 과목은 없습니다.");
		}// switch-end

		return baseScore/MembersInwon;
	}

	@Override
	public String highestScoreMember(String subject) {
		
		GradeCard1 highestScoreSubject = null;
		for (int i = 0; i < gradeCard1.size(); i++) {
			GradeCard1 gradeCard = gradeCard1.get(i);
			if (highestScoreSubject == null) {
				highestScoreSubject = gradeCard;
			}
		switch (subject) {
		
		case "국어" :
			if(highestScoreSubject.koreanScore < gradeCard.koreanScore) {
				highestScoreSubject = gradeCard;
			}
		break;
		
		case "수학" :
			if(highestScoreSubject.mathScore < gradeCard.mathScore) {
				highestScoreSubject = gradeCard;
			}
			break;
		
		case "영어" :
			if(highestScoreSubject.englishScore < gradeCard.englishScore) {
				highestScoreSubject = gradeCard;
			}
			break;
		default : 
			throw new RuntimeException("highestScoreSubject에 예외가 있습니다.");
		}
		}//switch
		
		return highestScoreSubject.name;
	}

	@Override
	public String lowestScoreMember(String subject) {
		GradeCard1 lowestScoreSubject = null;
		for (int i = 0; i < gradeCard1.size(); i++) {
			GradeCard1 gradeCard = gradeCard1.get(i);
			if (lowestScoreSubject == null) {
				lowestScoreSubject = gradeCard;
			}
		switch (subject) {
		
		case "국어" :
			if(lowestScoreSubject.koreanScore > gradeCard.koreanScore) {
				lowestScoreSubject = gradeCard;
			}
		break;
		
		case "수학" :
			if(lowestScoreSubject.mathScore > gradeCard.mathScore) {
				lowestScoreSubject = gradeCard;
			}
			break;
		
		case "영어" :
			if(lowestScoreSubject.englishScore > gradeCard.englishScore) {
				lowestScoreSubject = gradeCard;
			}
			break;
		default : 
			throw new RuntimeException("lowestScoreSubject에 예외가 있습니다.");
		}
		}//switch
		
		return lowestScoreSubject.name;
	}

}
