plugins {
	application
    kotlin("jvm")
}

application {
	mainClassName = "Runner"
}

dependencies {
    compile(kotlin("stdlib"))
    compile(project(":common"))
	testCompile("org.junit.jupiter:junit-jupiter-api:5.3.2")
	testCompile("org.junit.jupiter:junit-jupiter-params:5.3.2")
	testRuntime("org.junit.jupiter:junit-jupiter-engine:5.3.2")
}

tasks.withType<Test> {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
}