package com.yasin;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;

public class DB {
    private static DatabaseClient client;

    private DB() { }

    public static DatabaseClient getInstance() {
        if (client == null) {
            client = DatabaseClientFactory.newClient(
                    "localhost",
                    8000,
                    "Documents",
                    new DatabaseClientFactory.DigestAuthContext(
                            "admin",
                            "password"
                    )
            );
        }
        return client;
    }
}
