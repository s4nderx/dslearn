package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.dto.DeliverRevisionDTO;
import com.devsuperior.dslearnbds.entities.Deliver;
import com.devsuperior.dslearnbds.obervers.DeliverRevisionObserver;
import com.devsuperior.dslearnbds.repositories.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class DeliverService {

    @Autowired
    private DeliverRepository repository;

    private Set<DeliverRevisionObserver> deliverRevisionObservers = new LinkedHashSet<>();

    @Transactional
    public void saveRevision(Long id, DeliverRevisionDTO dto){
        Deliver deliver = repository.getOne(id);
        deliver.setStatus(dto.getStatus());
        deliver.setFeedback(dto.getFeedback());
        deliver.setCorrectCount(dto.getCorrectCount());
        repository.save(deliver);
        for (DeliverRevisionObserver observer: deliverRevisionObservers) {
            observer.onSaveRevision(deliver);
        }
    }

    public void subscribeDeliverRevisionObserver(DeliverRevisionObserver observer){
        deliverRevisionObservers.add(observer);
    }

}
