package com.redhat.demo;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeGreetingIT extends GreetingTest {

    // Execute the same tests but in native mode.
}