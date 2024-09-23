package com.netease.thanos.core.depositChain.bo;

import java.util.List;

@lombok.Data
public class Subject {
    private String address;
    private List<EventQuadruple> eventList;
}

// EventList.java

