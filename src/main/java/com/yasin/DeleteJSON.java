package com.yasin;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.JSONDocumentManager;

public class DeleteJSON {
    public static void main(String[] args) {
        DatabaseClient db = DB.getInstance();

        JSONDocumentManager docMgr = db.newJSONDocumentManager();
        String docId = "/example/greet.json";
        docMgr.delete(docId);

        db.release();
    }
}
