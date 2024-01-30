package com.demo.contacts.User.Validations;

import com.demo.contacts.Auth.Domain.Dto.ResponseDto;
import com.demo.contacts.User.Persistence.Entity.UserEntity;
import com.demo.contacts.Validation.Validation;

public class UserValidations extends Validation {

  public ResponseDto validate(UserEntity user){
      ResponseDto response = new ResponseDto();

      response.setCodeOfErrors(0);

      boolean isNameValid = Validation.isValidUsername(user.getName());
      boolean isEmailValid = Validation.isValidEmail(user.getEmail());
      boolean isPasswordValid = Validation.isValidPassword(user.getPassword());

      if (!isNameValid){
          response.setMessage("Validate username (should be alphanumeric with underscores, between 3 and 20 characters");
          response.setCodeOfErrors(response.getCodeOfErrors()+1);
          return response;
      }

      if (!isEmailValid){
          response.setMessage("Validate email not follow normal structure");
          response.setCodeOfErrors(response.getCodeOfErrors()+1);
          return response;
      }

      if (!isPasswordValid){
          response.setMessage("Validate password (should be at least 8 characters, including at least one digit and one special character");
          response.setCodeOfErrors(response.getCodeOfErrors()+1);
      }

      return response;
  }
}
