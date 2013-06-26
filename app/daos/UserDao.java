package daos;

import java.util.List;

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

	public boolean isAValidUser(UserModel user) {
		List<UserModel> result = UserModel.find("email = ? and password = ?", user.getEmail(),user.getPassword()).fetch();
		if (result != null && result.size() > 0) {
			return true;
		}
		return false;
	}
}
