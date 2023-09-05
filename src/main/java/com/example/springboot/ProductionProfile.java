package com.example.springboot;

public class ProductionProfile implements ISystemProfile{
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
