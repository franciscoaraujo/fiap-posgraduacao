insert into usertbl("name", "password", created_at,updatade_at)values
   ('John Contraine', '123456', '2022-08-26', '2022-08-26'),
   ('StanGetz Machado', '123456', '2022-08-26', '2022-08-26'),
   ('Deve Weckel sa Silva', '123456', '2022-08-26', '2022-08-26');

insert into user_tasktbl("name", "description", created_at, updatade_at, task_finished, id_user)values
    ('Trabalho', 'Finalizar partitura Countdown', null, '022-08-26', false, 1),
    ('Estudo', 'Praticar campo harmonico menor', null, '022-08-26', false, 2),
    ('Estudo', 'Praticar Paradidlle', null, '022-08-26', false, 3),
    ('Manutencao', 'Trocar as peles da caixa', null, '022-08-26', false, 3);
