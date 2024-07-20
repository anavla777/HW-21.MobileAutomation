# HW-21.MobileAutomation

For local start on emulator use the following command:
```shell
gradle clean test -DdeviceHost=emulation
```
For start on real device (be sure that device is connected to your PC) use the following command:
```shell
gradle clean test -DdeviceHost=real
```

For start on  BrowserStack side use the following command:
```shell
gradle clean test -DdeviceHost=browserstack
```
OR run without any arguments (if deviceHost is not specified test will be performed on BrowserStack side):
```shell
gradle clean test
```
