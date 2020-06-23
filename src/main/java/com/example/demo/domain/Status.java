package com.example.demo.domain;

public enum Status {
    ACTIVE(0), INACTIVE(1);
    int value;

    Status(int value) {
        this.value = value;
    }

    public static Status getStatus(int value) {
        for (Status status : Status.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }
}
