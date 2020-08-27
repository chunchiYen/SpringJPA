-- safe update mode
-- SET SQL_SAFE_UPDATES=0; --關閉
-- SET SQL_SAFE_UPDATES=1; --開啟
-- TRUNCATE  table Bookstore;
-- ALTER TABLE Bookstore modify  COLUMN Price  DECIMAL(10,2)  default 0.00 not null ;
-- My SQL 更新、刪除時若無where 或 limit 或沒有包含key Column 的條件，會無法運行
-- 更新或刪除前 將 SQL_SAFE_UPDATES 關閉，即可執行更新作業。
-- 0 閉閉 1: 打開 

DROP TABLE IF EXISTS UserInfo;
Create Table UserInfo(
account varchar(12) not null primary key,
password varchar(30) not null,
name varchar(30) not null ,
logindate datetime ,
lastlogindate datetime,
memo varchar(200)
);

Insert Into UserInfo values('A123456789' ,'a1234' ,'王大明' , '2019/06/30' ,null ,'');
Insert Into UserInfo values('B232356789' ,'b1234' ,'張小明' , '2020/05/30' ,'2019/12/31' ,'');
Insert Into UserInfo values('B232356789' ,'b1234' ,'李萌新' , null ,null ,'');

DROP TABLE IF EXISTS Functions;
Create Table Functions(
	fid INT  AUTO_INCREMENT primary key ,
	FuncId varchar(10) not null ,
	FuncName varchar(30) not null ,
	ModifyUser varchar(30) ,
	modifytime datetime,
    UNIQUE INDEX (FuncId)
);

Insert Into Functions values(default, 'A02000' , '個金客戶資料查詢' , 'HB6001' , '2020/05/30' );
Insert Into Functions values(default, 'A02001' , '個金客戶保險查詢' , 'HB6002' , '2020/04/13' );
Insert Into Functions values(default, 'A02002' , '個金客戶資產查詢' , 'HB6002' , '2020/03/23' );
Insert Into Functions values(default, 'A03001' , '企金客戶資料查詢' , 'HB6007' , '2020/03/23' );
Insert Into Functions values(default, 'A03002' , '企金客戶產險查詢' , 'HB6007' , '2020/03/23' );
Insert Into Functions values(default, 'A03002' , '企金客戶產險查詢' , 'HB6007' , '2020/03/23' );

DROP TABLE IF EXISTS Bookstore;
		CREATE TABLE Bookstore(
		bid varchar(10) NOT NULL,
		Bookname varchar(50) Not NULL,
		Publisher varchar(50) DEFAULT NULL,
		Author varchar(30) DEFAULT NULL,
		Price DECIMAL(10,2) DEFAULT 0.00,
		Version Varchar(10) default '1.0',
		PRIMARY KEY (bid)
	) ;
	
INSERT INTO Bookstore Values('0110133001', '哈利波特1' ,'英國出版社' ,'羅琳' , 611 ,'4' );
INSERT INTO Bookstore Values('0110133002', '哈利波特2' ,'英國出版社' ,'羅琳' , 612 ,'4' );
INSERT INTO Bookstore Values('0110133003', '哈利波特3' ,'英國出版社' ,'羅琳' , 613 ,'3' );
INSERT INTO Bookstore Values('0110133004', '哈利波特4' ,'英國出版社' ,'羅琳' , 614 ,'2' );
INSERT INTO Bookstore Values('0110133005', '哈利波特5' ,'英國出版社' ,'羅琳' , 615 ,'2' );
INSERT INTO Bookstore Values('0110133006', '哈利波特6' ,'英國出版社' ,'羅琳' , 616 ,'1' );
INSERT INTO Bookstore Values('0110144001', '魔戒三部曲1' ,'英國出版社' ,'凱特' , 520 ,'2' );
INSERT INTO Bookstore Values('0110144002', '魔戒三部曲2' ,'英國出版社' ,'凱特' , 521 ,'3' );
INSERT INTO Bookstore Values('0110144003', '魔戒三部曲3' ,'英國出版社' ,'凱特' , 531 ,'4' );
INSERT INTO Bookstore Values('0001110001', '台灣走透透' ,'英國出版社' ,'林龍' , 407 ,'3' );

Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345003','A到A++','尖峰出版社','書思筠', 101,'1.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345004','UML詳解','聯經出版社','書寶君', 111,'1.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345005','JAVA 8','新竹出版社','書佳欣', 121,'1.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345006','Spring Boot','嘉義出版社','書音勇', 131,'1.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345007','活著','桃園出版社','書康緯', 141,'1.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345008','書儀成','讀者文著','書世妹', 151,'1.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345009','猜一猜 我是誰？ ','親子天下','書迪利', 161,'1.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345010','毛毛123：開開 ','尖峰出版社','書金能', 171,'1.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345011','毛毛123：來來 ','聯經出版社','書添紫', 181,'1.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345012','毛毛123：抱抱 ','新竹出版社','書思筠', 191,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345013','可能小學愛地球任務：海賊島大冒險 ','嘉義出版社','書寶君', 201,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345014','可能小學愛地球任務：拯救黑熊大作戰 ','桃園出版社','書佳欣', 211,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345015','短耳兔','讀者文著','書音勇', 221,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345016','2歲動動手-頭腦開發遊戲','親子天下','書康緯', 231,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345017','逗陣來唱囡仔歌6：幼幼篇 ','尖峰出版社','書世妹', 241,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345018','逗陣來唱囡仔歌7：幼兒篇 ','聯經出版社','書迪利', 251,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345019','不簡單女孩1 用圖像思考的女孩：動物科學家天','新竹出版社','書金能', 261,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345020','給中小學生的世界歷史【古文明卷】：美國最會','嘉義出版社','書添紫', 271,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345021','不簡單女孩3 眼光獨到的女孩：派翠西亞‧巴斯醫','桃園出版社','書思筠', 281,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345022','中小學生必讀中國歷史轉捩點 (電子書)','讀者文著','書寶君', 291,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345023','維尼小熊被霸凌','親子天下','書佳欣', 301,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345024','A到A++','尖峰出版社','書音勇', 311,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345025','UML詳解','聯經出版社','書康緯', 321,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345026','JAVA 8','新竹出版社','書世妹', 331,'2.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345027','Spring Boot','嘉義出版社','書迪利', 341,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345028','活著','桃園出版社','書金能', 351,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345029','書儀成','讀者文著','書添紫', 361,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345030','猜一猜 我是誰？ ','親子天下','書思筠', 371,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345031','毛毛123：開開 ','尖峰出版社','書寶君', 381,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345032','毛毛123：來來 ','聯經出版社','書佳欣', 391,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345033','毛毛123：抱抱 ','新竹出版社','書音勇', 401,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345034','可能小學愛地球任務：海賊島大冒險 ','嘉義出版社','書康緯', 411,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345035','可能小學愛地球任務：拯救黑熊大作戰 ','桃園出版社','書世妹', 421,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345036','短耳兔','讀者文著','書迪利', 431,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345037','2歲動動手-頭腦開發遊戲','親子天下','書金能', 441,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345038','逗陣來唱囡仔歌6：幼幼篇 ','尖峰出版社','書添紫', 451,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345039','逗陣來唱囡仔歌7：幼兒篇 ','聯經出版社','書思筠', 461,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345040','不簡單女孩1 用圖像思考的女孩：動物科學家天','新竹出版社','書寶君', 471,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345041','給中小學生的世界歷史【古文明卷】：美國最會','嘉義出版社','書佳欣', 481,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345042','不簡單女孩3 眼光獨到的女孩：派翠西亞‧巴斯醫','桃園出版社','書音勇', 491,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345043','中小學生必讀中國歷史轉捩點 (電子書)','讀者文著','書康緯', 501,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345044','維尼小熊被霸凌','親子天下','書世妹', 511,'3.0');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345045','A到A++','尖峰出版社','書迪利', 521,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345046','UML詳解','聯經出版社','書金能', 531,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345047','JAVA 8','新竹出版社','書添紫', 541,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345048','Spring Boot','嘉義出版社','書思筠', 551,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345049','活著','桃園出版社','書寶君', 561,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345050','書儀成','讀者文著','書佳欣', 571,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345051','猜一猜 我是誰？ ','親子天下','書音勇', 581,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345052','毛毛123：開開 ','尖峰出版社','書康緯', 591,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345053','毛毛123：來來 ','聯經出版社','書世妹', 601,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345054','毛毛123：抱抱 ','新竹出版社','書迪利', 611,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345055','可能小學愛地球任務：海賊島大冒險 ','嘉義出版社','書金能', 621,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345056','可能小學愛地球任務：拯救黑熊大作戰 ','桃園出版社','書添紫', 631,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345057','短耳兔','讀者文著','書思筠', 641,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345058','2歲動動手-頭腦開發遊戲','親子天下','書寶君', 651,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345059','逗陣來唱囡仔歌6：幼幼篇 ','尖峰出版社','書佳欣', 661,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345060','逗陣來唱囡仔歌7：幼兒篇 ','聯經出版社','書音勇', 671,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345061','不簡單女孩1 用圖像思考的女孩：動物科學家天','新竹出版社','書康緯', 681,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345062','給中小學生的世界歷史【古文明卷】：美國最會','嘉義出版社','書世妹', 691,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345063','不簡單女孩3 眼光獨到的女孩：派翠西亞‧巴斯醫','桃園出版社','書迪利', 701,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345064','中小學生必讀中國歷史轉捩點 (電子書)','讀者文著','書金能', 711,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345065','維尼小熊被霸凌','親子天下','書添紫', 721,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345066','A到A++','尖峰出版社','書思筠', 731,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345067','UML詳解','聯經出版社','書寶君', 741,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345068','JAVA 8','新竹出版社','書佳欣', 751,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345069','Spring Boot','嘉義出版社','書音勇', 761,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345070','活著','桃園出版社','書康緯', 771,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345071','書儀成','讀者文著','書世妹', 781,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345072','猜一猜 我是誰？ ','親子天下','書迪利', 791,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345073','毛毛123：開開 ','尖峰出版社','書金能', 801,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345074','毛毛123：來來 ','聯經出版社','書添紫', 811,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345075','毛毛123：抱抱 ','新竹出版社','書思筠', 821,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345076','可能小學愛地球任務：海賊島大冒險 ','嘉義出版社','書寶君', 831,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345077','可能小學愛地球任務：拯救黑熊大作戰 ','桃園出版社','書佳欣', 841,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345078','短耳兔','讀者文著','書音勇', 851,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345079','2歲動動手-頭腦開發遊戲','親子天下','書康緯', 861,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345080','逗陣來唱囡仔歌6：幼幼篇 ','尖峰出版社','書世妹', 871,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345081','逗陣來唱囡仔歌7：幼兒篇 ','聯經出版社','書迪利', 881,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345082','不簡單女孩1 用圖像思考的女孩：動物科學家天','新竹出版社','書金能', 891,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345083','給中小學生的世界歷史【古文明卷】：美國最會','嘉義出版社','書添紫', 901,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345084','不簡單女孩3 眼光獨到的女孩：派翠西亞‧巴斯醫','桃園出版社','書思筠', 911,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345085','中小學生必讀中國歷史轉捩點 (電子書)','讀者文著','書寶君', 921,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345086','維尼小熊被霸凌','親子天下','書佳欣', 631.156789,'3.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345087','維尼小熊與習小平','遠見天下','天下出版社', 631.00,'1.5');
Insert Into Bookstore(bid,Bookname,Publisher,Author,Price,Version)Values('1012345088','不簡單女孩1','遠見天下','書添紫', 1101.19 ,'3.8');

Drop Table IF EXISTS Authors;
Create Table Authors(
	Id varchar(10) not null,
	AuthorName Varchar(30) not null,
	Phone Varchar(30) ,
	Address Varchar(100),
	Age Integer  default 0,
	PRIMARY Key(Id)
);
Insert Into Authors Values('EN0000001' , '羅琳' ,'43-23920391' ,'英國' ,55);
Insert Into Authors Values('FN0000002' , '凱特' ,'788-9346335' ,'法國' ,51);
Insert Into Authors Values('FN0000003' , '林龍' ,'886-932123489' ,'台灣' ,59);
Insert Into Authors Values('TW0000004' , '林胖' ,'886-66661234' ,'台灣' ,38);
Insert Into Authors Values('TW0000005' , '李文龍' ,'886-52421234' ,'台灣' ,38);
Insert Into Authors Values('TW0000006' , '韓狗與' ,'886-234101234' ,'台灣' ,56);
SELECT * FROM Authors;
    
Drop Table IF EXISTS Authorss;
Create Table Authorss(
	Id varchar(10) not null,
	AuthorName Varchar(30) not null,
	Phone Varchar(30) ,
	Address Varchar(100),
	Age Integer  default 0,
	PRIMARY Key(Id)
);

Insert Into Authorss Values('EN0000001' , '羅琳' ,'43-23920391' ,'英國' ,55);
Insert Into Authorss Values('FN0000002' , '凱特' ,'788-9346335' ,'法國' ,51);
Insert Into Authorss Values('FN0000003' , '林龍' ,'886-932123489' ,'台灣' ,59);
Insert Into Authorss Values('TW0000004' , '林胖' ,'886-66661234' ,'台灣' ,38);
Insert Into Authorss Values('TW0000005' , '李文龍' ,'886-52421234' ,'台灣' ,38);
Insert Into Authorss Values('TW0000006' , '韓狗與' ,'886-234101234' ,'台灣' ,56);
   
DROP TABLE IF EXISTS SEQ;
	CREATE TABLE SEQ(
	-- id int Not Null auto_increment ,
	ItemName varchar(30) Not NULL ,
	Item_Seq int  default 1,
	SeqYear varchar(6) default '',
	PRIMARY KEY (Item_Seq)
) ;

Insert Into SEQ values( 'Books' , default , default);
Insert Into SEQ values( 'Author' , default , default);

-- CreateTable  TestTable in order to test JPA Create Entity datatype
DROP TABLE IF EXISTS obapp.TestTable;
Create table obapp.TestTable(
	id BigInt not null,
    title varchar(20) not null , 
    len integer not null default 0,
    len2 float not null default 0.00,  
    len3 NUMERIC(10,2) ,
    createtime date ,
    modifytime  TIMESTAMP ,      
    primary key (id)
);
Insert into TestTable(id , title , len) values(0000001 , 'city' , 10);
Insert into TestTable(id , title , len,modifytime) values(0000002 , 'contry' , 8 , sysdate());
Insert into TestTable(id , title , len,createtime) values(0000003 , 'road' , 20 , sysdate());
    
    