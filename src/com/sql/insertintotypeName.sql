select *from book left join salesNumber on book.id = salesNumber.bookID order by salesNumber.salesNumber desc limit 0,25
select book.* from book,salesNumber where book.id=salesNumber.bookID order by salesNumber.salesNumber desc limit 0,25
INSERT INTO COMMENTS (COMMENT,BOOKID,USERID) VALUES('�ܺõ�һ����',1,1);
SELECT * FROM COMMENTS WHERE BOOKID=1;
SELECT * FROM BOOK LIMIT 0,12;
SELECT * FROM BOOK WHERE BOOKTYPEID=1 or BOOKTYPEID=2;
SELECT * FROM BOOK WHERE BOOKTYPESONID=39 LIMIT 0,3;
SELECT * FROM BOOK where bookName like'%��%';
SELECT * FROM BOOK WHERE BOOKTYPEID=1 LIMIT 0,3;
insert into orders (No,date,totalprice,userID) values('TD20170523095613','2017-5-23',338.0,14);
select * from orders;
insert into orderinfo (bookID,bookName,price,bookNumber,Subtotal,No) values(2,'小白',12,2,24,'TD20170523095613');
SELECT count(*) count FROM BOOK WHERE BOOKTYPEID=7 OR BOOKTYPEID=8 OR BOOKTYPEID=9;
SELECT * FROM BOOK where BOOKTYPEID=1 LIMIT 1,1;
select * from book order by price desc;
SELECT book.* FROM book,shelftime WHERE book.id=shelftime.bookID and book.bookTypeID=1  order by shelftime.year desc;
select book.bookTypeID from book,usercart where book.id=usercart.bookID group by book.bookTypeID having COUNT(*)>1;
select * from test where name in 
(select name from test group by name having COUNT(*)>1)
select book.bookTypeID from book,usercart where book.id=usercart.bookID;
select book.bookTypeID from book,usercart where book.id=usercart.bookID group by book.bookTypeID having COUNT(*)=1;