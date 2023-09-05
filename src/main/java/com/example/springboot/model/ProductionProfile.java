package com.example.springboot.model;

public class ProductionProfile implements ISystemProfile{
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
