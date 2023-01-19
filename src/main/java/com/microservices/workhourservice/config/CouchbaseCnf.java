package com.microservices.workhourservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseCnf extends AbstractCouchbaseConfiguration {

    @Autowired
    private Environment env;

//    @Value("{app.couchbase.connection-string}")
//    private String connectionString;
//
//    @Value("{app.couchbase.user-name}")
//    private String username;
//
//    @Value("{app.couchbase.password}")
//    private String password;
//
//    @Value("{app.couchbase.bucket-primary}")
//    private String employeeBucket;
//
//    @Value("{app.couchbase.bucket-user}")
//    private String employeeLeaveBucket;

    @Override
    public String getConnectionString() {
        return env.getProperty("app.couchbase.host");
    }

    @Override
    public String getUserName() {
        return env.getProperty("app.couchbase.username");
    }

    @Override
    public String getPassword() {
        return env.getProperty("app.couchbase.password");
    }

    @Override
    public String getBucketName() {
        return env.getProperty("app.couchbase.bucket-employeeLeave");
    }

}
