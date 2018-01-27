package site.fish119.adminss.domain.log;

public class Logging_event_exception {
    private Long event_id;
    private Long i;
    private String trace_line;

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public Long getI() {
        return i;
    }

    public void setI(Long i) {
        this.i = i;
    }

    public String getTrace_line() {
        return trace_line;
    }

    public void setTrace_line(String trace_line) {
        this.trace_line = trace_line;
    }
}
