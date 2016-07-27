This example demonstrates Spring's Dependency Injection features in a Spring Boot application.

All of the code is explained in the blog post found [here](http://stormpath.com/blog).

### Build

```
mvn clean install
```

### Run

```
[LANGUAGE_NAME=english|french] \
[LIFE_INT=<number>] \
[LIFE_STRING=<string>] \
java -jar target/*.jar
```

All parameters are optional and are used to demonstrate different modes of operation explained in the blog post.

### Interact

The examples below use [HTTPie](https://github.com/jkbrzt/httpie)

1. `http localhost:8080`
    
     returns a greeting from the configured `greetinService` - English by default

2. `http localhost:8080/meaningOfLife`
    
    returns the value from the `MeaningOfLife` component injected in the constructor - 0 by default

3. `http localhost:8080/name?type=[dog|person]`
    
    returns the name found in the appropriate `Nameable` component injected using setters in `NameHelper`

4. `http localhost:8080/allNames`
    
    returns all the names from all the `Nameables` loaded by Spring

5. `http localhost:8080/beans[?q=<search term>]`
    
    returns all the bean names loaded by Spring. Takes an optional `q` query param to narrow the search to beans whose names contain the search term (case insensitive)
