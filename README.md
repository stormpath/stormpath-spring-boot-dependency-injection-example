#Stormpath is Joining Okta
We are incredibly excited to announce that [Stormpath is joining forces with Okta](https://stormpath.com/blog/stormpaths-new-path?utm_source=github&utm_medium=readme&utm-campaign=okta-announcement). Please visit [the Migration FAQs](https://stormpath.com/oktaplusstormpath?utm_source=github&utm_medium=readme&utm-campaign=okta-announcement) for a detailed look at what this means for Stormpath users.

We're available to answer all questions at [support@stormpath.com](mailto:support@stormpath.com).


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
