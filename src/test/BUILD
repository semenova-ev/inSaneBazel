package(default_visibility = ["//visibility:public"])

java_test(
    name = "test_passing",
    srcs = ["SampleTest.java"],
    test_class = "test.SampleTest",
    deps = [
        "//src/build:sample",
    ],
)

java_test(
    name = "test_failing",
    srcs = ["FailingTest.java"],
    test_class = "test.FailingTest",
    deps = [
        "//src/build:sample",
    ],
)

java_test(
    name = "test_infinite_loop",
    srcs = ["InfiniteTest.java"],
    test_class = "test.InfiniteTest",
)
