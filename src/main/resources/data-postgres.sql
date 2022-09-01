INSERT INTO CABIN (name, address, description, availability_start, availability_end, people, price, cost, rules) VALUES ('One', 'One Street', 'About One', '2022-09-09 09:57:58', '2022-09-18 21:58:58', 6, 60, 12, 'Mine');
INSERT INTO CABIN (name, address, description, availability_start, availability_end, people, price, cost, rules) VALUES ('Too', 'Too Street', 'About Two', '2022-09-12 09:57:58', '2022-09-16 21:58:58', 7, 70, 17, 'Dine');
INSERT INTO CABIN (name, address, description, availability_start, availability_end, people, price, cost, rules) VALUES ('Tre', 'Tre Sucked', 'About Tre', '2022-09-13 09:57:58', '2022-09-26 21:58:58', 5, 50, 10, 'Tres');
INSERT INTO CABIN (name, address, description, availability_start, availability_end, people, price, cost, rules) VALUES ('For', 'For Struct', 'About For', '2022-09-14 09:57:58', '2022-09-24 21:58:58', 4, 40, 14, 'Fore');
INSERT INTO CABIN (name, address, description, availability_start, availability_end, people, price, cost, rules) VALUES ('Fiv', 'Fiv Struct', 'About Fiv', '2022-09-15 09:57:58', '2022-09-25 21:58:58', 5, 50, 15, 'Five');

INSERT INTO USERS (username, password, first_name, last_name, address, city, country, phone, role, enabled) VALUES ('admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Admin', '', 'admin@example.com', 'About', 'One', '+9876543210', 0, true);
INSERT INTO USERS (username, password, first_name, last_name, address, city, country, phone, role, enabled) VALUES ('user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'User', 'Too', 'user@example.com', 'Cloud', 'Uns', '+1234567890', 1, true);
INSERT INTO USERS (username, password, first_name, last_name, address, city, country, phone, role, enabled) VALUES ('host', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Host', 'Tre', 'host@example.com', 'Cloud', 'Tee', '+1234567899', 2, true);

INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_HOST');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);
