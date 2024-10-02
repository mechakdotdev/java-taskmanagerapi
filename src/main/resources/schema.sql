CREATE TABLE "projects"
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE "tasks"
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    projectId  BIGINT,
    title       VARCHAR(255) NOT NULL,
    priority    INT,
    dueDate    DATE,
    description VARCHAR(255),
    FOREIGN KEY (projectId) REFERENCES "projects" (id)
);

CREATE TABLE "labels"
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    taskId     BIGINT,
    title       VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    FOREIGN KEY (taskId) REFERENCES "tasks" (id)
);