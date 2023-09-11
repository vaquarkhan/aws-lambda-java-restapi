![alt text](/sc.png)

## About
A rest api with different endpoints hosted on aws lambda & api gateway using java.

## Endpoints
    1. GET /products
    2. GET /products/{id}
    3. GET /products/categories

## Test
```bash
mvn test
```

## How to deploy ?
1. Go to your aws account
2. Search for Lambda and click it
3. Create your lambda && ```Resources```  & their methods.
4. Connect your aws Lambda Function to your Api Gateway.
5. Click deploy.
6. run ```mvn clean package```
7. Upload your jar to lambda
8. Test in postman !!!

======================================================================

{
  "x": 11,
  "y": 20,
  "message": "Hello World!"
}
==================================================================

update HandlerInfo:

               org.awslambda.restapi.HandlerIntegerJava17::handleRequest

Note : packagename.classname::public method name
==================================================================

			package org.awslambda.restapi;

			import com.amazonaws.services.lambda.runtime.Context;
			import com.amazonaws.services.lambda.runtime.LambdaLogger;
			import com.amazonaws.services.lambda.runtime.RequestHandler;

			// Handler value: example.HandlerInteger
			public class HandlerIntegerJava17 implements RequestHandler<IntegerRecord, Integer> {

				@Override
				/*
				 * Takes in an InputRecord, which contains two integers and a String. Logs the
				 * String, then returns the sum of the two Integers.
				 */
				public Integer handleRequest(IntegerRecord event, Context context) {
					LambdaLogger logger = context.getLogger();
					logger.log("String found: " + event.message());
					return event.x() + event.y();
				}
			}

			record IntegerRecord(int x, int y, String message) {
			}

================================================================

            	<?xml version="1.0" encoding="UTF-8"?>
				<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
					<modelVersion>4.0.0</modelVersion>

					<groupId>org.awslambda.restapi</groupId>
					<artifactId>lambda-andes-api</artifactId>
					<version>1.0-SNAPSHOT</version>

					<properties>
						<maven.compiler.source>17</maven.compiler.source>
						<maven.compiler.target>17</maven.compiler.target>
						<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
					</properties>

					<dependencies>
						<!-- https://mvnrepository.com/artifact/com.amazonaws/aws-lambda-java-core -->
						<dependency>
							<groupId>com.amazonaws</groupId>
							<artifactId>aws-lambda-java-core</artifactId>
							<version>1.2.2</version>
						</dependency>

						<!-- https://mvnrepository.com/artifact/com.amazonaws/aws-lambda-java-events -->
						<dependency>
							<groupId>com.amazonaws</groupId>
							<artifactId>aws-lambda-java-events</artifactId>
							<version>3.11.2</version>
						</dependency>

						<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
						<dependency>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
							<version>1.18.28</version>
							<scope>provided</scope>
						</dependency>

						<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine -->
						<dependency>
							<groupId>org.junit.jupiter</groupId>
							<artifactId>junit-jupiter-engine</artifactId>
							<version>5.10.0</version>
							<scope>test</scope>
						</dependency>

						<!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
						<dependency>
							<groupId>com.google.code.gson</groupId>
							<artifactId>gson</artifactId>
							<version>2.10.1</version>
						</dependency>

					</dependencies>

					<build>
						<plugins>
									<plugin>
											<artifactId>maven-surefire-plugin</artifactId>
											<version>2.22.2</version>
										</plugin>
										<plugin>
											<groupId>org.apache.maven.plugins</groupId>
											<artifactId>maven-shade-plugin</artifactId>
											<version>3.2.2</version>
											<configuration>
												<createDependencyReducedPom>false</createDependencyReducedPom>
												<filters>
													<filter>
														<artifact>*:*</artifact>
														<excludes>
															<exclude>module-info.class</exclude>
															<exclude>META-INF/*</exclude>
															<exclude>META-INF/versions/**</exclude>
															<exclude>META-INF/services/**</exclude>
														</excludes>
													</filter>
												</filters>
											</configuration>
											<executions>
												<execution>
													<phase>package</phase>
													<goals>
														<goal>shade</goal>
													</goals>
												</execution>
											</executions>
										</plugin>
										<plugin>
											<groupId>org.apache.maven.plugins</groupId>
											<artifactId>maven-compiler-plugin</artifactId>
											<version>3.8.1</version>
											<configuration>
												<source>17</source>
												<target>17</target>
											</configuration>
										</plugin>
							

						</plugins>
					</build>

				</project>
