package com.sample.bae.calender;

import java.time.LocalDate;
import java.util.List;

public interface SecondPractice {

  void setData(List<String> list);

  String artistOfMostDailyRevenue(LocalDate date);
  
  String mostPopularTypeOfDay(LocalDate date);

  String artistOfMostTotalRevenue();

  String mostPopularType();
  
  String artistOfFirstWork(LocalDate date);

  String artistOfLastWork(LocalDate date);
  
  String mostRegularCustomer();

  Long totalCostOfMostRegularCustomer();
}
