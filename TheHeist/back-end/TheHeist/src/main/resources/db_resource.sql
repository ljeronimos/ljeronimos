--DROP DATABASE IF EXISTS heist;
--CREATE DATABASE heist;
-- Insert the "Bank Robbery" job into the job table
INSERT INTO job (title) VALUES ('Bank Robbery');

-- Insert skills for the "Bank Robbery" job (job_id = 1)
INSERT INTO skill (title, job_id) VALUES ('mastermind', 1), ('hacker', 1), ('distraction', 1), ('driver', 1), ('muscle', 1), ('gunner', 1), ('cleanup', 1);

-- Insert the "Diamond Robbery" job into the job table
INSERT INTO job (title) VALUES ('Diamond Robbery');

-- Insert skills for the "Diamond Robbery" job (job_id = 2)
INSERT INTO skill (title, job_id) VALUES ('mastermind', 2), ('hacker', 2), ('distraction', 2), ('driver', 2), ('muscle', 2), ('gunner', 2), ('cleanup', 2), ('diamond Specialist', 2);


-- Insert the "Supermarket Robbery" job into the job table
INSERT INTO job (title) VALUES ('Supermarket Robbery');

-- Insert skills for the "Supermarket Robbery" job (job_id = 3)
INSERT INTO skill (title, job_id) VALUES ('mastermind', 3), ('distraction', 3), ('driver', 3), ('muscle', 3), ('gunner', 3);



INSERT INTO worker (id, alias, rate, seniority, skill) VALUES
(1, 'O-ren Ishii',300,'senior','muscle'),
  (2, 'Mr. Blonde', 250, 'senior', 'muscle'),
  (3, 'Mr. Blue', 120, 'junior', 'diamond Specialist'),
  (4, 'Mr. Brown', 300, 'senior', 'distraction'),
  (5, 'Mr. Orange', 250, 'senior', 'gunner'),
  (6, 'Mr. Pink', 200, 'senior', 'gunner'),
  (7, 'Mr. White', 600, 'senior', 'cleanup'),
  (8, 'Nice Guy Eddie', 350, 'senior', 'driver'),
  (9, 'Fredrick Zoller', 200, 'senior', 'gunner'),
  (10, 'Jackie Brown', 200, 'senior', 'hacker'),
  (11, 'Elle Driver', 200, 'senior', 'hacker'),
  (12, 'Mia Wallace', 300, 'senior', 'hacker'),
  (13, 'Jules Winfield', 400, 'senior', 'hacker'),
  (14, 'Vincent Vega', 500, 'senior', 'gunner'),
  (15, 'Fabienne', 300, 'senior', 'hacker'),
  (16, 'Shosanna', 500, 'senior', 'distraction'),
  (17, 'Bridget von Hammersmark', 400, 'senior', 'distraction'),
  (18, 'Col. Hans Landa', 350, 'senior', 'driver'),
  (19, 'Lt. Archie Hicox', 400, 'senior', 'driver'),
  (20, 'Sgt. Hugo Stiglitz', 300, 'senior', 'muscle'),
  (21, 'Broomhilda von Shaft', 500, 'senior', 'muscle'),
  (22, 'Vernita Green', 200, 'senior','distraction');
