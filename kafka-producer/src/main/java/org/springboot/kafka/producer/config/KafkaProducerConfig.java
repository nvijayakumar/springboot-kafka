/**
 * 
 */
package org.springboot.kafka.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author vijayakumar
 * @Since  11-Sep-2022
 *
 */
@Configuration
public class KafkaProducerConfig {

	@Value("${spring.kafka.topic.name}")
	private String kafkaTopic;
	
	//spring bean to create kafka topic if it is not created so that event can be published.
	@Bean
	public NewTopic newTopic() {
		return TopicBuilder
				.name(kafkaTopic)
				.build();
	}
}
