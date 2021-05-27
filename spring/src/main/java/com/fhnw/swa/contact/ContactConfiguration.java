package com.fhnw.swa.contact;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Spring Configuration class for the Contact List Application
 *
 * @author Siv Elin Ødegård
 */
@Configuration
class ContactConfiguration {

    /**
     * Initialize specific Service
     * @param contactRepository for the service.
     * @return initialized service.
     */
    @Bean
    ContactService contactService(ContactRepository contactRepository) {
        return new ContactServiceImpl(contactRepository);
    }

    /**
     * Initialize specific Repository
     * @param jdbcTemplate used for the Repository. But can be changed.
     * @return initialized repository.
     */
    @Bean
    @Profile({"default", "jdbc"})
    ContactRepository contactRepository(JdbcTemplate jdbcTemplate) {
        return new ContactRepositoryJdbc(jdbcTemplate);
    }
}
