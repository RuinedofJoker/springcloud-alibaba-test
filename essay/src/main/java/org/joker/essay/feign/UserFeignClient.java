package org.joker.essay.feign;

import org.joker.essay.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")
public interface UserFeignClient {
    @GetMapping("/user/{userId}")
    User getUserById(@PathVariable int userId);
}
