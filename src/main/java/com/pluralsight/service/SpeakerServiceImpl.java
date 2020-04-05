package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("speakerService")
@Profile("dev")
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerRepository repository; // SpeakerServiceImpl now injected, not hardcoded

    public SpeakerServiceImpl() {
        System.out.println("SpeakerServiceImpl no args constructor");
    }

    public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
        System.out.println("SpeakerServiceImpl repository constructor");
        repository = speakerRepository;
    }

    @PostConstruct // can be used for logging
    private void initialize() {
        System.out.println("We're called after the constructors");
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }

    public void setRepository(SpeakerRepository repository) {
        System.out.println("SpeakerServiceImpl setter");
        this.repository = repository;
    }
}
