import java.io.*;

import javax.sound.sampled.AudioFormat.Encoding;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class workc2 {
    public static int c=1;
    public static void main(String[] args)  throws Exception{
        //DOMを扱うための準備
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
 
        //XMLファイルの読み込み
        Document doc=db.parse(new FileInputStream("books.xml"));
 
        //rootを取得
        Element root=doc.getDocumentElement();
 
        walk(root);

        TransformerFactory tff=TransformerFactory.newInstance();
        Transformer tf=tff.newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.transform(new DOMSource(doc), new StreamResult("workc2.xml"));
    }
 
     public static void walk(Node n){
         //子がなくまで繰り返し
         for(Node ch=n.getFirstChild();ch!=null;ch=ch.getNextSibling()){
             if(ch.getNodeType()==Node.ELEMENT_NODE){
                if(ch.getNodeName().equals("book")){
                    NamedNodeMap attrmap=ch.getAttributes();
                    attrmap.removeNamedItem("isbn");
                    Document doc =ch.getOwnerDocument();
                    Element elm=doc.createElement("img");
                    elm.setAttribute("src", "img"+(c++)+".jpg");
                    ch.appendChild(elm);
                }
                walk(ch);
             }
             
         }
     }
    
}