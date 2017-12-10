package com.example.sinklog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableConfigurationProperties(SinkLogProperties.class)
@EnableBinding(SinkLog.class)
public class SinkLogApplication {

	private static final Logger log = LoggerFactory.getLogger(SinkLogApplication.class);

	@Autowired
	SinkLogProperties props;

	public static void main(String[] args) {
		SpringApplication.run(SinkLogApplication.class, args);
	}

	@StreamListener(SinkLog.INPUT)
	public void sinkLog(String message){
		log.info(props.getPrefix() + message + props.getPostfix());
	}
}