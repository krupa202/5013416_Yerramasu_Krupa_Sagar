package factoryMethodPatternExample;

public abstract class DocumentFactory {
	 public abstract Document createDocument();
}
//WordDocumentFactory.java
class WordDocumentFactory extends DocumentFactory {
 @Override
 public Document createDocument() {
     return new WordDocument();
 }
}

//PdfDocumentFactory.java
 class PdfDocumentFactory extends DocumentFactory {
 @Override
 public Document createDocument() {
     return new PdfDocument();
 }
}

//ExcelDocumentFactory.java
 class ExcelDocumentFactory extends DocumentFactory {
 @Override
 public Document createDocument() {
     return new ExcelDocument();
 }
}
