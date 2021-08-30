package org.vg.resilient4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.core.registry.EntryAddedEvent;
import io.github.resilience4j.core.registry.EntryRemovedEvent;
import io.github.resilience4j.core.registry.EntryReplacedEvent;
import io.github.resilience4j.core.registry.RegistryEventConsumer;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.timelimiter.TimeLimiter;

@SpringBootApplication
public class Resilient4jApp {
	public static void main(String[] args) {
		SpringApplication.run(Resilient4jApp.class, args);
	}
	
    @Bean
    public RegistryEventConsumer<Retry> myRetryRegistryEventConsumer() {
        return new RegistryEventConsumer<Retry>() {
			@Override
			public void onEntryReplacedEvent(EntryReplacedEvent<Retry> entryReplacedEvent) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onEntryRemovedEvent(EntryRemovedEvent<Retry> entryRemoveEvent) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onEntryAddedEvent(EntryAddedEvent<Retry> entryAddedEvent) {
				entryAddedEvent.getAddedEntry().getEventPublisher()
                 .onEvent(event -> System.out.println(event.toString()));
			}
		};
    }
    
    @Bean
    public RegistryEventConsumer<CircuitBreaker> myCircuitBreakerRegistryEventConsumer() {
        return new RegistryEventConsumer<CircuitBreaker>() {

			@Override
			public void onEntryAddedEvent(EntryAddedEvent<CircuitBreaker> entryAddedEvent) {
				// TODO Auto-generated method stub
				entryAddedEvent.getAddedEntry().getEventPublisher()
            		.onEvent(event -> System.out.println(event.toString()));
			}

			@Override
			public void onEntryRemovedEvent(EntryRemovedEvent<CircuitBreaker> entryRemoveEvent) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onEntryReplacedEvent(EntryReplacedEvent<CircuitBreaker> entryReplacedEvent) {
				// TODO Auto-generated method stub
				
			}
        };
    }
    
    @Bean
    public RegistryEventConsumer<TimeLimiter> myTimeLimiterRegistryEventConsumer() {
        return new RegistryEventConsumer<TimeLimiter>() {

			@Override
			public void onEntryAddedEvent(EntryAddedEvent<TimeLimiter> entryAddedEvent) {
				// TODO Auto-generated method stub
				entryAddedEvent.getAddedEntry().getEventPublisher()
                	.onEvent(event -> System.out.println(event.toString()));
			}

			@Override
			public void onEntryRemovedEvent(EntryRemovedEvent<TimeLimiter> entryRemoveEvent) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onEntryReplacedEvent(EntryReplacedEvent<TimeLimiter> entryReplacedEvent) {
				// TODO Auto-generated method stub
				
			}
        };
    }
    
    @Bean
    public RegistryEventConsumer<Bulkhead> myBulkheadRegistryEventConsumer() {
    	return new RegistryEventConsumer<Bulkhead>() {
			@Override
			public void onEntryAddedEvent(EntryAddedEvent<Bulkhead> entryAddedEvent) {
				// TODO Auto-generated method stub
				entryAddedEvent.getAddedEntry().getEventPublisher()
                	.onEvent(event -> System.out.println(event.toString()));
			}

			@Override
			public void onEntryRemovedEvent(EntryRemovedEvent<Bulkhead> entryRemoveEvent) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onEntryReplacedEvent(EntryReplacedEvent<Bulkhead> entryReplacedEvent) {
				// TODO Auto-generated method stub
				
			}
    	};
    }
}
