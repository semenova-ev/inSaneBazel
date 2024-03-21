package(default_visibility = ["//src/test/java/com/example:__pkg__"])

java_library(
    name = "sample",
    srcs = ["Sample.java"],
)

java_binary(
    name = "main",
    srcs = ["Main.java"],
    main_class = "com.example.Main",
    deps = [":sample"],
)
