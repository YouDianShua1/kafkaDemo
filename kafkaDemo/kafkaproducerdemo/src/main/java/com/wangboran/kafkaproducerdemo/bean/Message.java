package com.wangboran.kafkaproducerdemo.bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 类描述
 *
 * @author WangBoran
 * @since 2020/10/12 9:24
 */
@Data
public class Message {

	private String id;

	private String message;

	private LocalDateTime time;
}