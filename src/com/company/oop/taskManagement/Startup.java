package com.company.oop.taskManagement;

import com.company.oop.taskManagement.core.TaskManagerEngineImpl;
import com.company.oop.taskManagement.core.contracts.TaskManagerEngine;

public class Startup {
    public static void main(String[] args) {
        TaskManagerEngineImpl engine = new TaskManagerEngineImpl();
        engine.start();
    }

}
