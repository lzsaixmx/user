package cn.tedu.sp03.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.UserService;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/{userId}")
	public JsonResult<User> getUser(@PathVariable Integer userId) {
		User u = userService.getUser(userId);
		return JsonResult.ok(u);
	}
	
	//  http://localhost:8101/8/score?score=1000
	@GetMapping("/{userId}/score")
	public JsonResult<?> addScore(@PathVariable Integer userId, Integer score) {
		userService.addScore(userId, score);
		return JsonResult.ok();
	}
	
}






