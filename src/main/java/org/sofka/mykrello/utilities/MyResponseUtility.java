package org.sofka.mykrello.utilities;

import org.springframework.stereotype.Component;

@Component
public class MyResponseUtility {
    public Boolean error;
    public String message;

    public Object data;

    public MyResponseUtility() {
        error = false;
        message = "Success";
        data = null;
    }

    public void restart() {
        error = false;
        message = "Success";
        data = null;
    }

    public void newResponse (Boolean error, String message, Object data){
        this.data = data;
        this.error = error;
        this.message = message;
    }
}
