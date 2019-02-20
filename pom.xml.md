# About pom.xml

I'm including pom.xml because, currently, it automatically downloads all the dependencies and builds the plugin against them. In time, this `pom.xml` will become outdated, so I'm writing this to help guide anyone not familiar with Maven through it.

`pom.xml` contains the dependencies of the project, as well as repositories of where to find them. In theory, the only thing you'd need to change with the dependencies is the version numbers, but I could be wrong.

Basically, the way Maven searches repositories for dependencies is as follows, it will search each repository for the group id of each dependency (ie `org.bukkit`, replacing `.` for `/`, so it will search `https://hub.spigotmc.org/nexus/content/repositories/snapshots/` for the folder `org/`, then for `(org/)bukkit/`). After it finds the group id, it will search for the artifact id within the group id folder (ie in `https://hub.spigotmc.org/nexus/content/repositories/snapshots/org/bukkit/` it will search for `bukkit/`). Then, it will search this folder for the version number (ie `org/bukkit/bukkit/1.13.2-R0.1-SNAPSHOT`). Maven does not replace the dots in the version. 

In theory, to debug the YAPP source on a different Spigot/Bukkit version, all that you'll need to change is the version for each in `pom.xml`. Just check what the version is called in the repositories.

YAPP also uses kitteh's TapAPI and has compile-time dependencies for VaultAPI and MySQL Java Connector, both of which are now added to `pom.xml`. The repository listed in the VaultAPI documentation is now offline, so instead this repo uses EssentialsX's repository, which does include VaultAPI. 