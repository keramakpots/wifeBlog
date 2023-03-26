
CREATE DATABASE blogDb.sqlite;

CREATE TABLE BlogRecord (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  BlogTextEntry TEXT,
  author TEXT,
  date TEXT
);

CREATE TABLE BlogUsers (
  userName TEXT,
  ID INTEGER PRIMARY KEY AUTOINCREMENT,
  password TEXT,
  Login TEXT
);