package com.goruslan.socialgeeking.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface EmailService {
    void sendSimpleMessage(String[] to);

    void updateDataRecommend() throws GeneralSecurityException, IOException;
}
