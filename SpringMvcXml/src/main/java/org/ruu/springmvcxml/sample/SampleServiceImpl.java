package org.ruu.springmvcxml.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ToString
public class SampleServiceImpl implements SampleService{

    @Qualifier("normal")
    private final SampleDAO sampleDAO;
}
