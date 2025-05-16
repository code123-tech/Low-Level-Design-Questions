package Questions.Word_Processor;

import Questions.Word_Processor.enums.AlignmentType;
import Questions.Word_Processor.models.Document;
import Questions.Word_Processor.models.DocumentManager;
import Questions.Word_Processor.models.Formatting;

public class WordProcessorDemo {

    public static void main(String[] args) {
        
        DocumentManager docManager = new DocumentManager();
        Editor editor = new Editor(docManager);

        // Create two documents
        System.out.println("Creating Document 1...");
        Document doc1 = docManager.createDocument("Document 1");
        System.out.println("Document 1: " + doc1);

        System.out.println("\nCreating Document 2...");
        Document doc2 = docManager.createDocument("Document 2");
        System.out.println("Document 2: " + doc2);


        // Insert text into Document 1
        System.out.println("\nSwitching to Document 1...");
        editor.switchDocument(doc1.id);
        Formatting normal = new Formatting(false, false, 12, "Arial", AlignmentType.LEFT);
        editor.insertText("Hello", 0, normal);
        System.out.println("Inserted 'Hello' into Document 1: " + doc1);

        // Apply formatting (bold) to Document 1
        Formatting bold = new Formatting(true, false, 12, "Arial", AlignmentType.RIGHT);
        editor.applyFormatting(bold, 0, 1);
        System.out.println("Applied bold to 'Hello' in Document 1: " + doc1);

        // Undo the formatting
        System.out.println("\nUndoing formatting in Document 1...");
        editor.undo();
        System.out.println("After undo: " + doc1);

        // Redo the formatting
        System.out.println("\nRedoing formatting in Document 1...");
        editor.redo();
        System.out.println("After redo: " + doc1);


        // Switch to Document 2 and insert text
        System.out.println("\nSwitching to Document 2...");
        editor.switchDocument(doc2.id);
        editor.insertText("World", 0, normal);
        System.out.println("Inserted 'World' into Document 2: " + doc2);

        // Save all documents
        System.out.println("\nSaving all documents...");
        docManager.saveAllDocuments();
    }

    
    

}
