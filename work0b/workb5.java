import java.io.*;

import javax.sound.sampled.AudioFormat.Encoding;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class workb5 {

    public static int flagPrice=0;
    public static int flagTitle=0;
    public static String temp;

    public static void main(String[] args)  throws Exception{
        //DOMを扱うための準備
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
 
        //XMLファイルの読み込み
        Document doc=db.parse(new FileInputStream("books.xml"));
 
        //rootを取得
        Element root=doc.getDocumentElement();
 
        walk(root);
    }
 
     public static void walk(Node n){
         //子がなくまで繰り返し
         for(Node ch=n.getFirstChild();ch!=null;ch=ch.getNextSibling()){
             
             //今のノードが要素の場合
             if(ch.getNodeType()==Node.ELEMENT_NODE){
                if(ch.getNodeName().equals("price")){
                    flagPrice=1;
                }else if(ch.getNodeName().equals("title")){
                    flagTitle=1;
                }
                 walk(ch);
             //そうでなく，テキストの場合
             }else if(ch.getNodeType()==Node.TEXT_NODE && ch.getNodeValue().trim().length()!=0 && (flagTitle==1 || flagPrice==1)){
                if(flagPrice==1){
                    int price=Integer.parseInt(ch.getNodeValue());
                    if(price<=3000){
                        System.out.println("The price of " +temp+" is less than 3000.");
                    }
                    flagPrice=0;
                }else if(flagTitle==1){
                    temp=ch.getNodeValue();
                    flagTitle=0;
                }
                
             }
 
         }
     }
}
