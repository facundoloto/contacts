package com.demo.contacts.Handled;

/*
this class works for the app will has a better form to throw exepetion
 */
public class HandledException extends Exception {
        private String code;

        public HandledException(String code, String message) {
            super(message);
            this.setCode(code);
        }

        public HandledException(String code, String message, Throwable cause) {
            super(message, cause);
            this.setCode(code);
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

