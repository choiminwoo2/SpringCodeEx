package org.ruu.springmvcxml.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("event")
public class EventSampleDAOImpl implements SampleDAO {

}
