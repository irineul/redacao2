package controllers;

import helpers.EmailHelper;
import helpers.GeneralHelper;

import java.math.BigInteger;
import java.security.MessageDigest;

import models.UserModel;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import play.libs.Mail;
import play.mvc.Controller;
import daos.UserDao;

public class User extends Controller {
	
	public static void signup(){
		render();
	}
	
    public static void insert() {
    	UserModel user = getUserFromRequest();
    	UserDao.getInstance().save(user);
    	EmailHelper.getInstance().sendEmail(user.getEmail(),"Bem-Vindo", "O Douglas é pica nao adianta");
    	signin();
    }
    
    public static void login() {
    	UserModel user = getUserFromRequest();
    	user = UserDao.getInstance().findUserByEmailAndPassword(user);
    	if (user != null) {
    		play.mvc.Scope.Session.current().put("userId",user.getId());
    		System.out.println("User: " +user.id);
    		Writing.index();
    	}else{
    		signin();
    	}
    }
    
    public static void logout() {
		play.mvc.Scope.Session.current().put("userId",null);
		signin();
    }

    public static void signin() {
        render();
    }
    
    public static void reset() {
        render();
    }

    private static UserModel getUserFromRequest() {
		UserModel user = new UserModel();
    	user.setEmail(params.get("email", String.class));
    	String password = params.get("password", String.class);
    	password = GeneralHelper.getInstance().toMD5(password);
    	user.setPassword(password);
    	return user;
	}
}