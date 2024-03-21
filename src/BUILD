package(default_visibility = ["//visibility:public"])
load("@aspect_bazel_lib//lib:run_binary.bzl", "run_binary")


java_library(
    name = "sample",
    srcs = ["Sample.java"],
)

java_binary(
    name = "main",
    srcs = ["Main.java"],
    main_class = "Main",
    deps = [":sample"],
)

java_test(
    name = "sample_test",
    srcs = ["SampleTest.java"],
    test_class = "SampleTest",
    deps = [
        ":sample",
    ],
)

java_binary(
    name = "infinite_loop_binary",
    srcs = ["InfiniteLoop.java"],
    main_class = "InfiniteLoop",
)

run_binary(
    # The target name
    name = "infinite_loop",
    # The tool to run in the action
    tool = ":infinite_loop_binary",
    outs = ["this_will_not_be_created"],
)
