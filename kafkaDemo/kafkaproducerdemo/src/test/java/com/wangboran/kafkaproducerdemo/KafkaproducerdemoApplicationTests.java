package com.wangboran.kafkaproducerdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wangboran.kafkaproducerdemo.producer.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class KafkaproducerdemoApplicationTests {


	@Autowired
	private KafkaProducer kafkaProducer;

	@Test
	public void kafkaProducer() {
		try {
			this.kafkaProducer.send();
		} catch (JsonProcessingException e) {
			log.error(e.getClass().getName() + ":", e);
		}
	}

	@Test
	public void contextLoads() {

	}
}
