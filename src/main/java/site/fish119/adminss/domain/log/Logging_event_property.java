package site.fish119.adminss.domain.log;

import javax.persistence.*;

public class Logging_event_property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long event_id;
    private String mapped_key;
    private String mapped_value;

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public String getMapped_key() {
        return mapped_key;
    }

    public void setMapped_key(String mapped_key) {
        this.mapped_key = mapped_key;
    }

    public String getMapped_value() {
        return mapped_value;
    }

    public void setMapped_value(String mapped_value) {
        this.mapped_value = mapped_value;
    }
}
