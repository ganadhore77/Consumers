package com.consumer;

import java.time.Instant;
import java.time.LocalTime;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.entity.UserEntity;

@Service
public class ConumerOne {

	@RabbitListener(queues = { "simple_msg_queue" })
	public String consume(Message msg) {
		LocalTime time = LocalTime.now();
		System.out.println("SIMPLE MSG RECEIVED TO ANOTHER RPROJECT CONSUMER :: "+ msg  );
		System.out.println("Time  :: "+time);
		return "SIMPLE MSG RECEIVED to Another Project "+msg.toString()+ " Time  :: "+time;
	}

	@RabbitListener(queues = { "json_msg_queue" })
	public String consumeJson(UserEntity msg) {
		LocalTime time = LocalTime.now();
		System.out.println("JSON MSG RECEIVED  :: " + msg);
		System.out.println("Time  :: "+time);
		return "JSON MSG RECEIVED  :: " + msg.toString()+ " Time  :: "+time;
	}
}
