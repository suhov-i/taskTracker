DELETE FROM tasks;
DELETE FROM users;
DELETE FROM projects;

INSERT INTO users (name)
VALUES ('Vasya'),
       ('Vladimir'),
       ('Elena'),
       ('Victor'),
       ('Maria'),
       ('Svetlana');

INSERT INTO projects (name)
VALUES ('Sberbank Online'),
       ('MTS Site'),
       ('Video Storage'),
       ('Betting App');

INSERT INTO tasks (user_id, project_id, subject, priority, type, description)
VALUES (1, 2, 'database', 7, 'implementing', 'description'),
       (2, 1, 'front page', 2, 'implementing', 'description'),
       (3, 1, 'transactions', 8, 'debugging', 'description'),
       (4, 3, 'ui', 5, 'implementing css', 'description'),
       (5, 3, 'hosting', 4, 'debugging', 'description'),
       (6, 4, 'architecture', 9, 'implementing', 'description');