package saisyuukadai;

import java.io.Serializable;

public class TerminalInput implements Serializable {

    private static final long serialVersionUID = 1L;

    String message;
    String content;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
