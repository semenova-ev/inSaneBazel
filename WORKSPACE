workspace(name = "example_project")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "rules_jvm_external",
    sha256 = "f36441aa876c4f6427bfb2d1f2d723b48e9d930b62662bf723ddfb8fc80f0140",
    strip_prefix = "rules_jvm_external-4.5",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/4.5.zip",
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "junit:junit:4.13.2",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)