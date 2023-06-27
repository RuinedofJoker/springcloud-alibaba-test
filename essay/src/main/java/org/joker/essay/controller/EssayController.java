package org.joker.essay.controller;

import org.joker.essay.feign.UserFeignClient;
import org.joker.essay.pojo.EssayVo;
import org.joker.essay.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
@RequestMapping("/essay")
public class EssayController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/{essayId}")
    public EssayVo getEssayById(@PathVariable int essayId) {
        int userId = 1;
//        String url = "http://userservice/user/get/" + userId;
//        User user = restTemplate.getForObject(url, User.class);
        User user = userFeignClient.getUserById(userId);
        EssayVo result = new EssayVo();
        BeanUtils.copyProperties(user, result);
        result.setId(essayId);
        result.setContent("testContent");
        result.setUserId(user.getId());

        return result;
    }
}
