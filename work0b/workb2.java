import java.io.*;

import javax.sound.sampled.AudioFormat.Encoding;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;


public class workb2 {
    public static void main(String[] args) throws Exception{
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
        int cntElm=0;
        int cntTxt=0;

        //子がなくまで繰り返し
        for(Node ch=n.getFirstChild();ch!=null;ch=ch.getNextSibling()){
            
            //今のノードが要素の場合
            if(ch.getNodeType()==Node.ELEMENT_NODE){
                cntElm++;

            //そうでなく，テキストの場合
            }else if(ch.getNodeType()==Node.TEXT_NODE ){
                cntTxt++;
            }

        }

        System.out.println("Number of tag:"+cntElm);
        System.out.println("Number of text:" + cntTxt);
    }
}
