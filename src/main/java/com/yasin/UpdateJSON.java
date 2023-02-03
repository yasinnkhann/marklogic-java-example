package com.yasin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.JacksonHandle;

public class UpdateJSON {
    public static void main(String[] args) {
        DatabaseClient db = DB.getInstance();

    // create a JSON document manager
        JSONDocumentManager docMgr = db.newJSONDocumentManager();

    // read the JSON document from the database
        String docId = "/example/greet.json";
        JacksonHandle handle = new JacksonHandle();
        docMgr.read(docId, handle);

    // update the JSON data
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode newJson = mapper.createObjectNode();
        newJson.put("message", "Greetings, again!!!");

    // write the updated JSON object to the database
        docMgr.write(docId, new JacksonHandle(newJson));
        db.release();
    }
}
