
INSERT INTO USERS (username, password, first_name, last_name, address, city, country, phone, role, enabled) VALUES ('user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'User', 'One', 'user@example.com', 'Cloud', 'Uns', '+1234567890', 'user', true);
INSERT INTO USERS (username, password, first_name, last_name, address, city, country, phone, role, enabled) VALUES ('admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Admin', 'Too', 'admin@example.com', 'Base', 'Tee', '+9876543210', 'admin', true);

INSERT INTO AUTHORITY (name) VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);