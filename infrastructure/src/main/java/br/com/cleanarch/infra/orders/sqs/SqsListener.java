package br.com.cleanarch.infra.orders.sqs;

import br.com.cleanarch.application.orders.create.CreateOrderInput;
import br.com.cleanarch.application.orders.create.CreateOrderUseCase;
import br.com.cleanarch.domain.orders.OrderSource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.io.IOException;

@Service
public class SqsListener {

    private final static Logger log = LoggerFactory.getLogger(SqsListener.class);
    private ObjectMapper objectMapper;
    private CreateOrderUseCase createOrderUseCase;

    @Autowired
    public SqsListener(ObjectMapper objectMapper, CreateOrderUseCase createOrderUseCase) {
        this.objectMapper = objectMapper;
        this.createOrderUseCase = createOrderUseCase;
    }

    @JmsListener(destination = "producer-orders")
    public void receiveProductEvent(TextMessage textMessage) throws JMSException, IOException {
        log.info("Message received: {}", textMessage.getText());

        Double price = Double.valueOf(textMessage.getText());
        var output = createOrderUseCase.execute(new CreateOrderInput(price, OrderSource.SQS));

        log.info("Order create via SQS with id: {}", output.id());
    }
}
