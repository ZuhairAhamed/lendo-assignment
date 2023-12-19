1. Clone the project.
2. Install **postgress db** in the local.
3. Change **username and password** for the database in application yaml
4. Run the application (lendo-assignment)
5. It will automatically create table in the db (lendo_database)
6. Run the sql script =>  **insert into public.users values (1, '$2y$10$ctdUGdZsSpSYRt0kCIY.WujxHS9JSHalXkrub.jOQb0CihvKNiuMC', 'test');**
7. Then hit the login api

  **api**
   POST : http://localhost:8080/login

  **requesBody**
   {
    "username" : "test",
    "password" : "test"
    }

  **response**
   {
    "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0IiwiaWF0IjoxNzAzMDAzMzIzLCJleHAiOjE3MDMwMDkzMjN9.e3KaK9v1v0apszO9fuCKbonTU74uiYcWJR0Uejydg24"
   }

8. Then can call the below Api

   GET : http://localhost:8080/api/posts/all
   GET : http://localhost:8080/api/users/all
   GET : http://localhost:8080/api/comments/all

   GET : http://localhost:8080/api/posts/filter/5840205
   GET : http://localhost:8080/api/comments/filter/90582

   while calling the above api need to pass the **accessToken** as a **Bearer Token**

9. Finally you can see the response
