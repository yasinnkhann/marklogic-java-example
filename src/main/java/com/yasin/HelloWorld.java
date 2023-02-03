package com.yasin;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.TextDocumentManager;
import com.marklogic.client.io.StringHandle;

public class HelloWorld {
	public static void main(String[] args) {
		// Get the database client
		DatabaseClient client = DB.getInstance();

		// Make a document manager to work with text files.
		TextDocumentManager docMgr = client.newTextDocumentManager();

		// Define a URI value for a document.
		String docId = "/example/text.txt";

		// Create a handle to hold string content.
		StringHandle handle = new StringHandle();

		// Give the handle some content
		handle.set("Hello World!");

		// Write the document to the database with URI from docId
		// and content from handle
		docMgr.write(docId, handle);

		// release the client
		client.release();

	}
}




