# GAS-STATION

## Description:

I use Intelij IDEA + JAVA + Spring Boot + MySQL

Well I tried to make Layered Architecture -> Controler -> Service -> ServiceImpl -> Repository with business logic -> DataBase.

I use BindingModel/DTO to transfer the information. All REST API endpoints are at the controller.


## Installation:
1. Download source code.
2. Load Project in your Integrated Development Environment (IDE). I use INTELIJ IDEA
3. Check out "application.yml" file for database information.
4. Put your root and password for DB in application.yml file.
5. Connect the project with database. (I use MySQL).
6. Press "Run" button.
7. Go to your Browser or Postman. Both working fine :)
8. Enter this url -> http://localhost:8080/    HERE you will see white label error page but dont be Sad. Everything is working fine.

   
## NOTE:
When you start the project for the first time you may see at the console a big error. After that start project again and the error disapear.

## REST API endpoints:
1. http://localhost:8080/json -> This one shows the whole information from JSON URL.
2. http://localhost:8080/api/stations -> This path shows all info inserted into DataBase from starting JSON URL.
3. http://localhost:8080/api/max/diesel -> This path shows Object/s from DB with maximum Diesel price.
4. http://localhost:8080/api/min/diesel -> This path shows Object/s from DB with minimum Diesel price.
5. http://localhost:8080/api/max/e5 -> This path shows Object/s from DB with maximum E5 price.
6. http://localhost:8080/api/min/e5 -> This path shows Object/s from DB with minimum E5 price.
7. http://localhost:8080/api/max/e10 -> This path shows Object/s from DB with maximum E10 price.
8. http://localhost:8080/api/min/e10 -> This path shows Object/s from DB with minimum E10 price.
9. http://localhost:8080/api/average/diesel -> Average Diesel price for all Gas-Stations.
10. http://localhost:8080/api/average/e5 -> Average E5 price for all Gas-Stations.
11. http://localhost:8080/api/average/e10 -> Average E10 price for all Gas-Stations.
12. http://localhost:8080/api/station/ENI -> Shows all object with given Name. Here for example I use Name -> ENI. You can delete it and put other name and press Enter. 


## License
[MIT](https://choosealicense.com/licenses/mit/)
