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

java_library(
    name = "build_uses_generated_code",
    srcs = ["UsesGeneratedCode.java", ":build_generate_code"],
)

genrule(
    name = "build_generate_code",
    srcs = [":will_be_used_for_generation.txt"],
    outs = ["Generated.java"],
    cmd = "cat $(location //src/build:will_be_used_for_generation.txt) > $@",
)

run_binary(
    name = "build_infinite_loop",
    tool = "//src/binary:run_infinite_loop",
    outs = ["this_will_not_be_created"],
    tags = ["manual"],
)
