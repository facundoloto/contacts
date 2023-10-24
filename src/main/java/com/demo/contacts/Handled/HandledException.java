package com.demo.contacts.Handled;

/*
this class works for the app will has a better form to throw exepetion
 */
public class HandledException extends Exception {
    private final HandledErrorDataBase exeptionDataBase;

    public HandledException(HandledErrorDataBase exeptionDataBase) {
        this.exeptionDataBase = exeptionDataBase;
    }

    public HandledErrorDataBase getException() {

        return exeptionDataBase;
    }
}

