【 タイトル 】 簡単WEBサーバー
【バージョン】 4.03
【ファイル名】 KantanWEBServer.exe
【 動作環境 】 Microsoft Windows 7
【ソフト種別】 フリーソフト
【 公 開 日 】 2011/12/03
【転載の可否】 可 メールを下さい(特に雑誌掲載のときはよろしくお願いします)
【    HP    】 http://prorom.sakura.ne.jp/wp/
【  メール  】 whiteunyora@yahoo.co.jp


[動作に必要なもの]
	Microsoft .NET Framework 4 Client Profile  (x86/x64)が
	必要です。
	MicroSoftのHP(http://www.microsoft.com/downloads/ja-jp/details.aspx?FamilyID=E5AD0459-CBCC-4B4F-97B6-FB17111CF544)
	からダウンロードしてインストールしてください。


[概要]	
	簡単に設置できるHTTPServerです。

[注意事項]
	このソフトを使用して何らかの被害をこうむっても倉田　智朗は責任を
	負うことはないものとします。

	ソースファイルの公開は、簡単WEBサーバーに対するフィードバックと、
	これからC#を勉強をする人の為に何らかの手助けになればと考えてのことです。
	悪用はしないでください。
	また、権利を放棄する物ではありません。(要望がないので最近は公開してません)

		

[ソフトの使い方]
	基本的な使い方。
	1)公開するフォルダを追加。
	2)待ち受け開始ボタンを押す。

	細かい設定は個別設定を設定してください。
	設定の仕方はHPを参照してください。
	
[アンインストール]
	フォルダごと削除してください。レジストリーは使用していません。

[履歴]
2011/12/03
	.NET Framework 4 Client Profileで動作するようにしました。
2011/09/20
	広告を非表示にできるようにしました。
2011/08/14
	ログファイルの保存フラグをtrueにしたときに保存されていない使用を保存するようにしました。
2011/07/24
	WPFアプリに移植。.NET Framework 4.0　fullが必要
2009/03/23
	プロバイダーを変更したため、IPアドレスが取得できなくなっていました。
	uPnP対応ルーターからグローバルIPを取得するように変更。
2008/09/15
	クロスサイトスクリプティングの脆弱性を修正しました。
	ディレクトリトラバーサルの脆弱性を修正しました。
	上記の情報を提示してもらったJPCERT/CC様と、情報の提示提供者様に感謝の意を表させてもらいます。
	POSTを再実装しました。
2008/02/14
	ネットワークドライブが共有できなかった不具合の修正。
2007/03/30
	萌えっちすから簡単WEBサーバーに名前が変更
	/にアクセスしたときにindex.htmlファイルがあればそれを読みに行く機能の追加。
2007/03/11
	フォルダ内のファイルの一覧を公開するかどうかの設定の追加。(デフォルトは非公開)
	起動時にサーバーを開始するかどうかの設定の追加。
2006/12/15
	余計なコントロールが画面に張られていたのを削除。
	ルートドライブが一つしか追加できなかったバグの修正。	

2006/12/15
	萌えっちすに名称変更
	実行中に公開フォルダの追加ができるように変更。

2006/01/17 EasyHTTPServer1.2
	.NET Framework Version 2.0への移行。

2005/11/29 EasyHTTPServer1.1
	ログを保存するかどうかの設定の追加。
	最大同時接続数の追加(default時50)

2005/10/25 EasyHTTPServer1.0リリース
