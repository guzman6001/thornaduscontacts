# thornaduscontacts
Save easily your contacts with Thornadus

### Download
> $ git clone https://github.com/guzman6001/thornaduscontacts.git

### Install & Run
Spring Initializr uses maven wrapper so type this:
> $ ./mvnw clean spring-boot:run

Alternatively using your installed maven version type this:
> $ mvn clean spring-boot:run

When the app starts, we can use Postman to test the services provided.

### Services

##### Create
Create a new contact all all fields are mandatory.
- Endpoint
> localhost:8082/api/contacts
- Method **POST**
- Example request
>```
>{
>  "id": null,
>  "firstName": "Hector",
>  "lastName": "Guzman",
>  "email": "guzman6001@gmail.com"
>}
>```

##### Read / List
Read the contact identified by [ID]. Optionaly if [ID] is not sent it will return all contacts. 
- Endpoint
> localhost:8082/api/contacts/[ID]
- Method **GET**

##### Update
Update/Edit the contact identified by [ID]. Returns the contact updated. [ID] is mandatory.
- Endpoint
> localhost:8082/api/contacts/**[ID]**
- Method **PUT**
- Example request
>```
>{
>  "id": 1,
>  "firstName": "Hector",
>  "lastName": "Guzman",
>  "email": "guzman6001@yahoo.com"
>}
>```

##### Delete
Delete the contact identified by [ID]. Returns the contact deleted.
- Endpoint
> localhost:8082/api/contacts/**[ID]**
- Method **DELETE**





