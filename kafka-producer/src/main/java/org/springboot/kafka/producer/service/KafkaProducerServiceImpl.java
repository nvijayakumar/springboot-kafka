/**
 * 
 */
package org.springboot.kafka.producer.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author vijayakumar
 * @Since  11-Sep-2022
 *
 */
@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);
	
	private NewTopic topic;
	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducerServiceImpl(NewTopic topic, KafkaTemplate<String, String> kafkaTemplate) {
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public void sendMessage(String message) {
		LOGGER.info(String.format("kafka message => %s", message));
		
		Message<String> msg = MessageBuilder
				.withPayload(message)
				.setHeader(KafkaHeaders.TOPIC, topic.name())
				.setHeader(KafkaHeaders.MESSAGE_KEY, message)
				.build();
		
		kafkaTemplate.send(msg);
	}

}
