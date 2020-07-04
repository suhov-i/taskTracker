DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS projects;

CREATE TABLE users
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR NOT NULL
);

CREATE TABLE projects
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR NOT NULL
);

CREATE TABLE tasks
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_id     INTEGER   NOT NULL,
    project_id  INTEGER   NOT NULL,
    subject     TEXT      NOT NULL,
    priority    INTEGER   NOT NULL,
    type        TEXT      NOT NULL,
    description TEXT      NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE
);

