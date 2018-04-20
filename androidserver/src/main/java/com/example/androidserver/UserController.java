package com.example.androidserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpServletRequest request, HttpSession session){
        boolean result = userService.login(user);
        if(result){
            session.setAttribute("userId",user.getUserName());
            return new ResponseEntity<String>("successful", HttpStatus.OK);
        }
        return new ResponseEntity<String>("error", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user,HttpServletRequest request, HttpSession session){
        boolean result = userService.register(user);
        if(result){
            session.setAttribute("userId",user.getUserName());
            return new ResponseEntity<String>("successful", HttpStatus.OK);
        }
        return new ResponseEntity<String>("error", HttpStatus.OK);
    }

    @PostMapping("/videoList")
    public ResponseEntity<String> getVideoList(HttpServletRequest request, HttpSession session){
        String id = (String)session.getAttribute("userId");
        if(id == null || id.isEmpty()){
            return new ResponseEntity<String>("请重新登陆", HttpStatus.OK);

        }
        String json = userService.getVideoListJson(id);
        return new ResponseEntity<String>(json, HttpStatus.OK);

    }

}
