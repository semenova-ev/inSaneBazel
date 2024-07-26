package(default_visibility = ["//visibility:public"])
load("@aspect_bazel_lib//lib:run_binary.bzl", "run_binary")
load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "build_use_generated_code_kotlin",
    srcs = [
        "UseGeneratedCodeKotlin.kt",
        ":build_generate_code_1",
        ":build_generate_code_2",
    ]
)

java_library(
    name = "build_compiling",
    srcs = ["Sample.java"],
)

# java_library(
#     name = "build_not_compiling",
#     srcs = ["NotCompiling.java"],
# )

java_library(
    name = "build_uses_generated_code",
    srcs = [
        "UsesGeneratedCode.java",
        ":build_generate_code_1",
        ":build_generate_code_2",
    ]
)

genrule(
    name = "build_generate_code_1",
    srcs = [":will_be_used_for_generation_1.txt"],
    outs = ["Generated1.java"],
    cmd = "cat $(location //src/build:will_be_used_for_generation_1.txt) > $@",
)

genrule(
    name = "build_generate_code_2",
    srcs = [":will_be_used_for_generation_2.txt"],
    outs = ["Generated2.java"],
    cmd = "cat $(location //src/build:will_be_used_for_generation_2.txt) > $@",
)

run_binary(
    name = "build_infinite_loop",
    tool = "//src/binary:run_infinite_loop",
    outs = ["this_will_not_be_created"],
    tags = ["manual"],
)
