import java.io.*;

import javax.sound.sampled.AudioFormat.Encoding;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class workb4 {

    public static int flag=0;
    public static int high_price_count=0;
    
    public static void main(String[] args)  throws Exception{
        //DOMを扱うための準備
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
 
        //XMLファイルの読み込み
        Document doc=db.parse(new FileInputStream("books.xml"));
 
        //rootを取得
        Element root=doc.getDocumentElement();
 
        walk(root);
        System.out.println("There are "+high_price_count+" texts whose price is greater than 3000."); 
     }
 
     public static void walk(Node n){
         //子がなくまで繰り返し
         for(Node ch=n.getFirstChild();ch!=null;ch=ch.getNextSibling()){
             
             //今のノードが要素の場合
             if(ch.getNodeType()==Node.ELEMENT_NODE){
                if(ch.getNodeName().equals("price")){
                    flag=1;
                }
                 walk(ch);
             //そうでなく，テキストの場合
             }else if(ch.getNodeType()==Node.TEXT_NODE && ch.getNodeValue().trim().length()!=0 && flag==1){
                 int price=Integer.parseInt(ch.getNodeValue());
                 System.out.println(price);
                 if(price>3000){
                    high_price_count++;
                 }
                 flag=0;
             }
 
         }
     }
}
