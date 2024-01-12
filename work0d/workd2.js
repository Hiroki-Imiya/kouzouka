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

                //タイトルと著者と出版社を取得
                var title=$(item).find('title').text();
                var author=$(item).find('author').text();
                var publisher=$(item).find('price').attr('publisher');

                //取得したデータを出力
                $("div").append('著者「' + author + '」は「' + title + '」を「' + publisher + '」から出版しました。<br>');
            });

        });
    }    
});