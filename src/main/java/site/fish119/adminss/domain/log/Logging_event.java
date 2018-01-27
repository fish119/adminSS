package site.fish119.adminss.domain.log;

import javax.persistence.*;

@Entity()
@Table(name = "logging_event")
public class Logging_event {
    private Long timestmp;
    private String formatted_message;
    private String logger_name;
    private String level_string;
    private String thread_name;
    private Long reference_flag;
    private String arg0;
    private String arg1;
    private String arg2;
    private String arg3;
    private String caller_filename;
    private String caller_class;
    private String caller_method;
    private String caller_line;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long event_id;

    public Long getTimestmp() {
        return timestmp;
    }

    public void setTimestmp(Long timestmp) {
        this.timestmp = timestmp;
    }

    public String getFormatted_message() {
        return formatted_message;
    }

    public void setFormatted_message(String formatted_message) {
        this.formatted_message = formatted_message;
    }

    public String getLogger_name() {
        return logger_name;
    }

    public void setLogger_name(String logger_name) {
        this.logger_name = logger_name;
    }

    public String getLevel_string() {
        return level_string;
    }

    public void setLevel_string(String level_string) {
        this.level_string = level_string;
    }

    public String getThread_name() {
        return thread_name;
    }

    public void setThread_name(String thread_name) {
        this.thread_name = thread_name;
    }

    public Long getReference_flag() {
        return reference_flag;
    }

    public void setReference_flag(Long reference_flag) {
        this.reference_flag = reference_flag;
    }

    public String getArg0() {
        return arg0;
    }

    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public String getArg3() {
        return arg3;
    }

    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }

    public String getCaller_filename() {
        return caller_filename;
    }

    public void setCaller_filename(String caller_filename) {
        this.caller_filename = caller_filename;
    }

    public String getCaller_class() {
        return caller_class;
    }

    public void setCaller_class(String caller_class) {
        this.caller_class = caller_class;
    }

    public String getCaller_method() {
        return caller_method;
    }

    public void setCaller_method(String caller_method) {
        this.caller_method = caller_method;
    }

    public String getCaller_line() {
        return caller_line;
    }

    public void setCaller_line(String caller_line) {
        this.caller_line = caller_line;
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }
}
