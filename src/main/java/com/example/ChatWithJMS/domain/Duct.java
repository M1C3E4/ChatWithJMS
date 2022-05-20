package com.example.ChatWithJMS.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
@Builder
public class Duct {
    private final UUID ductId;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final List<People> ductPeople;
    private final String ductName;
    private final List<Information> msgList;
    private final List<File> fileList;
}
