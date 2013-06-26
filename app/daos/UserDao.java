package daos;

import models.UserModel;

public class UserDao {

	public static UserDao self;
	
	private UserDao(){}
	
	public static UserDao getInstance(){
		if (self == null) {
			self = new UserDao();
		}
		return self;
	}
	
	public UserModel save(UserModel user) {
		user.save();
		return user;
	}
}
