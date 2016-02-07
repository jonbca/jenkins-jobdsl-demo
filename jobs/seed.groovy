job('seed') {
    scm {

    }

    triggers {
        scm 'H/5 * * * *'
    }

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