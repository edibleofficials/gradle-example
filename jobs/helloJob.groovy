/**
 * Created by Juliano on 2/26/2017.
 */

String basePath = 'helloJob'


folder(basePath) {
    description 'This example shows how to create a maven job.'
}

mavenJob("$basePath/Training_BDD") {
    scm {
        github('TrainingSpace/Training_BDD', 'master')
    }
    triggers {
        githubPush()
    }
    rootPOM('pom.xml')
    goals('clean verify')
    publishers {
        cucumberReports {
            jsonReportPath('target')
        }

    }

}
