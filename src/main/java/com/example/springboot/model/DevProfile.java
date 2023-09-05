package com.example.springboot.model;

public class DevProfile implements ISystemProfile{
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
