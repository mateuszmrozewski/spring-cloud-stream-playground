package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableConfigurationProperties(SourceTimeProperties.class)
@EnableBinding(SourceTime.class)
public class SourceTimeApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SourceTimeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SourceTimeApplication.class, args);
    }

    @Autowired
    SourceTimeProperties props;

    @Bean
    @InboundChannelAdapter(SourceTime.QUEUE)
    public MessageSource<String> sourceTime() {

        return () -> {
            LOG.info("Producing time");
            return new GenericMessage<>(
                    new SimpleDateFormat(
                            props.getFormat(),
                            props.getLocaleFromString()).format(new Date()));

        };
    }
}