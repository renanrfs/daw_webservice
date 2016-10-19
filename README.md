daw_webservice
==============


<p><em><strong>Web Service:</strong></em></p>

<p><em>User Persistence:</em></p>
- public List<User> getAllUsers(); [ GET - <em>http://localhost:8080/moss-ws/rest/user/getall</em> ]
- public User getUser(int userId); [ GET - <em>http://localhost:8080/moss-ws/rest/user/{userId}</em> ]
- public ResponseWS createUser(String name, String username, String password, String email, String site, int cityId); [ POST - <em>http://localhost:8080/moss-ws/rest/user?name=RenanFernandes&username=renan.fernandes&password=asd123&email=renan@gmail.com&site=www.renanfernandes.com&cityId=1</em> ]
- public ResponseWS updateUser(int id, String name, String username, String password, String email, String site, int cityId); [ PUT - <em>http://localhost:8080/moss-ws/rest/user?id=1&name=RenanFernandes&username=renan.fernandes&password=asd123&email=renan@gmail.com&site=www.renanfernandes.com&cityId=1</em> ]
- public ResponseWS deleteUser(int id); [ DELETE - <em>http://localhost:8080/moss-ws/rest/user/{userId}</em> ]
    
<p><em>Country Persistence:</em></p>
- public List<Country> getAllCountries(); [ GET - <em>http://localhost:8080/moss-ws/rest/country/getall</em> ]
  
<p><em>City Persistence:</em></p>
- public List<City> getAllCities(int countryId); [ GET - <em>http://localhost:8080/moss-ws/rest/city/{countryId}</em> ]


<p><em><strong>Maven Config</strong></em></p>

O Maven escolhido para este projeto foi Apache Maven 3.0.4 (r1232337; 2012-01-17 08:44:56+0000).
O Maven pode ser encontrado em: http://maven.apache.org/download.cgi

Podes correr o comando "mvn --version" para confirmar que o Maven está bem configurado.

Após instalação do maven, deves executar os seguintes passos:
- editar a propriedade "outputDirectory" em DAW-webservice-module/daw-webservice-ear/pom.xml para apontar a instalação do Jboss, ex.: <outputDirectory>D:\tools\jboss\server\default\deploy</outputDirectory>
- instalação do projeto: "mvn clean install";


<p><em><strong>Jboss Config</strong></em></p>

O application server escolhido para este projeto foi o Jboss-4.2.3.GA.
O JBOSS-4.2.3.GA pode ser encontrado em: http://sourceforge.net/projects/jboss/files/JBoss/JBoss-4.2.3.GA/

Após unzip do application server, basta copiar os seguintes ficheiros:
- daw_webservice/jboss-config/mossws-ds.xml (ficheiro de configuração a base de dados) -> jboss-4.2.3.GA\server\default\deploy;
- daw_webservice/jboss-config/mysql-connector-java-5.0.8-bin (mysql driver connector) -> jboss-4.2.3.GA\server\default\lib;

Para execução do application server basta correr o seguinte script 
- jboss-4.2.3.GA\bin\run.sh (MAC version).
- jboss-4.2.3.GA\bin\run.bat (WINDOWS version).


Pronto, já tem o webservice a correr em http://localhost:8080/moss-ws/rest/...
