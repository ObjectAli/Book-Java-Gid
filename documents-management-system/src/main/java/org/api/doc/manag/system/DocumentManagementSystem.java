package org.api.doc.manag.system;

import java.util.List;

public interface DocumentManagementSystem {

    /**
     * Импорт файла в систему по пути к файлу
     */
    void importFile(String path);

    /**
     * Возвращает список документов в системе
     */
    List<Document> contents();
}
