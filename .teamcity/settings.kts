import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.pullRequests
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.projectFeatures.spaceConnection
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2024.03"

project {

    vcsRoot(intellijBspSpace)

    buildType(MirrorRepoFlowMrPr)
    buildType(TestReports)

    features {
        spaceConnection {
            id = "PROJECT_EXT_4"
            displayName = "JetBrains Space"
            serverUrl = "https://jetbrains.team"
            clientId = "ecea31a8-684e-4e2a-8572-f923af59ca5d"
            clientSecret = "credentialsJSON:0c5f7b50-7bdb-4b2a-9764-120472be67b1"
        }
        spaceConnection {
            id = "PROJECT_EXT_5"
            displayName = "Project BAZEL"
            serverUrl = "https://jetbrains.team"
            clientId = "5bae7228-9797-453a-bd02-d0e8e0345c25"
            clientSecret = "credentialsJSON:7477ff8b-afc5-4db7-9161-d3c391c2071a"
        }
        spaceConnection {
            id = "PROJECT_EXT_6"
            displayName = "JetBrains Space (1)"
            serverUrl = "https://jetbrains.team"
            clientId = "75aa681e-fd33-46f7-992d-34da033b8a35"
            clientSecret = "credentialsJSON:76f1807d-cbdd-447e-bb91-9ddec6509ba4"
        }
    }
}

object MirrorRepoFlowMrPr : BuildType({
    name = "mirror-repo-flow-mr-pr"

    type = BuildTypeSettings.Type.COMPOSITE

    vcs {
        root(intellijBspSpace)

        showDependenciesChanges = true
    }

    triggers {
        vcs {
            branchFilter = """
                -:<default>
                +:*
            """.trimIndent()
        }
    }

    features {
        pullRequests {
            enabled = false
            vcsRootExtId = "${intellijBspSpace.id}"
            provider = jetbrainsSpace {
                authType = connection {
                    connectionId = "PROJECT_EXT_5"
                }
            }
        }
        commitStatusPublisher {
            vcsRootExtId = "${intellijBspSpace.id}"
            publisher = space {
                authType = connection {
                    connectionId = "PROJECT_EXT_5"
                }
                displayName = "BazelTeamCityCloud"
            }
        }
    }

    dependencies {
        snapshot(TestReports) {
            onDependencyCancel = FailureAction.IGNORE
        }
    }
})

object TestReports : BuildType({
    name = "[test] reports"

    vcs {
        root(intellijBspSpace)
    }

    steps {
        script {
            name = "test"
            id = "test"
            scriptContent = """
                pwd
                cd ..
                ls -la
            """.trimIndent()
        }
    }

    features {
        commitStatusPublisher {
            vcsRootExtId = "${intellijBspSpace.id}"
            publisher = space {
                authType = connection {
                    connectionId = "PROJECT_EXT_5"
                }
                displayName = "BazelTeamCityCloud"
            }
        }
        pullRequests {
            enabled = false
            vcsRootExtId = "${intellijBspSpace.id}"
            provider = jetbrainsSpace {
                authType = connection {
                    connectionId = "PROJECT_EXT_5"
                }
            }
        }
    }
})

object intellijBspSpace : GitVcsRoot({
    name = "intellij-bsp-space-test"
    url = "https://git.jetbrains.team/bazel/intellij-bsp.git"
    branch = "refs/heads/main"
    branchSpec = "+:*"
    authMethod = token {
        userName = "x-oauth-basic"
        tokenId = "tc_token_id:CID_ac3a89d197637e484363e81dc1e184a9:-1:c2e949f9-aeb3-4ad5-8854-8b4174d7456c"
    }
})
