DELETE FROM tasks;
DELETE FROM users;
DELETE FROM projects;

INSERT INTO users (name)
VALUES ('Codi Yakubov'),
       ('Win Cucinotta'),
       ('Dudley Northall'),
       ('Albrecht Esselen'),
       ('Raul Laydel'),
       ('Marlow Waything'),
       ('Mateo Georgeon'),
       ('Cecil Drewell'),
       ('Finn Mcowis'),
       ('Babbette Charlotte');

INSERT INTO projects (name)
VALUES ('Treeflex'),
       ('Tempsoft'),
       ('Lotlux'),
       ('Zoolab'),
       ('Overhold'),
       ('Flowdesk');

INSERT INTO tasks (user_id, project_id, subject, priority, type, description)
VALUES (1, 1, 'Database', 7, 'Implementing', 'Ameliorated discrete synergy'),
       (2, 1, 'Front page', 2, 'Implementing', 'Sharable 6th generation frame'),
       (3, 2, 'Transactions', 8, 'Implementing', 'Integrated heuristic local area network'),
       (4, 2, 'Ui', 5, 'Discussing', 'Extended neutral conglomeration'),
       (5, 3, 'Hosting', 4, 'Studying', 'Versatile empowering capacity'),
       (6, 4, 'Unit tests', 2, 'Implementing', 'Exclusive high-level firmware'),
       (7, 5, 'Documentation', 4, 'Discussing', 'Up-sized even-keeled synergy'),
       (9, 5, 'Deploy', 1, 'Studying', 'Function-based intangible process improvement'),
       (9, 5, 'Architecture', 3, 'Implementing', 'Function-based object-oriented architecture'),
       (10, 6, 'Debug', 9, 'Implementing', 'Quality-focused well-modulated array');
