You can build, run, and test the targets using the following Bazel commands:

```bash
# A library that build successfully
bazel build //src/build:sample

# A library that fails to build
bazel bazel //src/build:not_compiling

# A target that takes infinitely long time to build
bazel build //src/build:infinite_loop

# A binary that runs successfully
bazel run //src/binary:sample

# A binary that takes infinitely long time to run
bazel run //src/binary:infinite_loop

# A test that runs successfully
bazel test //src/test:sample

# A test that fails
bazel test //src/test:failing

# A test that takes infinitely long time to run
bazel test //src/test:infinite_loop
```
