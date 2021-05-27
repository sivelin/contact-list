package com.fhnw.swa.contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Jdbc Repository implementation of ContactRepository
 *
 * @author Siv Elin Ødegård
 */
class ContactRepositoryJdbc implements ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContactRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Contact> listAll() {
        return jdbcTemplate.query(
                "SELECT id, firstname, lastname, nickname, street, number, email, town, plz FROM contacts",
                (rs, rowNum) -> contactFromResultSet(rs));
    }

    @Override
    public Optional<Contact> findByFirstname(String firstname) {
        Collection<Contact> results = jdbcTemplate.query(
                "SELECT id, firstname, lastname, nickname, street, number, email, town, plz FROM contacts WHERE firstname LIKE ?",
                new Object[]{firstname},
                (rs, rowNum) -> contactFromResultSet(rs));

        if (results != null && !results.isEmpty()) {
            return Optional.of(results.iterator().next());
        }
        return Optional.empty();
    }

    @Override
    public Contact getById(long id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, firstname, lastname, nickname, street, number, email, town, plz FROM contacts WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> contactFromResultSet(rs));
    }

    private Contact contactFromResultSet(ResultSet rs) throws SQLException {
        return new Contact(
                rs.getLong("id"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("nickname"),
                rs.getString("street"),
                rs.getString("number"),
                rs.getString("email"),
                rs.getString("town"),
                rs.getInt("plz"));
    }

    @Override
    public void save(Contact contact) {
        jdbcTemplate.update(
                "INSERT INTO contacts VALUES (?,?,?,?,?,?,?,?,?)",
                new Object[]{
                        contact.getId(),
                        contact.getFirstname(),
                        contact.getLastname(),
                        contact.getNickname(),
                        contact.getStreet(),
                        contact.getNumber(),
                        contact.getEmail(),
                        contact.getTown(),
                        contact.getPlz()
                });
    }

    @Override
    public void update(Contact contact) {
        String sqlStatement ="UPDATE contacts " +
                "SET firstname = ?, lastname = ?, nickname = ?, street = ?, number = ?, email = ?, town = ?, plz = ? " +
                "WHERE id ="+ contact.getId();
        jdbcTemplate.update(
                sqlStatement,
                new Object[]{
                        contact.getFirstname(),
                        contact.getLastname(),
                        contact.getNickname(),
                        contact.getStreet(),
                        contact.getNumber(),
                        contact.getEmail(),
                        contact.getTown(),
                        contact.getPlz()
                });
    }
}
