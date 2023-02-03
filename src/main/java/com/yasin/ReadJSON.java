package com.yasin;

import com.fasterxml.jackson.databind.JsonNode;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.JacksonHandle;

public class ReadJSON {
    public static void main(String[] args) {
        DatabaseClient db = DB.getInstance();

        // create a JSON document manager
        JSONDocumentManager docMgr = db.newJSONDocumentManager();

        // read the JSON document from the database
        String docId = "/example/greet.json";
        JacksonHandle handle = new JacksonHandle();
        docMgr.read(docId, handle);

        // get the JSON object from the handle
        JsonNode json = handle.get();

        // access the JSON data
        String message = json.get("message").asText();
        System.out.println(message);

        db.release();
    }
}
