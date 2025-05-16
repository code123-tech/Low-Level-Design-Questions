package Questions.Word_Processor.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DocumentManager {

    List<Document> documents;
    Document activeDocument;

    public DocumentManager() {
        this.documents = new ArrayList<>();
        this.activeDocument = null;
    }

    public Document createDocument(String title) {
        String id = UUID.randomUUID().toString();
        Document doc = new Document(id, title);
        documents.add(doc);
        activeDocument = doc;
        return doc;
    }

    public Document openDocument(String id){
        Document doc = getDocumentById(id);
        if (doc != null) {
            doc.load();
            activeDocument = doc;
        }
        return doc;
    }

    public void switchToDocument(String id) {
        Document doc = getDocumentById(id);
        if (doc != null) {
            activeDocument = doc;
        }
    }

    public void closeDocument(String id) {
        Document doc = getDocumentById(id);
        if (doc != null) {
            documents.remove(doc);
            if (activeDocument == doc) {
                activeDocument = documents.isEmpty() ? null : documents.get(0);
            }
        }
    }

    public void saveAllDocuments() {
        for (Document doc : documents) {
            doc.save();
        }
    }

    public Document getDocumentById(String id) {
        return documents.stream()
                       .filter(doc -> doc.id.equals(id))
                       .findFirst()
                       .orElse(null);
    }

    public Document getActiveDocument() {
        return activeDocument;
    }

}
