
INSERT INTO `services`.`agent_order` (`id`) VALUES ('200');

INSERT INTO `services`.`agent_order` (`id`) VALUES ('2');

INSERT INTO `services`.`user_order` (`id`) VALUES ('1');

INSERT INTO `services`.`user_order` (`id`) VALUES ('2');

INSERT INTO `services`.`user_order` (`id`) VALUES ('3');

INSERT INTO `services`.`ad_car_order` (`id`,`agent_izdao_ad_id`,`user_izdavao_ad_id`) VALUES ('1','200','2');

INSERT INTO `services`.`ad_car_order` (`id`,`agent_izdao_ad_id`,`user_izdavao_ad_id`) VALUES ('2','200','1');

INSERT INTO `services`.`ad_car_order` (`id`,`agent_izdao_ad_id`,`user_izdavao_ad_id`) VALUES ('3','200','1');

INSERT INTO `services`.`ad_car_order` (`id`,`agent_izdao_ad_id`,`user_izdavao_ad_id`) VALUES ('4','200','3');

INSERT INTO `services`.`orders` (`id`,`available_from`,`available_to`,`required`,`ad_car`,`agent_izdao_id`,`user_izdavao_id`,`userr_id`,`deleted`) VALUES ('5','10/10/2019','15/05/2020',false,'1','200','2','1',false);

INSERT INTO `services`.`orders` (`id`,`available_from`,`available_to`,`required`,`ad_car`,`agent_izdao_id`,`user_izdavao_id`,`userr_id`,`deleted`) VALUES ('6','11/10/2019','05/05/2020',false,'2','200','1','1',false);

INSERT INTO `services`.`orders` (`id`,`available_from`,`available_to`,`required`,`ad_car`,`agent_izdao_id`,`user_izdavao_id`,`userr_id`,`deleted`) VALUES ('4','10/10/2019','15/05/2020',true,'1','200','2','2',false);

INSERT INTO `services`.`orders` (`id`,`available_from`,`available_to`,`required`,`ad_car`,`agent_izdao_id`,`user_izdavao_id`,`userr_id`,`deleted`) VALUES ('7','10/10/2019','15/05/2020',true,'4','200','3','2',false);

INSERT INTO `services`.`orders` (`id`,`available_from`,`available_to`,`required`,`ad_car`,`agent_izdao_id`,`user_izdavao_id`,`userr_id`,`deleted`) VALUES ('8','10/10/2019','15/05/2020',true,'1','200','3','2',true);

INSERT INTO `services`.`requests` (`id`,`payment_date`,`accept_date`,`bundle`,`status`) VALUES ('5','2020-6-19 12:10:59','2020-6-20 08:10:59',false,'RESERVED');

INSERT INTO `services`.`requests` (`id`,`payment_date`,`accept_date`,`bundle`,`status`) VALUES ('6','2020-6-19 12:10:59','2020-6-20 08:10:59',false,'PENDING');

INSERT INTO `services`.`requests` (`id`,`payment_date`,`accept_date`,`bundle`,`status`) VALUES ('7','2020-6-30 08:10:59','2020-6-30 08:10:59',false,'PENDING');

INSERT INTO `services`.`requests_order_list` (`request_id`,`order_list_id`) VALUES ('5','4');

INSERT INTO `services`.`requests_order_list` (`request_id`,`order_list_id`) VALUES ('7','7');

INSERT INTO `services`.`requests_order_list` (`request_id`,`order_list_id`) VALUES ('6','8');

-- INSERT INTO `services`.`agent_order` (`id`) VALUES ('1');
--
-- INSERT INTO `services`.`agent_order` (`id`) VALUES ('2');
--
-- INSERT INTO `services`.`user_order` (`id`) VALUES ('1');
--
-- INSERT INTO `services`.`user_order` (`id`) VALUES ('2');
--
-- INSERT INTO `services`.`user_order` (`id`) VALUES ('3');
--
-- INSERT INTO `services`.`ad_car_order` (`id`,`agent_izdao_ad_id`,`user_izdavao_ad_id`) VALUES ('1','1','2');
--
-- INSERT INTO `services`.`ad_car_order` (`id`,`agent_izdao_ad_id`,`user_izdavao_ad_id`) VALUES ('2','1','1');
--
-- INSERT INTO `services`.`ad_car_order` (`id`,`agent_izdao_ad_id`,`user_izdavao_ad_id`) VALUES ('3','1','1');
--
-- INSERT INTO `services`.`ad_car_order` (`id`,`agent_izdao_ad_id`,`user_izdavao_ad_id`) VALUES ('4','1','3');
--
-- INSERT INTO `services`.`orders` (`id`,`available_from`,`available_to`,`required`,`ad_car_id`,`agent_izdao_id`,`user_izdavao_id`,`userr_id`) VALUES ('5','10/10/2019','15/05/2020',false,'1','1','2','1');
--
-- INSERT INTO `services`.`orders` (`id`,`available_from`,`available_to`,`required`,`ad_car_id`,`agent_izdao_id`,`user_izdavao_id`,`userr_id`) VALUES ('6','11/10/2019','05/05/2020',false,'2','1','1','1');
--
-- INSERT INTO `services`.`orders` (`id`,`available_from`,`available_to`,`required`,`ad_car_id`,`agent_izdao_id`,`user_izdavao_id`,`userr_id`) VALUES ('4','10/10/2019','15/05/2020',true,'1','1','2','2');
--
-- INSERT INTO `services`.`orders` (`id`,`available_from`,`available_to`,`required`,`ad_car_id`,`agent_izdao_id`,`user_izdavao_id`,`userr_id`) VALUES ('7','10/10/2019','15/05/2020',true,'4','1','3','2');
--
-- INSERT INTO `services`.`orders` (`id`,`available_from`,`available_to`,`required`,`ad_car_id`,`agent_izdao_id`,`user_izdavao_id`,`userr_id`) VALUES ('8','10/10/2019','15/05/2020',true,'1','1','3','2');
--
-- INSERT INTO `services`.`requests` (`id`,`payment_date`,`accept_date`,`bundle`,`status`) VALUES ('5','2020-6-19 12:10:59','2020-6-20 08:10:59',false,'RESERVED');
--
-- INSERT INTO `services`.`requests` (`id`,`payment_date`,`accept_date`,`bundle`,`status`) VALUES ('6','2020-6-19 12:10:59','2020-6-20 08:10:59',false,'PENDING');
--
-- INSERT INTO `services`.`requests` (`id`,`payment_date`,`accept_date`,`bundle`,`status`) VALUES ('7','2020-6-30 08:10:59','2020-6-30 08:10:59',false,'PENDING');
--
-- INSERT INTO `services`.`requests_order_list` (`request_id`,`order_list_id`) VALUES ('5','4');
--
-- INSERT INTO `services`.`requests_order_list` (`request_id`,`order_list_id`) VALUES ('7','7');
--
-- INSERT INTO `services`.`requests_order_list` (`request_id`,`order_list_id`) VALUES ('6','8');

