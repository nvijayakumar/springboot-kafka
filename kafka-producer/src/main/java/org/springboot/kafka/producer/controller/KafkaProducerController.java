/**
 * 
 */
package org.springboot.kafka.producer.controller;

import org.springboot.kafka.producer.service.KafkaProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vijayakumar
 * @Since  11-Sep-2022
 *
 */
@RestController
@RequestMapping("/kafka/producer")
public class KafkaProducerController {

	private KafkaProducerService kafkaProducerService;

	public KafkaProducerController(KafkaProducerService kafkaProducerService) {
		this.kafkaProducerService = kafkaProducerService;
	}
	
	@GetMapping("/{message}")
	public String sendKafkaMessage(@PathVariable String message) {
		kafkaProducerService.sendMessage(message);
		return "message published successfully";
	}
}
