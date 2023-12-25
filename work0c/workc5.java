import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

class workc5{
    static StringBuffer sb=new StringBuffer();
    public static void main(String args[]) throws Exception{
        //DOMを扱うための準備
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
  
        //新しいルートの作成
        Document doc=db.newDocument();

        Element root=doc.createElement("MusicList");
        doc.appendChild(root);

        //csvファイルの読み込み
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("musics.csv"),"Shift-JIS"));

        //タイトルの読み込み
        Vector<String> colname=new Vector<String>();
        String line=br.readLine();
        StringTokenizer stt =new StringTokenizer(line,",");
        while (stt.hasMoreTokens()) {
            colname.addElement(stt.nextToken());
        }

        //2行目以降の読み取り
        while ((line=br.readLine())!=null) {
            StringTokenizer std=new StringTokenizer(line,",");
            Element music=doc.createElement("Music");
            root.appendChild(music);

            for(int i=0;i<colname.size();++i){
                Element elm=doc.createElement((String)colname.elementAt(i));
                Text txt=doc.createTextNode(std.nextToken());
                elm.appendChild(txt);
                music.appendChild(elm);
            }
        }

        br.close();
  
        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT,"yes");
        tf.transform(new DOMSource(doc),new StreamResult("workc5.xml"));
    }
}