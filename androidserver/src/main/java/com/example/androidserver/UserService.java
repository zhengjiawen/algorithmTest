package com.example.androidserver;

import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.sf.json.JSONObject;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public boolean register(User user){
        logger.info("register"+"user:"+user);
        User currentUser = userRepository.findByUserName(user.getUserName());
        logger.info("register"+"currentUser:"+currentUser);
        if(currentUser != null){
            return false;
        }
        userRepository.save(user);
        return true;
    }

    public boolean login(User user){
        logger.info("login"+"user:"+user);

        User currentUser = userRepository.findByUserName(user.getUserName());
        logger.info("login"+"currentUser:"+currentUser);

        if(currentUser == null||!currentUser.getPassword().equals(user.getPassword())){
            return false;
        }
        return true;
    }

    public String getVideoListJson(String id){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for(int i = 1;i<5;i++){
            JSONObject video = new JSONObject();
            video.put("id","video"+i);
            video.put("url","http://www.modrails.com/videos/passenger_nginx.mov");
            jsonArray.add(video);
        }
        jsonObject.put("code",1);
        jsonObject.put("data",jsonArray);
        return jsonObject.toString();
    }

}
