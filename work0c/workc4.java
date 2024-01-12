import java.io.*;

import javax.sound.sampled.AudioFormat.Encoding;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class workc4 {

    static StringBuffer sb=new StringBuffer();
    public static void main(String[] args)  throws Exception{
        //DOMを扱うための準備
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
 
        //XMLファイルの読み込み
        Document doc=db.parse(new FileInputStream("books.xml"));
 
        //rootを取得
        Element root=doc.getDocumentElement();

        sb.append("<html>");
        walk(root);
        sb.append("</html>");

       PrintWriter pw=new PrintWriter(new BufferedWriter(new PrintWriter("workc4.html")));
       pw.println(sb);
       pw.close();
    }
 
     public static void walk(Node n){
         //子がなくまで繰り返し
         for(Node ch=n.getFirstChild();ch!=null;ch=ch.getNextSibling()){
             if(ch.getNodeType()==Node.ELEMENT_NODE){
                if(ch.getNodeName().equals("book")){
                    sb.append("<div>");
                    walk(ch);
                    sb.append("</div>");
                }else if(ch.getNodeName().equals("title")){
                    sb.append("<h1>");
                    walk(ch);
                    sb.append("</h1>");
                }else if(ch.getNodeName().equals("author")){
                    sb.append("<h2>");
                    walk(ch);
                    sb.append("</h2>");
                }else if(ch.getNodeName().equals("price")){
                    sb.append("<p>");
                    walk(ch);
                    sb.append("</p>");
                    NamedNodeMap attrlist=ch.getAttributes();
                    Node attr=attrlist.getNamedItem("publisher");
                    sb.append("<p>");
                    sb.append(attr.getNodeValue());
                    sb.append("</p>");
                }
             }else if(ch.getNodeType()==Node.TEXT_NODE && ch.getNodeValue().trim().length()!=0){
                sb.append(ch.getNodeValue());
             }
             
         }
     }
    
}