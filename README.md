## Stack Overflow Documentation Project.

The project employs search engine architecture to discover StackOverflow information of various programming languages.

## Getting Started
- Download Apache Tomcat - https://tomcat.apache.org/download-90.cgi
- Extract Tomcat library and paste to /tomcat
- In Run/Debug Configurations add Tomcat Server > Local
- Fix Artifacts to load Tomcat Library
- If project is not loading > Run/Debug Configurations > Build Artifacts > Add Configurations > Build Artifacts
- Cons.java class dictates URL path: 
 > Mac/LinuxOS -  public static final String URL_DB = "jdbc:sqlite:../../../src/TempStackDoc.db";
 > WindowsOS -  public static final String URL_DB = "jdbc:sqlite:..\\..\\..\\src\\TempStackDoc.db";
 
### Prerequisites
- JDK 1.8
- Sqlite Data Base (org.sqlite.JDBC)
- Tomcat 9.0.16+ Software

public class DatabaseConnection {

    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL_DB);
        return conn;
    }
}

### Installing

- Clone the project via GitHub
1. Open Terminal 
2. git clone (Project URL)

End with an example of getting some data out of the system or using it for a little demo
- JsonParser.java class used to convert .json data into Sqlite Data Base
- Json files are presented in Json folder
- Sqlite Database TempStackDoc.db is ignored due to memory limitations
## Running the tests


### Break down into end to end tests

Explain what these tests test and why

```Give an example```

### And coding style tests

Explain what these tests test and why

```Give an example```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* Front end - npm install via terminal
## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags).

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc