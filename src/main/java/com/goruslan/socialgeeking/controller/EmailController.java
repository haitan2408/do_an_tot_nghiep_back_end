package com.goruslan.socialgeeking.controller;

import com.goruslan.socialgeeking.DTO.ListEmailDTO;
import com.goruslan.socialgeeking.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmailController {
    private final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailService emailService;

    @PostMapping("/email")
    public ResponseEntity<Void> emailSend(@RequestBody ListEmailDTO listEmailDTO) {
        try {
            emailService.sendSimpleMessage(listEmailDTO.getListEmail());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Lỗi không gửi được mail!");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("update-data")
    public ResponseEntity<Void> updateDataRecommend() throws GeneralSecurityException, IOException {
        emailService.updateDataRecommend();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
