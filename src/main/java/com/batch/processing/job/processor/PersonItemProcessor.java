package com.batch.processing.job.processor;

import com.batch.processing.job.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

  public static final Logger logger = LoggerFactory.getLogger(PersonItemProcessor.class);

  @Override
  public Person process(Person person) throws Exception {
    //...
    logger.info("Processed record: " + person);
    return person;
  }
}