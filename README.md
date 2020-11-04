# Java XSD Inheritance
![License MIT](https://img.shields.io/badge/License-MIT-green)
![Java 1.8](https://img.shields.io/badge/Java-1.8-blue)

Cieľom projektu je demonštrovať spôsob definovania dedenie jednotlivých entít pomocou XSD schémy.
Schéma je následne využitá v jednoduchej SAO aplikácii s webovou službou definovanú pomocou WSDL schémy.
Aplikácia implementuje spracovanie WSDL schémy pre webovú službu,
spracovanie XML súborov pre automatické generovanie POJO tried.

Aplikácia taktiež implementuje upravený adaptér pre spracovanie dátumu z XML súborov.

## JAXB
JAXB je využívaný aplikáciou, ako maven plugin.
XML súbory definujúce triedy sú umiestnené `src/main/resources/`.
Vygenerované triedy sú umiestnené v `target/generated-sources/java/`.

Viac informácií o JAXB [baeldung.com](https://www.baeldung.com/jaxb).

### Vygenerovanie tried
Pre vygenerovanie tried pomocou JAXB Maven plugin
```
mvn clean compile
```

## Web service
Aplikácia implementuje webovú službu s jedným endpointom `http://localhost:8080/zmluvy`,
ktorý vráti zoznam dokumentov zmlúv v aplikácii.

### Test
Testovať implementovanú webovú službu je možné pomocou [SoapUI](https://www.soapui.org/),
alebo v terminály cez cUrl.

Request
```
curl -v -H "Content-Type: text/xml; charset=utf-8" -d "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body/></soapenv:Envelope>" -X POST http://localhost:8080/zmluvy  
```

Response
```
<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	<S:Body>
		<listResponse xmlns="docs">
			<doc xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="travel_doc">
				<id>0</id>
				<created>04.11.2020</created>
				<start_date>09.11.2020</start_date>
				<value>0.0</value>
				<monthly>0.0</monthly>
				<insured_id>0</insured_id>
				<validity>worldwide</validity>
				<purpose>travel</purpose>
			</doc>
			<doc xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="injury_doc">
				<id>0</id>
				<created>04.11.2020</created>
				<start_date>09.11.2020</start_date>
				<value>0.0</value>
				<monthly>0.0</monthly>
				<insured_id>0</insured_id>
				<permanent_value>30000.0</permanent_value>
				<death_value>25000.0</death_value>
			</doc>
		</listResponse>
	</S:Body>
</S:Envelope>
```

## Build
Pre kompilovanie aplikácie
```
mvn clean package
```

## Run
Pre spustenie aplikácie
```
java -jar target/java-course-xsd-inheritance-1.0.0.jar
```