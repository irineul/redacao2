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
	
	public static void channel(){
		render();
	}
	
    public static void insert() {
    	UserModel user = getUserFromRequest();
    	UserDao.getInstance().save(user);
    	EmailHelper.getInstance().sendEmail(user.getEmail(),"Bem-Vindo", "O Douglas é gay.");
    	signin();
    }
    
    public static void login() {
    	UserModel user = getUserFromRequest();
    	user = UserDao.getInstance().findUserByEmailAndPassword(user);
    	if (user != null) {
    		play.mvc.Scope.Session.current().put("userId",user.getId());
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
    
    public static void signInByFacebook(String id, String name, String email)
    {
    	/* Get User by facebook id */
    	UserModel user = UserDao.getInstance().findByIdFacebook(Long.parseLong(id));
    	
    	/* If user doesen't exists, I will insert him on our database and automatically login the user on system*/
    	if(user == null || user.id == 0)
    	{
    		user = new UserModel();
    		user.setEmail(email);
    		user.setName(name);
    		user.setIdFacebook(id);
    		UserDao.getInstance().save(user);
    		play.mvc.Scope.Session.current().put("userId",user.getId());
    		Writing.index();
    	}
    	else
    	{
    		play.mvc.Scope.Session.current().put("userId",user.getId());
    		Writing.index();
    	}
    }
}