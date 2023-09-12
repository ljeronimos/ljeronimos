--DROP DATABASE IF EXISTS heist;
--CREATE DATABASE heist;
-- Insert the "Bank Robbery" job into the job table
INSERT INTO job (title) VALUES ('Bank Robbery');

-- Insert skills for the "Bank Robbery" job (job_id = 1)
INSERT INTO skill (title, job_id) VALUES ('mastermind', 1);
INSERT INTO skill (title, job_id) VALUES ('hacker', 1);
INSERT INTO skill (title, job_id) VALUES ('distraction', 1);
INSERT INTO skill (title, job_id) VALUES ('driver', 1);
INSERT INTO skill (title, job_id) VALUES ('muscle', 1);
INSERT INTO skill (title, job_id) VALUES ('gunner', 1);
INSERT INTO skill (title, job_id) VALUES ('cleanup', 1);

-- Insert the "Diamond Robbery" job into the job table
INSERT INTO job (title) VALUES ('Diamond Robbery');

-- Insert skills for the "Diamond Robbery" job (job_id = 2)
INSERT INTO skill (title, job_id) VALUES ('mastermind', 2);
INSERT INTO skill (title, job_id) VALUES ('hacker', 2);
INSERT INTO skill (title, job_id) VALUES ('distraction', 2);
INSERT INTO skill (title, job_id) VALUES ('driver', 2);
INSERT INTO skill (title, job_id) VALUES ('muscle', 2);
INSERT INTO skill (title, job_id) VALUES ('gunner', 2);
INSERT INTO skill (title, job_id) VALUES ('cleanup', 2);
INSERT INTO skill (title, job_id) VALUES ('diamond Specialist', 2);

-- Insert the "Supermarket Robbery" job into the job table
INSERT INTO job (title) VALUES ('Supermarket Robbery');

-- Insert skills for the "Supermarket Robbery" job (job_id = 3)
INSERT INTO skill (title, job_id) VALUES ('mastermind', 3);
INSERT INTO skill (title, job_id) VALUES ('distraction', 3);
INSERT INTO skill (title, job_id) VALUES ('driver', 3);
INSERT INTO skill (title, job_id) VALUES ('muscle', 3);
INSERT INTO skill (title, job_id) VALUES ('gunner', 3);

UPDATE job SET id = 1 WHERE id = 3;

-- Update the ID of "Diamond Robbery" from 1 to 3
UPDATE job SET id = 2 WHERE id = 1;

-- Update the ID of "Supermarket Robbery" from 2 to 1
UPDATE job SET id = 3 WHERE id = 2;

-- Update the corresponding job_id values in the "skill" table
UPDATE skill SET job_id = 1 WHERE job_id = 3;
UPDATE skill SET job_id = 2 WHERE job_id = 1;
UPDATE skill SET job_id = 3 WHERE job_id = 2;


INSERT INTO worker(id, alias, rate, seniority, skill) VALUES
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
                                                          (21, 'Broomhilda von Shaft', 500, 'senior', 'muscle');

                                                          1,Samuel L. Jackson,420,senior,mastermind
                                                          2,Mr. Blonde,250,senior,muscle
                                                          3,Mr. Blue,120,junior,diamond Specialist
                                                          4,Mr. Brown,300,senior,distraction
                                                          5,Mr. Orange,250,senior,gunner
                                                          6,Mr. Pink,200,senior,gunner
                                                          7,Mr. White,600,senior,cleanup
                                                          8,Nice Guy Eddie,350,senior,driver
                                                          9,Joe Cabot,500,senior,mastermind