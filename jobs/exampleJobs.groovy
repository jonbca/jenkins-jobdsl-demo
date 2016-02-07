mavenJob ('test-job') {
    mavenInstallation('maven-3.3.9')

    scm {
        git 'https://github.com/google/guava.git'
    }

    goals('clean install -DskipTests')
}