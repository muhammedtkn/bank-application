package com.muhammed.bankapplication.sec.service;

public enum EnumJwtConstant {

    BEARER("Bearer ");

    private String text;

    EnumJwtConstant(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }

}
