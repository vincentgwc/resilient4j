package org.vg.resilient4j.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vg.resilient4j.service.DemoServiceImpl;

@RestController
@RequestMapping("/resilience")
public class DemoController {
    private final DemoServiceImpl demoService;

    public DemoController(DemoServiceImpl demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/cb")
    public String circuitBreaker() {
        return demoService.circuitBreaker();
    }

    @GetMapping("/bulkhead")
    public String bulkhead() {
        return demoService.bulkHead();
    }

    @GetMapping("/tl")
    public CompletableFuture<String> timeLimiter() {
        return demoService.timeLimiter();
    }

    @GetMapping("/rl")
    public String rateLimiter() {
        return demoService.rateLimiter();
    }

    @GetMapping("/retry")
    public String retry() {
        return demoService.retry();
    }
}
