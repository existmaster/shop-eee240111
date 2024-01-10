package shop.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import shop.config.kafka.KafkaProcessor;
import shop.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='InventoryDecreased'"
    )
    public void wheneverInventoryDecreased_SendAlert(
        @Payload InventoryDecreased inventoryDecreased
    ) {
        InventoryDecreased event = inventoryDecreased;
        System.out.println(
            "\n\n##### listener SendAlert : " + inventoryDecreased + "\n\n"
        );

        // Sample Logic //
        Order.sendAlert(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
