package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Document(collection = "notification")
public class Notification implements Serializable {
    @Id
    private String id;
    private String message;
    private int priority;
    private boolean secret;

    @PersistenceConstructor
    public Notification(@JsonProperty("message") String message,
                        @JsonProperty("priority") int priority,
                        @JsonProperty("secret") boolean secret) {
        this.message = message;
        this.priority = priority;
        this.secret = secret;
    }
}