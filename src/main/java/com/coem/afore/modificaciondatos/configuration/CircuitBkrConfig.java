package com.coem.afore.modificaciondatos.configuration;

import org.springframework.context.annotation.Bean;

import java.time.Duration;
import org.springframework.context.annotation.Configuration;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@Configuration
public class CircuitBkrConfig {
	
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> circuitBreakerFactoryCustomizer() {
		CircuitBreakerConfig cbConfig = CircuitBreakerConfig.custom()
				.slidingWindowSize(10) // numero de peticiones sobre las cuales se estimara el porcetaje de umbral
				.failureRateThreshold(50) // porcentaje de fallo del umbral para abrir el circuito
				.waitDurationInOpenState(Duration.ofSeconds(10L)) // tiempo de duracion del circuito abierto
				.permittedNumberOfCallsInHalfOpenState(6) // peticiones de prueba en circuito semi abierto si superan el
															// failureRateThreshold vuelve a abierto si no a cerrado
				.slowCallRateThreshold(10) // numero de llamadas al servicio que pueden ser lentas si se superan se abre
											// el circuito
				.slowCallDurationThreshold(Duration.ofSeconds(4L)) // tiempo en que se considera que una llamada es
																	// lenta
				.build();

		return resilience4JCircuitBreakerFactory -> resilience4JCircuitBreakerFactory.configureDefault(id -> {
			return new Resilience4JConfigBuilder(id).circuitBreakerConfig(cbConfig)
					.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(8L)).build())
					.build();
		});
	}
	
	

}
