package org.api.doc.manag.system.importer;

import org.api.doc.manag.system.pojo.Document;

import java.io.File;
import java.io.IOException;

public interface Importer {

    Document importFile(File file) throws IOException;
}
