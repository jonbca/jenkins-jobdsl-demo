package utilities

class SomeUtilities {
    static void integrationJob(job, projectName) {
        job.with {
            description "${projectName}-integration"
        }
    }
}
