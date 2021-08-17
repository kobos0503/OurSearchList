delete from member where id='2'
delete from folder_youtube_channel where folder_name ='4k';
delete from list_youtube_channel where folder_name =''

select p.num, p.title, p.content, p.channel_info, p.folder_name, p.posting_date, p.recommend_type, p.hits, p.likes, p.certified, p.id, m.nickname
from ( 
		select row_number()	over(order by num desc) as rnum, num, title, content, channel_info, folder_name,
				date_format(posting_date,'%Y-%m-%d %H:%i') as posting_date, recommend_type, hits, likes, certified, id
		from post
	 ) p, member m
where p.id = m.id and rnum between '1' and '10'
order by p.num desc

select * from member
select * from post