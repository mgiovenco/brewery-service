# brewery-service

Notes:
-Project created with Spring initializer website.  Dependencies include = Actuator, Lombok, Web, Devtools.
-Project uses Maven + Java 11 + Spring Boot 2.3.1
-It's okay if implementation classes end with Impl if there is only a single implementation.
--If multiples, make more specific.

Useful Intellij Plugins:
-Lombok plugin
-Axis TCP Monitor

Spring Boot Developer Tools:
-Automatically recompiles project and re-runs.
-Added to Project via artifact 'spring-boot-devtools'.
-Developer Tools are automatically disabled when rrunning a packaged application (ie java -jar)
-By default, not included in repackaged archive
-Automatic restart
--Triggers a restart of the Spring Context when classes change
--Uses two classloaders.  One for your application, one for project jar dependencies
--Restarts are very fast, since only your project classes are being loaded
--In IntelliJ, by default you need to select 'Build / Make Project'
--There is an advanced setting you can change to make this more seamless
-Template caching
--By default templates are cahced for performance
--But caching will require a container restart to refresh the cache.
--Developer Tools will disable template caching so the restart is not required to see changes.
-LiveReload
--LiveReload is a technology to automatically trigger a browser refresh when resources are changed.
--Spring Boot Developer Tools includes a LiveReload server.
--Browser plugins are available for a free download at livereload.com.





