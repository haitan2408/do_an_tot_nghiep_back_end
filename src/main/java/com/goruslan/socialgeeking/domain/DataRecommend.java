package com.goruslan.socialgeeking.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class DataRecommend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String timestamp;
    private String emailAddress;
    private int java;
    private int html;
    private int css;
    private int sqlServer;
    private int mySql;
    private int javaScript;
    private int python;
    private int cplus;
    private int c;
    private int net;
    private int php;
    private int swift;
    private int rubyOnRails;
    private int typeScript;
    private int angular;
    private int go;
    private int shell;
    private int mongoDB;
    private int perl;
    private int groovy;
    private int crystal;
    private int kotlin;
    private int mathLab;
    private int assembly;

    @Override
    public String toString() {
        return "" + java +
                "," + html +
                "," + css +
                ", " + sqlServer +
                ", " + mySql +
                ", " + javaScript +
                ", " + python +
                ", " + cplus +
                ", " + c +
                "," + net +
                "," + php +
                "," + swift +
                "," + rubyOnRails +
                "," + typeScript +
                "," + angular +
                "," + go +
                "," + shell +
                "," + mongoDB +
                "," + perl +
                "," + groovy +
                "," + crystal +
                "," + kotlin +
                "," + mathLab +
                "," + assembly;
    }
}
