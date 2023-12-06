package tech.alexchen.daydayup.springboot.webflux.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author alexchen
 */
@RestController
public class HelloController {

    @RequestMapping("/mono")
    public Mono<String> mono() {
        return Mono.just("hello, mono");
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> flux() {
        return Flux.create(sink -> new Thread(() -> {
            String[] arr = {"1", "2", "3", "4", "5"};
            for (String s : arr) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                sink.next(s);
            }
            sink.complete();
        }).start());
    }

}
