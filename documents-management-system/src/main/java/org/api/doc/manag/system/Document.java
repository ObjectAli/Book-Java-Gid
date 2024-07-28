package org.api.doc.manag.system;

import java.util.Map;

public class Document {

    private final Map<String, String> attributes;

    Document(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttributes(final String attributeName) {
        return attributes.get(attributeName);
    }
}