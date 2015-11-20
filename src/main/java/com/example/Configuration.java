package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@org.springframework.context.annotation.Configuration
@EnableWebMvc
public class Configuration extends WebMvcConfigurerAdapter{
	
//	final static String queueName = "file-processing";
//
//	@Autowired
//	RabbitTemplate rabbitTemplate;
//
//	@Bean
//	Queue queue() {
//		return new Queue(queueName, false);
//	}
//
//	@Bean
//	TopicExchange exchange() {
//		return new TopicExchange("file-processing-exchange");
//	}
//
//	@Bean
//	Binding binding(Queue queue, TopicExchange exchange) {
//		return BindingBuilder.bind(queue).to(exchange).with(queueName);
//	}
//
//	@Bean
//	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(queueName);
//		container.setMessageListener(listenerAdapter);
//		return container;
//	}
	
	@Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/static/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}


//    @Bean
//    FileStatusReceiver receiver() {
//        return new FileStatusReceiver();
//    }
//
//	@Bean
//	MessageListenerAdapter listenerAdapter(FileStatusReceiver receiver) {
//		MessageListenerAdapter messageListenerAdapter =  new MessageListenerAdapter(receiver);
//		return messageListenerAdapter;
//	}

}
