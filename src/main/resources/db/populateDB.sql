DELETE FROM tasks;

INSERT INTO tasks (user, project, subject, priority, type, description)
VALUES ('Vasya Ivanov', 'Sberbank Online', 'database', 7, 'implementing', 'description'),
       ('Vladimir Petrov', 'MTS Site', 'front page', 2, 'implementing', 'description'),
       ('Elena Vladimirova', 'Sberbank Online', 'transactions', 8, 'debugging', 'description'),
       ('Victor Stepanov', 'Video Storage', 'ui', 5, 'implementing css', 'description'),
       ('Maria Kirova', 'Betting App', 'hosting', 4, 'debugging', 'description'),
       ('Anton Stalin', 'Video Storage', 'architecture', 9, 'implementing', 'description');