INSERT INTO author
VALUES (1, 'Kathy', 'Sierra'),
       (2, 'Bert', 'Bates'),
       (3, 'Bryan', 'Basham');

INSERT INTO book
VALUES (1, 'Head First Java'),
       (2, 'Head First Servlets and JSP'),
       (3, 'OCA/OCP Java SE 7 Programmer');

COMMIT;

INSERT INTO author_book(author_id, book_id)
VALUES (1, 1),
       (2, 1),
       (1, 2),
       (2, 2),
       (3, 2),
       (1, 3),
       (2, 3);