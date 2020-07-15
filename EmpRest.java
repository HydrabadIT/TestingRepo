package com.nt.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.nt.model.Employe;

@Path("/emp")
public class EmpRestController {
 @POST
 @Consumes("application/json")
 public String showData(Employe e) {
	 return e.toString();
 }
}
