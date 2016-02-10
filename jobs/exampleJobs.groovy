import utilities.SomeUtilities

// A simple build job
mavenJob ('test-job') {
    mavenInstallation('maven-3.3.9')

    scm {
        git 'https://github.com/google/guava.git'
    }

    triggers {
        cron('@daily')
    }

    goals('clean install -DskipTests')
}












// Multiple build jobs with parameters
['some-repo-m', 'another-repo-m', 'yet-another-repo-m'].each {
    job("${it}-build") {
        wrappers {
            environmentVariables(
                    SOME_VARIABLE: 'someValue',
                    ANOTHER_VARIABLE: 'another-value'
            )
        }

        scm {
            git "https://foo.com/some-group/${it}.git"
        }

        steps {
            gradle('clean build')
        }
    }
}

//
//
//
//
//
//
//
//
//
//
//
//
//// Factor out URL generation
//Closure myGit(projectName) {
//    return {
//        git {
//            remote {
//                url "https://foo.com/some-group/${projectName}"
//                credentials '30541887-abf1-4788-b071-d7c801f2beb5'
//            }
//        }
//    }
//}
//
//['some-repo', 'another-repo', 'yet-another-repo'].each {
//    job("${it}-build-with-git-function") {
//        wrappers {
//            environmentVariables(
//                    SOME_VARIABLE: 'someValue',
//                    ANOTHER_VARIABLE: 'another-value'
//            )
//        }
//
//        scm myGit(it)
//
//        steps {
//            gradle('clean build')
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//// Add stuff to a job
//def myJob = job('my-job-integration')
//SomeUtilities.integrationJob(myJob, '')
//
//
//// Create a view
//listView('integration-jobs') {
//    description('All integration jobs')
//
//    jobs {
//        names('my-job-integration', 'some-repo', 'test-job')
//    }
//}