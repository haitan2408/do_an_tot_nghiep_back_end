package com.goruslan.socialgeeking.service.impl;

import com.goruslan.socialgeeking.domain.DataRecommend;
import com.goruslan.socialgeeking.service.DataRecommendService;
import com.goruslan.socialgeeking.service.EmailService;
import com.goruslan.socialgeeking.service.RecommendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Arrays;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private RestTemplate restTemplate;

    @Qualifier("getJavaMailSender")
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private DataRecommendService dataRecommendService;

    @Autowired
    private RecommendService recommendService;

    @Override
    public void sendSimpleMessage(String to[]) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(to);
        message.setSubject("Demo");
        message.setText("Chào anh/chị,\n" +
                "Em hiện tại là Admin của trang www........ Trang web này có chức năng tư vấn cho người dùng nên học gì tiếp theo để đáp ứng nhu cầu tuyển dụng của các công ti IT. \n" +
                "Em mạo muội viết mail này nhờ anh chị có thể giúp em làm một chút khảo sát được không ạ?. Link em để ở bên dưới tin nhắn này. \n" +
                "Em cảm ơn anh/chị.\n" +
                "https://docs.google.com/forms/d/e/1FAIpQLSfHSpih_8An9a0p80uGwmphrfaM3IP4aVdm5DVCkaWN4SocmA/viewform?usp=sf_link\n" +
                "Thanks and Regards\n");
        emailSender.send(message);
    }

    @Override
    public void updateDataRecommend() throws IOException {
        final String uri = "https://sheet.best/api/sheets/a6dbc812-0cb5-49ec-a6a9-4e28e5b5c0ad";
        DataRecommend[] result = restTemplate.getForObject(uri, DataRecommend[].class);
        for (DataRecommend dataRecommend : result) {
            DataRecommend temp = dataRecommendService.findByEmailAddress(dataRecommend.getEmailAddress());
            if (temp != null) {
                dataRecommend.setId(temp.getId());
            }

        }
        dataRecommendService.save(Arrays.asList(result));
        recommendService.createNewFileDataRecommend();
    }
}
