begin;

insert into tracker.projects (project_name,start_date,complete_date,p_priority,project_status) values('Test','2022-02-03','2022-02-03','1','Active');
insert into tracker.tasks (task_name,description,t_priority,task_status,project_id) values('Task 1','Test task','1', 'ToDo','1');
insert into tracker.tasks (task_name,description,t_priority,task_status,project_id) values('Task 2','Test task','1', 'ToDo','1');

insert into tracker.projects (project_name,start_date,complete_date,p_priority,project_status) values('Test 2','2022-02-07','2022-02-20','2','NotStarted');
insert into tracker.tasks (task_name,description,t_priority,task_status,project_id) values('Task 2_1','Test task','1', 'ToDo','1');
insert into tracker.tasks (task_name,description,t_priority,task_status,project_id) values('Task 2_2','Test task','1', 'ToDo','1');

insert into tracker.projects (project_name,start_date,complete_date,p_priority,project_status) values('Test 3','2022-02-10','2022-03-03','1','NotStarted');
insert into tracker.tasks (task_name,description,t_priority,task_status,project_id) values('Task 3_1','Test task','1', 'ToDo','1');
insert into tracker.tasks (task_name,description,t_priority,task_status,project_id) values('Task 3_2','Test task','1', 'ToDo','1');

insert into tracker.projects (project_name,start_date,complete_date,p_priority,project_status) values('Test 4','2022-02-07','2022-02-20','2','NotStarted');
insert into tracker.tasks (task_name,description,t_priority,task_status,project_id) values('Task 4_1','Test task','1', 'ToDo','2');
insert into tracker.tasks (task_name,description,t_priority,task_status,project_id) values('Task 4_2','Test task','1', 'ToDo','2');

insert into tracker.projects (project_name,start_date,complete_date,p_priority,project_status) values('Test 5','2022-02-10','2022-03-03','1','NotStarted');
insert into tracker.tasks (task_name,description,t_priority,task_status,project_id) values('Task 5_1','Test task','1', 'ToDo','3');
insert into tracker.tasks (task_name,description,t_priority,task_status,project_id) values('Task 5_2','Test task','1', 'ToDo','3');

commit;