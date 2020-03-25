drop table if exists posts;

create table posts (
    id integer auto_increment primary key,
    username varchar(255),
    text varchar(2000),
    date timestamp
);

drop table if exists mediafiles;

create table mediafiles (
    post_id integer,
    name varchar(255),
	media_type varchar(255),
    url varchar(3000)
);

insert into posts (username, text, date)
    values ('Bob', 'Today, I found a very nice video on how croissants are made.', '2020-01-23 17:10:00');
insert into posts (username, text, date)
	values ('John', 'This is such a nice image of a tree.', '2020-02-08 12:10:00';
insert into posts (username, text, date)
	values ('Betty', 'This song is so good. It really brings back memories of the good old days.', '2020-03-20 13:30:00');
insert into posts (username, text, date)
	values ('Jane', 'This image of a mountain is so relaxing and beautiful to view.', now());

insert into mediafiles (post_id, name, media_type, url)
    values (1, 'croissants', 'video', 'https://www.youtube.com/watch?v=beOxJm1_tbk');
insert into mediafiles (post_id, name, media_type, url)
	values (2, 'tree', 'image', 'https://upload.wikimedia.org/wikipedia/commons/e/eb/Ash_Tree_-_geograph.org.uk_-_590710.jpg');
insert into mediafiles (post_id, name, media_type, url)
	values (3, 'starwars', 'audio', 'https://www.youtube.com/watch?v=_D0ZQPqeJkk');
insert into mediafiles (post_id, name, media_type, url)
	values (4, 'mountain', 'image', 'https://images.pexels.com/photos/618833/pexels-photo-618833.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500');
