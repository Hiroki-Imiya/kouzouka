import java.io.*;

import javax.sound.sampled.AudioFormat.Encoding;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class workb1 {
    public static void main(String[] args) throws Exception{

        //DOMを扱うための準備
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();

        //xmlファイルの宣言
        Document doc=db.newDocument();

        //ルート要素のの宣言
        Element root=doc.createElement("musics");


        doc.appendChild(root);

        for(int i=0;i<3;++i){
            //子ノードの宣言
            Element elm=doc.createElement("music");
            root.appendChild(elm);
        }
        
        //xmlファイルの出力
        TransformerFactory tff=TransformerFactory.newInstance();
        Transformer tf=tff.newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.transform(new DOMSource(doc), new StreamResult("workb1.xml"));
    }
    
}