package org.example.service.consumer;

import java.util.List;
import java.util.Optional;

public interface ImplService<T> {
    List<T> findAll();

    Optional<T> findById(String id);
}
