package com.wangboran.kafkaconsumerdemo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * kafkaConsumer simple demo
 *
 * @author WangBoran
 * @since 2020/10/12 16:43
 */
@Component
public class KafkaConsumer {

	private static int count = 0;

	@KafkaListener(topics = "${kafka.custom.topic}")
	public void listen(ConsumerRecord<?, ?> record) {

		Optional<?> kafkaMessage = Optional.ofNullable(record.value());

		count++;

		if (kafkaMessage.isPresent()) {
			Object message = kafkaMessage.get();
			System.out.println("消费第" + count + "条数据:" + message);
		}

	}

}