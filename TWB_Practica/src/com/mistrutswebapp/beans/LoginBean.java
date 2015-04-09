package com.mistrutswebapp.beans;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.validator.ValidatorForm;
import java.text.NumberFormat;
import java.io.Serializable;


public class LoginBean extends ValidatorForm implements Serializable
{
 private String userName;
 private String password;

 public LoginBean()
 {
  super();
 }

 public void setUserName(String userName)
 {
  this.userName = userName;
 }

 public void setPassword(String password)
 {
  this.password = password;
 }

 public String getUserName()
 {
  return userName;
 }

 public String getPassword()
 {
  return password;
 }

 public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
 {
  ActionErrors errors = new ActionErrors();
  if(userName == null || userName.length()<=0)
  {
	errors.add("userName", new ActionMessage("error.userName"));
  }
 
  if(password == null || password.length()<=0)
  {
	errors.add("password", new ActionMessage("error.password"));
  }
  mapping.getInputForward();
  return errors;
 }
}