package com.ticket_mvc.utils;

public enum Status {


    OPEN("Open"),IN_PROGRESS("In Progress"),UAT_TEST("UAT_Test"),COMPLETE("Completed");

    private  final String value;

   private Status(String value){
       this.value=value;
   }


}
