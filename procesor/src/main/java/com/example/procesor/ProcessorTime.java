package com.example.procesor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ProcessorTime {
    String IN_QUEUE = "generated-time";

    String OUT_QUEUE = "modified-time";

    @Output(OUT_QUEUE)
    MessageChannel modifiedTime();

    @Input(IN_QUEUE)
    SubscribableChannel receivedTime();
}
