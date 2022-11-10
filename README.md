# songr

A basic webapp made with java, spring, and thymeleaf. It displays album names and titles, with more album info to be added in the future.

## To run
In your terminal, navigate to the project root. Run `./gradlew bootRun` to start app. In your browser, navigate to `localhost:8080/` and use the routes below to visit different pages.

## Routes

`/hello`

Displays a greeting message

`/capitalize/wordToCapitalize`

Displays the string after `/capitalize/` in all caps

`/albums`

Displays album info from db and allows the entry of new albums to that db

11/9 - adds functionality to add songs to specific albums
