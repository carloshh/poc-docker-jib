package com.carloshh.example.jib.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class FakeServiceImplTest {

    @Test
    public void uncoveredLines() {
        var fakeServiceImpl = new FakeServiceImpl();

        fakeServiceImpl.uncoveredLines();
    }
}