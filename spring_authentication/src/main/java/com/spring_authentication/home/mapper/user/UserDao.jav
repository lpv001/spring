package com.spring_authentication.home.mapper.user;

@Repository
public interface UserDao {
    public List<User> selectUser(Map<String,Object> params);
	public User selectUserFirst(Map<String,Object> params);
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	
	public User findUserById(int id);
	public User findUserByUserId(String userId);
	
	public int selectUserCount(Map<String, Object> params);

	public void updateUserPassword(User user);
}