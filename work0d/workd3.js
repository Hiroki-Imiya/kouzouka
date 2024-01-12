$(function(){
    
    //ボタンクリックイベント
    $("#btn").on("click",getData);

    //Ajaxを実行するユーザ定義関数
    function getData(){

        //ターゲットとなるファイルのURL
        var target_url='books.xml';

        //Ajax通信を開始する
        $.ajax({
            type:"GET", 
            dataType:"xml", //受信データ形式
            url:target_url
        }).fail(function(jqXHR,textStatus,errorThrown){
            //通信失敗時の処理
            alert('失敗');
        }).done(function(data,textStatus,jqXHR){
            //通信成功時の処理
            alert('成功');

            //取得したデータの中身を確認
            console.log(data);

            //xmlのbook要素からタイトルと著者を取得
            $(data).find("books book").each(function(index,item){

                //タイトルと著者と価格と出版社とisbnを取得
                var title=$(item).find('title').text();
                var author=$(item).find('author').text();
                var price=$(item).find('price').text();
                var publisher=$(item).find('price').attr('publisher');
                var isbn=$(item).attr('isbn');

                var xmlSource = '<tr><td>'+title+'</td>';
                xmlSource += '<td>'+author+'</td>';
                xmlSource += '<td>'+price+'</td>';
                xmlSource += '<td>'+publisher+'</td>';
                xmlSource += '<td>'+isbn+'</td></tr>';

                //取得したデータを出力
                $("tbody").append(xmlSource);
            });

        });
    }    
});