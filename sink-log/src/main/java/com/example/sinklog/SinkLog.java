package com.example.sinklog;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.messaging.SubscribableChannel;

public interface SinkLog {
    String INPUT = "modified-time";

    @Input(INPUT)
    SubscribableChannel receivedTime();
}
