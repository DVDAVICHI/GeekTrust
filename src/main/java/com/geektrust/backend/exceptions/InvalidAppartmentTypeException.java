package com.geektrust.backend.exceptions;

public class InvalidAppartmentTypeException extends RuntimeException{
  
    public InvalidAppartmentTypeException(){
        super();
      }
    
      public InvalidAppartmentTypeException(String message){
         super(message);
      }
}