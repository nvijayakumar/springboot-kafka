/**
 * 
 */
package org.springboot.kafka.producer.service;

/**
 * @author vijayakumar
 * @Since  11-Sep-2022
 *
 */
public interface KafkaProducerService {
	
	void sendMessage(String message);

}
