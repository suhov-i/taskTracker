DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    subject     VARCHAR   NOT NULL,
    priority    INTEGER   NOT NULL,
    type        TEXT      NOT NULL,
    description TEXT      NOT NULL,
    project     TEXT      NOT NULL,
    user        VARCHAR   NOT NULL
);

