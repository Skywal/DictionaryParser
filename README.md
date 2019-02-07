# DictionaryParser
Program for parsing https://dictionary.cambridge.org/ for words and definitions.
You must create database "dictionary" with your local MySQL, and create table "WordList" with columns "Word varchar(),
TranscriptionUk varchar(),
TranscriptionUs varchar(),
Definition tinytext,
LanguagePart varchar()". All columns should have utf8mb4 collation. Also create database.properties in project root directory 
with structure: "url = jdbc:mysql://localhost/dictionary?serverTimezone=Europe/Kiev&useSSL=false&useUnicode=yes&characterEncoding=UTF-8
username = your_username
password = your_password".
