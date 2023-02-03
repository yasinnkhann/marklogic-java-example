package com.yasin;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.DocumentPatchBuilder;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.marker.DocumentPatchHandle;

public class UpdateJSON {
    public static void main(String[] args) {
        DatabaseClient db = DB.getInstance();

        // create a JSON document manager
        JSONDocumentManager JSONDocMgr = db.newJSONDocumentManager();

        // create a document patch builder
        DocumentPatchBuilder jsonPatchBldr = JSONDocMgr.newPatchBuilder();

        // build a patch to update the "message" field
        DocumentPatchHandle jsonPatch = jsonPatchBldr
                .replaceValue("/message", "Greetings, again!")
                .build();

        // apply the patch to the document
        String docId = "/example/greet.json";
        JSONDocMgr.patch(docId, jsonPatch);

        db.release();
    }
}
