job('seed') {
    steps {
        gradle 'clean test'
        dsl {
            external 'jobs/**/*Jobs.groovy'
            additionalClasspath 'src/main/groovy'
        }
    }

    publishers {
        archiveJunit 'build/test-results/**/*.xml'
    }
}