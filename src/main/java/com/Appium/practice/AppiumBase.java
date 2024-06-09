package com.Appium.practice;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class AppiumBase {
    static AppiumDriverLocalService server;

    private static void setInstance(){
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withAppiumJS(new File("C:\\Users\\Rames\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .usingDriverExecutable(new File("C:/Program Files/nodejs/node"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withArgument (GeneralServerFlag.LOG_LEVEL, "debug")
//                .withLogFile(new File("Appiumlog.txt"))
                .withArgument(GeneralServerFlag.BASEPATH, "wd/hub");

        server = AppiumDriverLocalService.buildService(builder);
    }


    private static AppiumDriverLocalService getInstance(){
        if(server == null){
            setInstance();
        }
        return server;
    }

    public static void start(){
        getInstance().start();
        System.out.println(server.getUrl());
        System.out.println(server.isRunning());
    }

    public static void stop(){
        if(server != null){
            getInstance().stop();
            System.out.println("Appium server stopped");
        }
    }
}
