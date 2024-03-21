package(default_visibility = ["//visibility:public"])
load("@aspect_bazel_lib//lib:run_binary.bzl", "run_binary")

java_library(
    name = "sample",
    srcs = ["Sample.java"],
)

java_library(
    name = "not_compiling",
    srcs = ["NotCompiling.java"],
)

run_binary(
    name = "infinite_loop",
    tool = "//src/binary:infinite_loop",
    outs = ["this_will_not_be_created"],
)
