plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.0"
	id("com.apollographql.apollo") version "4.0.0"
	id("io.spring.dependency-management") version "1.1.6"
	id("com.diffplug.spotless") version "7.0.0.BETA4"
}

group = "client"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

apollo {
	service("server") {
		generateKotlinModels.set(true)
		packageName.set("autogen.graphql")
		introspection {
			endpointUrl.set("http://localhost:4000/graphql")
			schemaFile.set(file("src/main/graphql/schema.graphqls"))
		}
	}
}

tasks.getByName<com.apollographql.apollo.gradle.internal.ApolloDownloadSchemaTask>("downloadServerApolloSchemaFromIntrospection").taskAction()

repositories {
	mavenCentral()
}

dependencies {
	// Kotlin × Spring boot
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// Apollo(GraphQL)
	implementation("com.apollographql.apollo:apollo-runtime:4.0.0")

	// test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

spotless {
	kotlin {
		ktfmt()
		targetExclude("build/generated/source/apollo/server/autogen/graphql/**/*.kt")
	}
}

tasks.compileKotlin{
	dependsOn(tasks.spotlessApply)
	dependsOn(tasks.generateApolloSources)
}