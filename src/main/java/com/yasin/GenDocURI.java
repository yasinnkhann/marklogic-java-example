package com.yasin;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.DocumentDescriptor;
import com.marklogic.client.document.DocumentUriTemplate;
import com.marklogic.client.io.InputStreamHandle;
import com.marklogic.client.document.JSONDocumentManager;

import java.io.File;
import java.io.FileInputStream;

public class GenDocURI {
    public static void main(String[] args) {
        DatabaseClient client = DB.getInstance();
        JSONDocumentManager JSONDocMgr = client.newJSONDocumentManager();
        DocumentUriTemplate templateJSON = JSONDocMgr.newDocumentUriTemplate("json");
        templateJSON.setDirectory("/my/docs/");
        FileInputStream docStream =
                new FileInputStream("data" + File.separator + filename);
        InputStreamHandle handle = new InputStreamHandle(docStream);
        DocumentDescriptor descJSON = JSONDocMgr.create(templateJSON,handle);
        client.release();
    }
}
