plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":common"))
    implementation("com.google.guava:guava:31.0.1-jre")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.2")
	testImplementation("org.junit.jupiter:junit-jupiter-params:5.3.2")
	testImplementation("org.junit.jupiter:junit-jupiter-engine:5.3.2")
}

tasks.withType<Test> {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
}