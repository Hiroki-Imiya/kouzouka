import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

class workc3{
    public static void main(String args[]) throws Exception{
        //DOMを扱うための準備
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
  
        //XMLファイルの読み込み
        Document doc=db.parse(new FileInputStream("books.xml"));
  
        //新しいものを宣言
        Document doc2=db.newDocument();
 
        Element root=doc2.createElement("本リスト");
        doc2.appendChild(root);
    
        String[]tmp=new String[10];

        NodeList lst=doc.getElementsByTagName("book");

        for(int i=0;i<lst.getLength();++i){
            Node n=lst.item(i);
            NamedNodeMap attrlist=n.getAttributes();
            tmp[i]=(attrlist.getNamedItem("isbn")).getNodeValue();
        }

        lst=doc.getElementsByTagName("title");

        for(int i=0;i<lst.getLength();++i){
            Node n=lst.item(i);
            for(Node ch=n.getFirstChild(); ch!=null; ch=ch.getNextSibling()){
                Element elm=doc2.createElement("名前");
                root.appendChild(elm);
                elm.setAttribute("isbn",tmp[i]);
                Text txt=doc2.createTextNode(ch.getNodeValue());
                elm.appendChild(txt);
            }
        }

        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT,"yes");
        tf.transform(new DOMSource(doc2),new StreamResult("workc3.xml"));
    }
}