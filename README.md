# MetaDataUpdate

A showcase for using the Rosetta Webservices to update Metadata in Rosettas Permanent. 
It's build with [play framework](https://www.playframework.com/), which I agree is a bit oversized for this small
application. But it's my favorite developing environment, so it was quickly setup.  

The application has a form page for entering the necessary data and a result page with progressbar and the
possibility to download an csv file with the logged data. The once entered data is saved locally for later use.  

The application searches for a key by SRU, gets the ID of the IE so it can update the value in the replace key field.
The main logic is made in the [UpdateActor](https://github.com/ottk-zbw/MetaDataUpdate/blob/master/app/actors/UpdateActor.java)
Speaking of Actor: PlayFramework is [reactive](http://www.reactivemanifesto.org/).

Some values in the form have to be explained:  

* **Searchkey**: the key field to be searched by SRU
* **Replacekey**: the key field in the mets to be replaced
* **Replacekeyattribute**: Maybe the field to be replaced needs an attribute
* **Data**: lines of value pairs to be updated - `<value of searchkey>;<value to update replace field>`

## Requirement

You need a Java JDK

## Running

* Clone it
* For running in [development mode](https://www.playframework.com/documentation/2.3.x/PlayConsole): `activator run`  
* For creating a [standalone version](https://www.playframework.com/documentation/2.3.x/ProductionDist): `activator dist` 
This produces a ZIP file containing all JAR files needed to run your application in the target/universal folder of your application.  


