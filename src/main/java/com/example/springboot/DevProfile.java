package com.example.springboot;

public class DevProfile implements ISystemProfile{
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
