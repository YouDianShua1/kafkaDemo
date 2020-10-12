package com.wangboran.kafkaproducerdemo.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangboran.kafkaproducerdemo.bean.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 类描述
 *
 * @author WangBoran
 * @since 2020/10/12 9:26
 */
@Slf4j
@Component
public class KafkaProducer {

	@Autowired
	private KafkaTemplate kafkaTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	//发送消息方法
	public void send() throws JsonProcessingException {
		Message message = new Message();
		message.setId(System.currentTimeMillis()+"");
		message.setMessage(UUID.randomUUID().toString());
		message.setTime(LocalDateTime.now());

		String json = objectMapper.writeValueAsString(message);
		//topic-ideal为主题
		kafkaTemplate.send("topic-ideal", json);
	}


}