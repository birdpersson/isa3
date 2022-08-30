
INSERT INTO USERS (username, password, first_name, last_name, address, city, country, phone, role, enabled) VALUES ('user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'User', 'One', 'user@example.com', 'Cloud', 'Uns', '+1234567890', 1, true);
INSERT INTO USERS (username, password, first_name, last_name, address, city, country, phone, role, enabled) VALUES ('admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Admin', 'Too', 'admin@example.com', 'Base', 'Tee', '+9876543210', 0, true);

INSERT INTO AUTHORITY (name) VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);

INSERT INTO CABIN (name, address, description, availability_start, availability_end, price_list, rules, rooms, beds) VALUES ('One', 'One Street', 'About One', '2022-09-01 09:57:58', '2022-09-06 21:58:58', 'free', 'Mine', 3, 2);
INSERT INTO CABIN (name, address, description, availability_start, availability_end, price_list, rules, rooms, beds) VALUES ('Two', 'Two Street', 'About Two', '2022-09-11 18:57:58', '2022-09-16 21:58:58', 'ouch', 'Dine', 5, 1);
