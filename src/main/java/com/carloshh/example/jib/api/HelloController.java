package com.carloshh.example.jib.api;

import com.carloshh.example.jib.api.dto.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {
    private Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = "/hello")
    public Mono<ResponseMessage> hello() {
        LOG.info("hello request!");
        return Mono.just(new ResponseMessage("Hello world reactive!"));
    }

}
