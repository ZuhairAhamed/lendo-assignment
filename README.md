Clone the project.

Change username and password for the database in application yaml

provide username and password (bycrypt) in user table Eg: username = test2 , password = $2a$12$RVX2.oJheHJhiqCv.9e1ouNaKV0CYKgXGIxDheqZ22jw3Jm5AG1wy

hit the login api (http://localhost:8080/login) with user name and password(decrypted password)  Eg: username= test2 , password = test2

With the token hit the api (http://localhost:8080/api/users/all)
