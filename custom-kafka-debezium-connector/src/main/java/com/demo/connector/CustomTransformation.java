package com.demo.connector;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.ConnectRecord;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.header.Headers;
import org.apache.kafka.connect.transforms.Transformation;

@Slf4j
public class CustomTransformation <R extends ConnectRecord<R>> implements Transformation<R> {

    public R apply(R sourceRecord) {
        log.info("==============In connector: {}");
        Struct kStruct = (Struct) sourceRecord.value();
        String databaseOperation = kStruct.getString("op");

        //Handle only the Create's
        if ("c".equalsIgnoreCase(databaseOperation)) {

            // Get the details.
            Struct after = (Struct) kStruct.get("after");
            log.info("===after===========In connector: {}",after);
            String UUID = after.getString("uuid");
            log.info("===UUID===========In connector: {}",UUID);
            String payload = after.getString("payload");
            log.info("===payload===========In connector: {}",payload);
            String eventType = after.getString("event_type").toLowerCase();
            log.info("===eventType===========In connector: {}",eventType);
            String topic = eventType.toLowerCase();
            log.info("===topic===========In connector: {}",topic);

            Headers headers = sourceRecord.headers();
            headers.addString("eventId", UUID);

            // Build the event to be published.
            sourceRecord = sourceRecord.newRecord(topic, null, Schema.STRING_SCHEMA, UUID,
                    null, payload, sourceRecord.timestamp(), headers);
        }

        log.info("===sourceRecord===========In connector: {}",sourceRecord);
        return sourceRecord;
    }

    public ConfigDef config() {
        return new ConfigDef();
    }

    public void close() {

    }

    public void configure(Map<String, ?> map) {

    }
}
