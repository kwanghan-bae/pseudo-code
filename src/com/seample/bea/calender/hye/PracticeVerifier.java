package com.seample.bea.calender.hye;


import com.sample.bae.calender.SecondPractice;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PracticeVerifier {
	
	public static void main (String[] args) {
		SecondPractice secondPractice = new SecondPracticeImpl();
		List<String> data = new ArrayList<>();
		data.add("케빈,2023-01-01,10:00:00,150000,김돌쇠,이레즈미");
		data.add("케빈,2023-01-01,13:00:00,100000,홍길동,이레즈미");
		data.add("케빈,2023-01-01,17:00:00,80000,진도준,이레즈미");
		data.add("켈리,2023-01-01,09:30:00,250000,김숙자,용문신");
		data.add("켈리,2023-01-01,13:00:00,50000,홍도범,발목문자");
		data.add("켈리,2023-01-01,15:30:00,40000,진양준,이레즈미");
		data.add("케빈,2023-01-02,08:00:00,500000,김돌쇠,도깨비");
		data.add("케빈,2023-01-02,13:00:00,150000,홍길동,이레즈미");
		data.add("케빈,2023-01-02,17:00:00,350000,진도준,덮어쓰기");
		data.add("켈리,2023-01-02,10:00:00,90000,김돌쇠,이레즈미");
		data.add("켈리,2023-01-02,13:00:00,240000,홍길동,해골");
		data.add("켈리,2023-01-02,17:00:00,100000,김돌쇠,눈썹문신");
		secondPractice.setData(data);
		
		try {
			verify(secondPractice);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//main-end

	
	public static void verify(SecondPractice practice) {
		boolean isPass=
			practice.artistOfMostDailyRevenue(LocalDate.of(2023, 01, 01)) == "켈리"
				&&practice.artistOfMostDailyRevenue(LocalDate.of(2023, 01, 02)) == "케빈"
				&&practice.mostPopularTypeOfDay(LocalDate.of(2023, 01, 01)) == "이레즈미"
				&&practice.mostPopularTypeOfDay(LocalDate.of(2023, 01, 02)) == "이레즈미"
				&&practice.artistOfMostTotalRevenue() == "케빈"
				&&practice.mostPopularType() == "이레즈미"
				&&practice.artistOfFirstWork(LocalDate.of(2023, 01, 01)) == "켈리"
				&&practice.artistOfFirstWork(LocalDate.of(2023, 01, 02)) == "케빈"
				&&practice.artistOfLastWork(LocalDate.of(2023, 01, 01)) == "케빈"
				&&practice.artistOfLastWork(LocalDate.of(2023, 01, 02)) == "케빈"
				&&practice.mostRegularCustomer() == "김돌쇠"
				&&practice.totalCostOfMostRegularCustomer() == 740000;
			
		if (!isPass) {
		      throw new RuntimeException("무엇인가 오류가 있어요!");
		    }
		    System.out.println("합격 입니다.\n수고하셨습니다.");
		  }
	}//verify_end