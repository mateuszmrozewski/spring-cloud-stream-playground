package com.example.demo;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SourceTime {
    String QUEUE = "generated-time";

    @Output(QUEUE)
    MessageChannel newTime();
}
