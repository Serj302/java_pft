package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

 @Test

  public void testArea(){
    Square s = new Square(5);
      Assert.assertEquals(s.area(), 24.0);
  }

}

Лог |--------------------

        Testing started at 15:29 ...
        > Task :compileJava UP-TO-DATE
        > Task :processResources NO-SOURCE
        > Task :classes UP-TO-DATE
        > Task :compileTestJava UP-TO-DATE
        > Task :processTestResources NO-SOURCE
        > Task :testClasses UP-TO-DATE

        > Task :test







        expected [24.0] but found [25.0]
        java.lang.AssertionError: expected [24.0] but found [25.0]
        at org.testng.Assert.fail(Assert.java:96)
        at org.testng.Assert.failNotEquals(Assert.java:776)
        at org.testng.Assert.assertEqualsImpl(Assert.java:137)
        at org.testng.Assert.assertEquals(Assert.java:118)
        at org.testng.Assert.assertEquals(Assert.java:442)
        at ru.stqa.pft.sandbox.SquareTests.testArea(SquareTests.java:12)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:124)
        at org.testng.internal.Invoker.invokeMethod(Invoker.java:583)
        at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:719)
        at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:989)
        at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:125)
        at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:109)
        at org.testng.TestRunner.privateRun(TestRunner.java:648)
        at org.testng.TestRunner.run(TestRunner.java:505)
        at org.testng.SuiteRunner.runTest(SuiteRunner.java:455)
        at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:450)
        at org.testng.SuiteRunner.privateRun(SuiteRunner.java:415)
        at org.testng.SuiteRunner.run(SuiteRunner.java:364)
        at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
        at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:84)
        at org.testng.TestNG.runSuitesSequentially(TestNG.java:1208)
        at org.testng.TestNG.runSuitesLocally(TestNG.java:1137)
        at org.testng.TestNG.runSuites(TestNG.java:1049)
        at org.testng.TestNG.run(TestNG.java:1017)
        at org.gradle.api.internal.tasks.testing.testng.TestNGTestClassProcessor.runTests(TestNGTestClassProcessor.java:141)
        at org.gradle.api.internal.tasks.testing.testng.TestNGTestClassProcessor.stop(TestNGTestClassProcessor.java:90)
        at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.stop(SuiteTestClassProcessor.java:61)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36)
        at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
        at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:33)
        at org.gradle.internal.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:94)
        at com.sun.proxy.$Proxy2.stop(Unknown Source)
        at org.gradle.api.internal.tasks.testing.worker.TestWorker.stop(TestWorker.java:132)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36)
        at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
        at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:182)
        at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:164)
        at org.gradle.internal.remote.internal.hub.MessageHub$Handler.run(MessageHub.java:412)
        at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
        at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:48)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
        at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:56)
        at java.lang.Thread.run(Thread.java:748)




        Gradle suite > Gradle test > ru.stqa.pft.sandbox.SquareTests > testArea FAILED
        java.lang.AssertionError at SquareTests.java:12






        1 test completed, 1 failed

        > Task :test FAILED

        FAILURE: Build failed with an exception.

        * What went wrong:
        Execution failed for task ':test'.
        > There were failing tests. See the report at: file:///C:/repository/java_pft/sandbox/build/reports/tests/test/index.html

        * Try:
        Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.

        * Get more help at https://help.gradle.org

        BUILD FAILED in 7s
        3 actionable tasks: 1 executed, 2 up-to-date

