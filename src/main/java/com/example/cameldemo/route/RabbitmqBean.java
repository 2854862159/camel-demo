package com.example.cameldemo.route;

import org.springframework.stereotype.Component;

/**
 * ClassName: RabbitmqBean <br/>
 * Description: <br/>
 * date: 2021/11/26 9:45 上午<br/>
 *
 * @author tooru<br />
 */
@Component
public class RabbitmqBean {

    public String invoke(String body){
        return String.format("rabbitmq bean body：%s", body);
    }

}
