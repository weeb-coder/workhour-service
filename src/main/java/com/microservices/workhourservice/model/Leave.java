package com.microservices.workhourservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Leave.LeaveBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Leave {
    private int yearMonth;
    private int count;

    public Leave() {}

    public Leave(LeaveBuilder builder) {
        this.yearMonth = builder.yearMonth;
        this.count = builder.count;
    }

    public int getYearMonth() {
        return yearMonth;
    }

    public int getCount() {
        return count;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class LeaveBuilder {
        protected int yearMonth;
        protected int count;

        public LeaveBuilder setYearMonth(int yearMonth) {
            this.yearMonth = yearMonth;
            return this;
        }

        public LeaveBuilder setCount(int count) {
            this.count = count;
            return this;
        }

        public Leave build() {
            return new Leave(this);
        }
    }
}
