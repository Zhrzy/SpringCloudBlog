package com.zy.blog.mse.listener;

import com.zy.blog.mse.util.SendMailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 邮件监听器【用于发送邮件】
 *
 * @author 小章鱼
 * @date 2021年10月6日10:09:30
 */
@Slf4j
@Component
public class MailListener {

    @Autowired
    private SendMailUtils sendMailUtils;

    @RabbitListener(queues = "mogu.email")
    public void sendMail(Map<String, String> map) {
        if (map != null) {
            sendMailUtils.sendEmail(
                    map.get("subject"),
                    map.get("receiver"),
                    map.get("text")
            );
        }
    }
}
