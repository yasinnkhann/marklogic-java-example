package com.yasin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.JacksonHandle;

public class WriteJSON {
    public static void main(String[] args) {
        DatabaseClient db = DB.getInstance();

        JSONDocumentManager JSONDocMgr = db.newJSONDocumentManager();
//        BinaryDocumentManager binDocMgr = db.newBinaryDocumentManager();
//        XMLDocumentManager XMLDocMgr = db.newXMLDocumentManager();
//        TextDocumentManager TextDocMgr = db.newTextDocumentManager();

        // create a JSON object
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        json.put("message", "Greetings");

        // write the JSON object to the database
        String docId = "/example/greet.json";
        DocumentMetadataHandle metadata = new DocumentMetadataHandle().withCollections("example");
        JSONDocMgr.write(docId, metadata, new JacksonHandle(json));

        db.release();
    }
}
