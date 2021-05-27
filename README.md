# Contact List

## Project

A Graded Exercise from the SWA Module.

The delivered application is composed of multiple **modules** resp. generates multiple **jars**.

#### Minimum requirements

The application should be able to, at least, do the following:
* List the entities
* Create/edit one entity

You will have to use a repository (or database), where you will _persist_ the entities. This repository could be a _real_ database (deployed via **Docker** for instance), an _in-memory_ one or a simple file.

#### Possible extensions

* Delete
* Entity:
  * `Magazine` (as extension of `Book`)
  * `Company` (as extension of `Person`)
* Image upload (in its own *module*)

#### Reference applications

* [ch.fhnw.swa.modserv.cli](https://github.com/ribeaud/ch.fhnw.swa.modserv.cli)
* [myshop](https://github.com/ribeaud/blog-code-samples/tree/master/myshop)
* [PetClinic](https://github.com/spring-projects/spring-petclinic)

## Project delivery

#### Build
```
mvn clean install
```

#### Run
```
mvn spring-boot:run -f app/pom.xml
```
Application started on `localhost/8080/contacts`


#### Only run Tests
```
mvn test
```


#### External contributions:

Inspired by the following projects:

* [myshop](https://github.com/ribeaud/blog-code-samples/tree/master/myshop)
* [PetClinic](https://github.com/spring-projects/spring-petclinic)
* [Flashcard](https://github.com/sivelin/flashcard) developed for Stefan Meichtry's module Webframeworks

Used for the frontend:
* [Google Icons](https://www.w3schools.com/icons/google_icons_intro.asp)
* [Bootstrap](https://getbootstrap.com/docs/5.0)

Collaborated on the RestAPI with [Julia Müller](https://github.com/JuliaLauraMueller).

#### Other comments:
One known Bug:
* ID can be updated in Frontend but shouldn't.

There is an index.html file in the project where the project and its features are presented.

#### I'm particular proud of:
* Using messages.properties
* Code commented
* Responsive Design
* Good Usability
