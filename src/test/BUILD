package(default_visibility = ["//visibility:public"])

java_test(
    name = "sample",
    srcs = ["SampleTest.java"],
    test_class = "test.SampleTest",
    deps = [
        "//src/build:sample",
    ],
)

java_test(
    name = "failing",
    srcs = ["FailingTest.java"],
    test_class = "test.FailingTest",
    deps = [
        "//src/build:sample",
    ],
)

java_test(
    name = "infinite_loop",
    srcs = ["InfiniteTest.java"],
    test_class = "test.InfiniteTest",
)
