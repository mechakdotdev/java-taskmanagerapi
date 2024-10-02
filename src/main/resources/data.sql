INSERT INTO "projects" (name, description)
VALUES ('Alpha Project', 'Primary project for creating new project');
INSERT INTO "projects" (name, description)
VALUES ('Beta Project', 'Description of the secondary project');

INSERT INTO "tasks" (projectId, title, priority, dueDate, description)
VALUES (1, 'Create Alpha repo', 1, DATE '2024-10-01', 'Complete the first task');
INSERT INTO "tasks" (projectId, title, priority, dueDate, description)
VALUES (1, 'Add branch rules', 2, DATE '2024-10-10', 'Complete the second task');
INSERT INTO "tasks" (projectId, title, priority, dueDate, description)
VALUES (2, 'Create repo for Beta', 3, DATE '2024-10-05', 'Task for Project Beta');

INSERT INTO "labels" (taskId, title, description)
VALUES (1, 'Urgent', 'Needs to be done ASAP');
INSERT INTO "labels" (taskId, title, description)
VALUES (1, 'Research', 'Requires investigation');
INSERT INTO "labels" (taskId, title, description)
VALUES (2, 'Review', 'Needs to be reviewed by the team');
INSERT INTO "labels" (taskId, title, description)
VALUES (3, 'Follow-up', 'Requires follow-up after completion');