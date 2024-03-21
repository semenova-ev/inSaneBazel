In this template:
- The `sample` target in `src/main/java/com/example/BUILD` is a buildable Java library.
- The `main` target in `src/main/java/com/example/BUILD` is a runnable Java binary that depends on the `sample` library.
- The `sample_test` target in `src/test/java/com/example/BUILD` is a testable Java test that tests the `sample` library.

You can build, run, and test the targets using the following Bazel commands:

```bash
# Build the sample library
bazel build //src/main/java/com/example:sample

# Run the main binary
bazel run //src/main/java/com/example:main

# Run the tests
bazel test //src/test/java/com/example:sample_test
```
