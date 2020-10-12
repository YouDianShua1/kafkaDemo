package com.wangboran.kafkaproducerdemo.task;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wangboran.kafkaproducerdemo.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 类描述
 *
 * @author WangBoran
 * @since 2020/10/12 17:05
 */
@EnableScheduling
@Component
public class ProducerTask {

	@Autowired
	KafkaProducer kafkaProducer;

	@Scheduled(cron = "0/5 * * * * ?")
	private void produce() {
		try {
			kafkaProducer.send();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}