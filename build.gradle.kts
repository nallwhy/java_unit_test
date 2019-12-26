/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn how to create Gradle builds at https://guides.gradle.org/creating-new-gradle-builds
 */

plugins {
  java
}

sourceSets {
  main {
    java {
      srcDir("src/maytree")
    }
  }

  test {
    java {
      srcDir("test/maytree")
    }
  }
}

repositories {
  jcenter()
}

dependencies {
  testImplementation("junit:junit:4.12")
}

tasks.test {
  useJUnit()
}
