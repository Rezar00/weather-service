package com.wiseboy.weatherservice.util.weatherstack;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Location implements Serializable {

    private String name;
    private String country;
    private String region;
    private String lat;
    private String lon;
    private String timezone_id;
    private String localtime;
    private String localtime_epoch;
    private String utc_offset;
}
