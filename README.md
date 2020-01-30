# ProjetMaster

## Back

On utilise un back java avec maven, un serveur jetty, une base de donnée MongoDB, et un langage de requete GraphQL.

__Prérequis__

Pour commencer il vous faudra MongoDb installé sur votre machine. La version utillisée est la 4.2
Suivre ce tuto [Installer MongoDB](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/)

Si votre installation fonctionne, vous devriez pouvoir lancer : "C:\Program Files\MongoDB\Server\4.2\bin\mongo.exe"

__Lancer le serveur Jetty__

Une fois le projet clone, lancez le avec eclipse, si il faut changer les fichiers de configurations pour correspondre a votre machine.

Comment lancer Jetty ?

Dans run configuration, créer une configuration Maven Build, nomez la "run".
Dans base Directory : cliquez sur workspace et selectionnez le projet
Goals mettez : jetty:run

Comment arretez Jetty ?

Dans run configuration, créer une configuration Maven Build, nomez la "stop".
Dans base Directory : cliquez sur workspace et selectionnez le projet
Goals mettez : jetty:stop

