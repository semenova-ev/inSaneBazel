package(default_visibility = ["//visibility:public"])
load("@aspect_bazel_lib//lib:run_binary.bzl", "run_binary")

java_library(
    name = "build_compiling",
    srcs = ["Sample.java"],
)

java_library(
    name = "build_not_compiling",
    srcs = ["NotCompiling.java"],
)

run_binary(
    name = "build_infinite_loop",
    tool = "//src/binary:run_infinite_loop",
    outs = ["this_will_not_be_created"],
)
