DROP TABLE contacts IF EXISTS;

CREATE TABLE contacts (
  id          BIGINT IDENTITY PRIMARY KEY,
  firstname   VARCHAR(80),
  lastname    VARCHAR(80),
  nickname    VARCHAR(50),
  street      VARCHAR(50),
  number      VARCHAR(50),
  email      VARCHAR(50),
  town        VARCHAR(50),
  plz         INTEGER(10)
);
CREATE INDEX idx_contacts_name ON contacts (id);
