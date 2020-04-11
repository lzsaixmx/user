package cn.tedu.sp03.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.UserService;
import cn.tedu.web.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UserServiceImpl implements UserService {
	@Value("${sp.user-service.users}")
	private String userJson;
	

	@Override
	public User getUser(Integer userId) {
		log.info("userJson = "+userJson);
		
		// userJson转成 List<User>
		List<User> list = JsonUtil.from(userJson, new TypeReference<List<User>>() {});
		for (User user : list) {
			if (user.getId().equals(userId)) {
				return user;
			}
		}
		
		return new User(userId, "name-"+userId, "pwd-"+userId);
	}

	@Override
	public void addScore(Integer userId, Integer score) {
		log.info("增加用户集分: userId = "+userId+", score = "+score);
	}

}




