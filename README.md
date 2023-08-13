# XMLHelper

## General Idea
This small application is built as a Proof of Concept (POC) to demonstrate a method for extracting values from an existing document and writing them into a new document. 
Currently, it only supports parsing and writing XML documents. However, the code is designed to be easily extended (despite the use of the rather non-generic name "XMLHelper" for the project 😉).

## Design
As mentioned earlier, the design concept behind this project is focused on extensibility. A significant portion of the logic is abstracted and loosely coupled through interfaces. 
If this application is to be further developed, it's suggested to have separate helper classes, parsers, and writers for each document type. 
While some might argue that the service layer shouldn't directly interact with a helper class, it's worth considering that in the future, 
the service class might handle additional responsibilities such as database connections (perhaps a future version could offer the option to save files to a database) 
or communication with email services or similar functionalities. Thus, much of the business logic is placed within a helper class.

## Roadmap
The next step involves implementing a controller (and migrate the project to use Spring Boot) to transform this application into an API. 
It will also be necessary to set up a database and a cache. Currently, the output file's path is hardcoded, leading to it being overwritten with every write operation. 
Instead, users should have the ability to specify the desired destination for saving the file.
