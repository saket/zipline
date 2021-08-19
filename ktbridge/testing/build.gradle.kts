import org.jetbrains.kotlin.gradle.plugin.PLUGIN_CLASSPATH_CONFIGURATION_NAME

plugins {
  kotlin("multiplatform")
}

kotlin {
  jvm()

  js {
    browser {
    }
    binaries.executable()
  }

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(project(":ktbridge"))
      }
    }
    val jvmMain by getting {
      dependencies {
        implementation(project(":quickjs:jvm"))
      }
    }
  }
}

dependencies {
  add(PLUGIN_CLASSPATH_CONFIGURATION_NAME, project(":ktbridge:plugin"))
}