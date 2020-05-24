package com.pzd.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(consumerGroup = "inform-group",topic = "inform")
public class InformConsumer implements RocketMQListener<String> {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void onMessage(String s) {
        System.out.println(s);
        String[] split = s.split(",");

        Double price = new Double(split[2]);
        if (price<1800.00){
            try {
                SimpleMailMessage msg = new SimpleMailMessage();
                msg.setFrom("3033570695@qq.com");
                msg.setTo("3033570695@qq.com");
                msg.setSubject("租房通知");
                msg.setSubject("【亲爱的会员，最新房源"+split[0]+",月租金为"+split[2]+",户型"+split[1]+"】");
                javaMailSender.send(msg);
                System.out.println("发送成功");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("发送失败");
            }
        }
    }
}
