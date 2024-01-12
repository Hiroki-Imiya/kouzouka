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
            $.each(data.books.book,function(index,item){
                $.each(item,function(key,val){
                    
                    //変数の定義
                    var itemName;
                    var itemName2;
                    var val2;

                    //keyの値によって処理を分岐
                    switch(key){
                        case 'title':
                            itemName='タイトル';
                            break;
                        case 'price':
                            itemName='価格';
                            itemName2='出版社';
                            val2=val['@publisher'];
                            val=val['#text'];
                            break;
                        case 'author':
                            itemName='著者';
                            break;
                        case '@isbn':
                            itemName='ISBN';
                            break;
                        case '@publisher':
                            itemName='出版社';
                            break;
                    }

                    var str=itemName+':'+val+'<br>';

                    if(typeof itemName2 !=='undefined'){
                        str+=itemName2+':'+val2+'<br>';
                    }

                    //取得したデータを出力
                    $("div").append(str);
                });
                
                //区切り
                $("div").append('==========================<br>');
            });

        });
    }    
});