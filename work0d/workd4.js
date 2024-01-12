$(function(){
    
    //ボタンクリックイベント
    $("#btn").on("click",getData);

    //Ajaxを実行するユーザ定義関数
    function getData(){

        //ターゲットとなるファイルのURL
        var target_url='books.json';

        //Ajax通信を開始する
        $.ajax({
            type:"GET", 
            dataType:"json", //受信データ形式
            url:target_url
        }).fail(function(jqXHR,textStatus,errorThrown){
            //通信失敗時の処理
            alert('失敗');
        }).done(function(data,textStatus,jqXHR){
            //通信成功時の処理
            alert('成功');

            //取得したデータの中身を確認
            console.log(data);

            //jsonのbook要素からタイトルと著者と価格と出版社を取得
            for(var i=0;i<data.books.book.length;++i){
                var title=data.books.book[i].title;
                var author=data.books.book[i].author;
                var price=data.books.book[i].price['#text'];
                var publisher=data.books.book[i].price['@publisher'];

                //取得したデータを出力
                $("div").append(title+'--'+author+'--'+price+'--'+publisher+'<br>');
            }

        });
    }    
});