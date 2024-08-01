package org.api.doc.manag.system;

import org.api.doc.manag.system.exception.UnknownFileTypeException;
import org.api.doc.manag.system.importer.ImageImporter;
import org.api.doc.manag.system.importer.Importer;
import org.api.doc.manag.system.importer.LetterImporter;
import org.api.doc.manag.system.importer.ReportImporter;
import org.api.doc.manag.system.pojo.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;

public class DocumentManagementSystem {
    private final List<Document> documents = new ArrayList<>();
    private final List<Document> documentsView = unmodifiableList(documents);
    private final Map<String, Importer> extensionToImporter = new HashMap<>();

    public DocumentManagementSystem() {
        extensionToImporter.put("letter", new LetterImporter());
        extensionToImporter.put("report", new ReportImporter());
        extensionToImporter.put("jpg", new ImageImporter());
    }

    /**
     * Импорт файла в систему по пути к файлу
     */
    public void importFile(String path) throws IOException {
        final File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException(path);
        }

        final int separatorIndex = path.lastIndexOf('.');
        if (separatorIndex != -1) {
            if (separatorIndex == path.length()) {
                throw new UnknownFileTypeException("No extension found For file: " + path);
            }
            final String extension = path.substring(separatorIndex + 1);
            final Importer importer = extensionToImporter.get(extension);
            if (importer == null) {
                throw new UnknownFileTypeException("For file: " + path);
            }

            final Document document = importer.importFile(file);
            documents.add(document);
        } else {
            throw new UnknownFileTypeException("No extension found For file: " + path);
        }
    }

    /**
     * Возвращает список документов в системе
     */
    public List<Document> contents() {
        return documents;
    }

    /**
     * Интересный поиск в формате атрибут:значение ("patient:Joe,body:Diet Coke")
     */
    public List<Document> search(final String query) {
        return documents.stream()
                .filter(Query.parse(query))
                .collect(Collectors.toList());
    }
}
