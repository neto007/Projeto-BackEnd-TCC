insert into user (id, avatar, email, name, password, tipo_usuario) 
values ('6dd76206-82f9-439d-aad6-100019964da1',
		  'https://thumbs.dreamstime.com/b/do-retrato-masculino-do-avatar-do-%C3%ADcone-do-perfil-pessoa-ocasional-46846371.jpg', 
        'admin@gmail.com', 
		  'José da Silva', 
		  '$2a$10$lK6RAbFYBV193ICulwY.1.EvBn.iBv3CPeGkjYmrtrHLNQOj7dDoe', 
		  'admin'); 
		  
insert into user (id, avatar, email, name, password, tipo_usuario) 
values ('6383b7bf-8342-444f-9fa6-daaefee85c2d', 
	     'http://media.istockphoto.com/vectors/profile-icon-male-avatar-portrait-casual-person-vector-id530827853',
        'joao@gmail.com', 
		  'João da Silva', 
		  '$2a$10$lK6RAbFYBV193ICulwY.1.EvBn.iBv3CPeGkjYmrtrHLNQOj7dDoe', 
		  'comum'); 
		  

insert into evento_categoria 
values ('d7201e3f-06a7-4b40-bd04-cb9bdcce7286', 
        'http://www.woa.com.br/blog/wp-content/uploads/2017/07/Dia-Mundial-do-Rock.jpg',
        'Show Rock');		  
		  

insert into estabelecimento_categoria 
values ('71e03667-390e-42ab-a8e8-323c68ab1ebb', 
        'http://www.choppalemao.com.br/images/site/comemoracao-_ein_prosit.jpg',
        'Bares');
        
insert into estabelecimento_categoria 
values ('95819043-7578-4639-957b-69b02011ad3a', 
        'https://2.bp.blogspot.com/-wQYdlfp6mvI/V1sic1xN7XI/AAAAAAAAB4Y/5tFOwlJSnW0j8qr6V2lKkp0V_D311LAEgCLcB/s1600/balada.jpg',
        'Baladas');
		  
insert into estabelecimento_categoria 
values ('e3df95d9-073f-49c4-a0a7-ee98eeb4feb0', 
        'https://img.stpu.com.br/?img=https://s3.amazonaws.com/pu-mgr/default/a0RG000000dPygjMAC/565f4ad3e4b0f2e9df482d04.jpg&w=620&h=400',
        'Pizzarias');

insert into estabelecimento_categoria 
values ('805bd8ba-8c11-488f-aaaf-b9a2dc7b0d77', 
        'http://www.dahotelespuntaarenas.com/img/galeria/restaurante04.jpg',
        'Restaurantes');
		  
insert into estabelecimento_categoria 
values ('44cdf771-98a6-421f-a500-df190a4c8142', 
        'https://s3a4z9x7.map2.ssl.hwcdn.net/contentFiles/image/2017/09/FEA/thumbnail/55494_w380h235_1505131141lollapalooza-i-hate-flash.jpg',
        'Shows');	



insert into endereco (id, rua, bairro, cep, complemento, numero, estado, cidade, latitude, longitude)
values ('00636445-c637-4bc0-85e0-7061c5dabe15',
        'Rua Venezuela',
        'Jardim Alvorada', 
        '87033360',
        'Meio da quadra',
        '150',
        'Paraná',
        'Maringá',
		  '18923476129876',
		  '02987640812634');
        
insert into endereco (id, rua, bairro, cep, complemento, numero, estado, cidade, latitude, longitude)
values ('e1758610-0c8f-4af9-b4ed-1bdf76170008',
        'Rua Brasília',
        'Jardim América', 
        '87033360',
        'B',
        '1200',
        'Paraná',
        'Maringá',
		  '18923476129876',
		  '02987640812634');  
		  
insert into endereco (id, rua, bairro, cep, complemento, numero, estado, cidade, latitude, longitude)
values ('eac3f180-62a2-4a28-aa6e-62c1b49e169f',
        'Rua das Neves',
        'Jardim Tóquio', 
        '87033360',
        'B',
        '1409',
        'Paraná',
        'Maringá',
		  '18923476129876',
		  '02987640812634'); 	
		  
insert into endereco (id, rua, bairro, cep, complemento, numero, estado, cidade, latitude, longitude)
values ('70250d62-ea46-4cba-b528-e288fe6c22c6',
        'Avenida São Paulo',
        'Centro', 
        '87033360',
        'B',
        '1300',
        'Paraná',
        'Maringá',
		  '18923476129876',
		  '02987640812634');
		  
insert into endereco (id, rua, bairro, cep, complemento, numero, estado, cidade, latitude, longitude)
values ('6071cea4-bfdb-425e-b611-247e91f58242',
        'Avenida São Paulo',
        'Centro', 
        '87033360',
        'B',
        '137',
        'Paraná',
        'Maringá',
		  '18923476129876',
		  '02987640812634');
		  
insert into endereco (id, rua, bairro, cep, complemento, numero, estado, cidade, latitude, longitude)
values ('83d69448-7bdd-49b2-8e5b-47613d1d99c9',
        'Avenida São Paulo',
        'Centro', 
        '87033360',
        'B',
        '1137',
        'Paraná',
        'Maringá',
		  '18923476129876',
		  '02987640812634');		 


insert into estabelecimento(id, imagem, nome, cnpj, descricao, categoria_id, endereco_id, telefone, celular, dono_id)
values ('2e6683f6-f319-4d23-a517-9290212ab823', 
        'https://pbs.twimg.com/profile_images/438775833302286336/9HAaif_n.jpeg',
        'MPB Bar',
		  '82.547.791/0001-39',
		  'Bar Cover Rock em geral',
		  '95819043-7578-4639-957b-69b02011ad3a',
		  '00636445-c637-4bc0-85e0-7061c5dabe15',
		  '32678090',
		  '99914-6090',
		  '6dd76206-82f9-439d-aad6-100019964da1');
		  
insert into estabelecimento(id, imagem, nome, cnpj, descricao, categoria_id, endereco_id, telefone, celular, dono_id)
values ('5bf82bf1-6030-4838-8075-fc095762af34', 
        'https://media-cdn.tripadvisor.com/media/photo-s/0d/42/dd/2f/salao-interno.jpg',
        'Car Wash',
		  '80.540.778/0001-31',
		  'Melhor esquina da cidade',
		  '71e03667-390e-42ab-a8e8-323c68ab1ebb',
		  'e1758610-0c8f-4af9-b4ed-1bdf76170008',
		  '30902870',
		  '99914-3030',
		  '6dd76206-82f9-439d-aad6-100019964da1');
		  
insert into estabelecimento(id, imagem, nome, cnpj, descricao, categoria_id, endereco_id, telefone, celular, dono_id)
values ('874702a3-de75-4619-b638-3e79c356a9ae', 
        'https://media-cdn.tripadvisor.com/media/photo-s/08/6a/82/9b/boteco-do-neco.jpg',
        'Boteco do Neco',
		  '85.540.478/0701-31',
		  'Melhores porções da cidade',
		  '71e03667-390e-42ab-a8e8-323c68ab1ebb',
		  '70250d62-ea46-4cba-b528-e288fe6c22c6',
		  '32902550',
		  '99814-3670',
		  '6dd76206-82f9-439d-aad6-100019964da1');
		  
insert into estabelecimento(id, imagem, nome, cnpj, descricao, categoria_id, endereco_id, telefone, celular, dono_id)
values ('1c5cb392-365e-41a7-8bae-7497e52bf986', 
        'https://media-cdn.tripadvisor.com/media/photo-s/0e/d1/78/32/um-pouquinho-do-nosso.jpg',
        'Santo Bar',
		  '86.540.378/0704-31',
		  'Venha conferir',
		  '71e03667-390e-42ab-a8e8-323c68ab1ebb',
		  '83d69448-7bdd-49b2-8e5b-47613d1d99c9',
		  '32552550',
		  '88814-3670',
		  '6dd76206-82f9-439d-aad6-100019964da1');
		  
insert into estabelecimento(id, imagem, nome, cnpj, descricao, categoria_id, endereco_id, telefone, celular, dono_id)
values ('0879c441-ad04-49e9-a403-932e1c66071f', 
        'http://www.maringa.com/_assets/imgs/festas/27_imagem3_.jpg',
        'Farms Pub',
		  '86.540.378/0704-31',
		  'Balada Sertaneja!',
		  '95819043-7578-4639-957b-69b02011ad3a',
		  'e1758610-0c8f-4af9-b4ed-1bdf76170008',
		  '35556650',
		  '84814-3650',
		  '6dd76206-82f9-439d-aad6-100019964da1');
		  
insert into estabelecimento(id, imagem, nome, cnpj, descricao, categoria_id, endereco_id, telefone, celular, dono_id)
values ('4ec6c581-85dc-4952-b20c-3e7f79e55cb3', 
        'http://www.pizzariapepperoni.com.br/admin/assets/galeria_imagens/p1ak9bfvvebbo1rea1hlr1aq7t7v4.jpg',
        'Peperoni',
		  '81.550.378/7704-51',
		  'Pizza Italiana!',
		  'e3df95d9-073f-49c4-a0a7-ee98eeb4feb0',
		  'eac3f180-62a2-4a28-aa6e-62c1b49e169f',
		  '37656650',
		  '82314-3650',
		  '6dd76206-82f9-439d-aad6-100019964da1');	 


insert into evento (id, nome, imagem, descricao, data, criador, telefone, celular, categoria_id, endereco_id, estabelecimento_id)
values ('0b212719-548d-4ab6-ac22-809aed1e9a2d',
        'Cover ACDC',
        'http://www.mpbbar.com.br/wp-content/uploads/2014/11/mpbbar_121214.jpg', 
        'Cover de Londrina',
        '2017-09-16',
        '6dd76206-82f9-439d-aad6-100019964da1',
        '99128611',
        '32458540',
        'd7201e3f-06a7-4b40-bd04-cb9bdcce7286',
		  '00636445-c637-4bc0-85e0-7061c5dabe15',
		  '2e6683f6-f319-4d23-a517-9290212ab823');
		  
insert into evento (id, nome, imagem, descricao, data, criador, telefone, celular, categoria_id, endereco_id, estabelecimento_id)
values ('d3d3d32e-b4dc-4baa-b0e2-e89829a9a11e',
        'St Patricks Day',
        'http://www.mpbbar.com.br/wp-content/themes/mpbbar/xcropper.php,qw=270,ah=406,asrc=,hwww.mpbbar.com.br,_wp-content,_uploads,_2017,_08,_mpbbar_220917_2.jpg,azc=1.pagespeed.ic.Gn-RBJu6s3.jpg', 
        'Com Terra Celta',
        '2017-09-16',
        '6dd76206-82f9-439d-aad6-100019964da1',
        '99128611',
        '32458540',
        'd7201e3f-06a7-4b40-bd04-cb9bdcce7286',
		  '00636445-c637-4bc0-85e0-7061c5dabe15',
		  '2e6683f6-f319-4d23-a517-9290212ab823');
		  
insert into evento (id, nome, imagem, descricao, data, criador, telefone, celular, categoria_id, endereco_id, estabelecimento_id)
values ('df841b79-5ac9-4073-9469-28bda4dcaa74',
        'Cover Coldplay',
        'http://www.mpbbar.com.br/wp-content/themes/mpbbar/xcropper.php,qw=270,ah=406,asrc=,hwww.mpbbar.com.br,_wp-content,_uploads,_2017,_05,_mpbbar_260817_r.jpg,azc=1.pagespeed.ic.9L0FiJ0Sqe.jpg', 
        'Com Sr Bonifacio',
        '2017-09-16',
        '6dd76206-82f9-439d-aad6-100019964da1',
        '99128611',
        '32458540',
        'd7201e3f-06a7-4b40-bd04-cb9bdcce7286',
		  '00636445-c637-4bc0-85e0-7061c5dabe15',
		  '2e6683f6-f319-4d23-a517-9290212ab823');		  
		
		