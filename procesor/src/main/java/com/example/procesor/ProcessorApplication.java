package com.example.procesor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.Transformer;

@SpringBootApplication
@EnableBinding(ProcessorTime.class)
public class ProcessorApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProcessorApplication.class, args);
	}

    @Transformer(inputChannel = ProcessorTime.IN_QUEUE, outputChannel = ProcessorTime.OUT_QUEUE)
    public String transform(String message) {
        LOG.info("Received and passing forward");
        return message.toUpperCase();
    }
}
