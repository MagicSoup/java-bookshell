INSERT INTO author
VALUES (1, 'Kathy', 'Sierra'),
       (2, 'Bert', 'Bates'),
       (3, 'Bryan', 'Basham');

INSERT INTO book(`id`, `title`, `published_at`)
VALUES (1, 'Head First Java', '2020-04-05'),
       (2, 'Head First Servlets and JSP', '2020-04-20'),
       (3, 'OCA/OCP Java SE 7 Programmer', '2021-05-01');

COMMIT;

INSERT INTO author_book(author_id, book_id)
VALUES (1, 1),
       (2, 1),
       (1, 2),
       (2, 2),
       (3, 2),
       (1, 3),
       (2, 3);