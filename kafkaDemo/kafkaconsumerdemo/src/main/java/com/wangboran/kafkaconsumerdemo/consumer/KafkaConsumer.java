package com.wangboran.kafkaconsumerdemo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
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

	/**
	 * 自动提交offset情况下
	 *
	 * @param record
	 */
//	@KafkaListener(topics = "${kafka.custom.topic}")
//	public void listen(ConsumerRecord<?, ?> record) {
//
//		Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//
//		count++;
//
//		if (kafkaMessage.isPresent()) {
//			Object message = kafkaMessage.get();
//			System.out.println("消费第" + count + "条数据:" + message);
//		}
//
//	}

	/**
	 * 不自动提交情况下
	 *
	 * @param record
	 */
	@KafkaListener(topics = "${kafka.custom.topic}")
	public void listen(ConsumerRecord<?, ?> record, Acknowledgment acknowledgment) {

		Optional<?> kafkaMessage = Optional.ofNullable(record.value());

		count++;

		if (kafkaMessage.isPresent()) {
			Object message = kafkaMessage.get();
			System.out.println("消费第" + count + "条数据:" + message);
		}
		acknowledgment.acknowledge();

	}

}