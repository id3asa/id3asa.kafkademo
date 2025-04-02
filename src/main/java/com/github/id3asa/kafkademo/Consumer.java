package main.java.com.github.id3asa.kafkademo;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@org.springframework.context.annotation.Configuration
public class Consumer {

    final KafkaProperties kafkaProperties;

    public Consumer(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }



    @Bean
    ConsumerFactory consumerFactory() {
        final JsonDeserializer jsonDeserializer = new JsonDeserializer();
        jsonDeserializer.addTrustedPackages("*");
        return new DefaultKafkaConsumerFactory (kafkaProperties.buildConsumerProperties(), new StringDeserializer(), jsonDeserializer);
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory concurrentKafkaListenerContainerFactory
                = new ConcurrentKafkaListenerContainerFactory();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory());

        return concurrentKafkaListenerContainerFactory;
    }

}
