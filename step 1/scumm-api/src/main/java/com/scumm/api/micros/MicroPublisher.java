package com.scumm.api.micros;

import com.clitellum.channels.configuration.ChannelConfiguration;
import com.clitellum.services.Identification;
import com.clitellum.services.Publisher;
import com.clitellum.services.PublisherBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class MicroPublisher {

    private static final Logger logger = LoggerFactory.getLogger(MicroPublisher.class);
    private static MicroPublisher instance;
    private Publisher publisher;

    public static synchronized MicroPublisher getInstance(){
        if (instance == null){
            instance = new MicroPublisher();
            try {
                instance.connect();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private MicroPublisher() {
        ChannelConfiguration configuration = new ChannelConfiguration();

        configuration.getExchange().setName("Scumm");
        String uri = System.getenv("SCUMM_AMQP_SERVER")!=null? System.getenv("SCUMM_AMQP_SERVER") : "amqp://micros_user:oJ3847PGtw3DCvbA1eeR2@localhost:5672";

        configuration.setUri(uri);

        publisher = PublisherBuilder.create()
                .setChannelSender(configuration)
                .setIdentification(Identification.create("ApiPublisher", "ApiPublisher"))
                .build();
    }

    public void connect() throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        publisher.connect();
    }

    public <TMessage>  void send(String key, TMessage message)
    {
        try {
            publisher.send(key, message);
        } catch (NoSuchAlgorithmException | KeyManagementException | URISyntaxException e) {
            logger.error("Error al enviar", e);
        }
    }

    public void close(){
        try {
            publisher.close();
        } catch (IOException | TimeoutException e) {
            logger.error("Error al cerrar", e);
        }
    }
}
