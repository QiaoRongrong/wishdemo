-- example:
INSERT INTO `haier`.`eb_euser` (`id`, `ent_id`, `login_name`, `login_password`, `ent_code`, `user_name`, `state`, `frozen_state`, `logged_state`, `office_no`, `mobile_no`, `email`, `weixin_no`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modifier_id`, `remove_flag`, `remove_date`, `remover_id`, `notes`, `count`, `review_date`, `reviewer_id`, `audit_date`, `auditor_id`, `reject`) VALUES ('1681', '243', 'mucong', '7F975A56C761DB6506ECA0B37CE6EC87', '31000074', '穆聪', '2', '0', '1', NULL, '17663365166', 'flcrzb@163.com', '', '20180508', '142531', '0', NULL, NULL, '0', NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `haier`.`eb_euser` (`id`, `ent_id`, `login_name`, `login_password`, `ent_code`, `user_name`, `state`, `frozen_state`, `logged_state`, `office_no`, `mobile_no`, `email`, `weixin_no`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modifier_id`, `remove_flag`, `remove_date`, `remover_id`, `notes`, `count`, `review_date`, `reviewer_id`, `audit_date`, `auditor_id`, `reject`) VALUES ('1685', '243', 'zhangshouqing', '7F975A56C761DB6506ECA0B37CE6EC87', '31000074', '张守庆', '2', '0', '1', '', '17663365144', 'flcrzb@163.com', '', '20180508', '152502', '1681', NULL, NULL, '0', NULL, NULL, '', '0', NULL, NULL, NULL, NULL, NULL);


INSERT INTO `haier`.`eb_euser_ext` (`euser_id`, `icno`, `cert_type`, `cert_a_path`, `cert_b_path`, `proxy_path`, `post_flag`, `shortcut_menu`, `euser_ip`) VALUES ('1681', '37112219881111033X', '01', '', '', '', '2', NULL, NULL);
INSERT INTO `haier`.`eb_euser_ext` (`euser_id`, `icno`, `cert_type`, `cert_a_path`, `cert_b_path`, `proxy_path`, `post_flag`, `shortcut_menu`, `euser_ip`) VALUES ('1685', '372826197111141231', '01', '', '', '', '2', NULL, NULL);

INSERT INTO `haier`.`eb_r_euser_role` (`id`, `euser_id`, `role_id`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ('861', '1681', '23', NULL, '20180508', NULL, '0', NULL, NULL, NULL);
INSERT INTO `haier`.`eb_r_euser_role` (`id`, `euser_id`, `role_id`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ('865', '1685', '24', NULL, '20180508', NULL, '1681', NULL, NULL, NULL);

INSERT INTO `haier`.`eb_user_verification` (`id`, `euser_id`, `user_active_code`, `dc_serial_no`, `dc_download_date`, `dc_pass_code`, `dc_validate`, `dc_req_buf`, `dc_sign_buf`, `dc_req_publikey`, `dc_req_publickey_hash`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modifier_id`, `remove_flag`, `remove_date`, `remover_id`, `dc_revoke_date`, `dc_active_flag`, `dc_sign_bufp7`, `cert_type`, `bound_seal`) VALUES ('657', '1681', NULL, '42A9FB9B0C5120C585E76C670B710C8AE7BF4F84', '20180703', NULL, '365', NULL, NULL, NULL, NULL, '20180703', '103609', '186', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, '1', NULL);
INSERT INTO `haier`.`eb_user_verification` (`id`, `euser_id`, `user_active_code`, `dc_serial_no`, `dc_download_date`, `dc_pass_code`, `dc_validate`, `dc_req_buf`, `dc_sign_buf`, `dc_req_publikey`, `dc_req_publickey_hash`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modifier_id`, `remove_flag`, `remove_date`, `remover_id`, `dc_revoke_date`, `dc_active_flag`, `dc_sign_bufp7`, `cert_type`, `bound_seal`) VALUES ('658', '1685', NULL, '535AAA84E18DBDFAD9374F73FBE277F4829AD71A', '20180703', NULL, '365', NULL, NULL, NULL, NULL, '20180703', '103640', '186', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, '1', NULL);


-- -------------------------------
--------------- 徐晓艳,  xuxiaoyan, 17663365066, 2927128477@qq.com,  371122197808028322  -- id = 2186
--------------- 赵学平,  zhaoxueping, 18363392329, flczxp666@163.com, 37112219851019834X  -- id = 2187

INSERT INTO `haier`.`eb_euser` ( `ent_id`, `login_name`, `login_password`, `ent_code`, `user_name`, `state`, `frozen_state`, `logged_state`, `office_no`, `mobile_no`, `email`, `weixin_no`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modifier_id`, `remove_flag`, `remove_date`, `remover_id`, `notes`, `count`, `review_date`, `reviewer_id`, `audit_date`, `auditor_id`, `reject`)
VALUES ('243', 'xuxiaoyan', 'E10ADC3949BA59ABBE56E057F20F883E', '31000074', '徐晓艳', '2', '0', '0', NULL, '17663365066', '2927128477@qq.com', '', '20190307', '192531', '0', NULL, NULL, '0', NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `haier`.`eb_euser` ( `ent_id`, `login_name`, `login_password`, `ent_code`, `user_name`, `state`, `frozen_state`, `logged_state`, `office_no`, `mobile_no`, `email`, `weixin_no`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modifier_id`, `remove_flag`, `remove_date`, `remover_id`, `notes`, `count`, `review_date`, `reviewer_id`, `audit_date`, `auditor_id`, `reject`)
VALUES ('243', 'zhaoxueping', 'E10ADC3949BA59ABBE56E057F20F883E', '31000074', '赵学平', '2', '0', '0', '', '18363392329', 'flczxp666@163.com', '', '20180307', '192502', '1681', NULL, NULL, '0', NULL, NULL, '', '0', NULL, NULL, NULL, NULL, NULL);


INSERT INTO `haier`.`eb_euser_ext` (`euser_id`, `icno`, `cert_type`, `cert_a_path`, `cert_b_path`, `proxy_path`, `post_flag`, `shortcut_menu`, `euser_ip`) VALUES ('2186', '371122197808028322', '01', '', '', '', '2', NULL, NULL);
INSERT INTO `haier`.`eb_euser_ext` (`euser_id`, `icno`, `cert_type`, `cert_a_path`, `cert_b_path`, `proxy_path`, `post_flag`, `shortcut_menu`, `euser_ip`) VALUES ('2187', '37112219851019834X', '01', '', '', '', '2', NULL, NULL);

INSERT INTO `haier`.`eb_r_euser_role` (`euser_id`, `role_id`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ( '2186', '23', NULL, '20180508', NULL, '0', NULL, NULL, NULL);
INSERT INTO `haier`.`eb_r_euser_role` (`euser_id`, `role_id`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ( '2187', '24', NULL, '20180508', NULL, '1681', NULL, NULL, NULL);

INSERT INTO `haier`.`eb_user_verification` (`euser_id`, `user_active_code`, `dc_serial_no`, `dc_download_date`, `dc_pass_code`, `dc_validate`, `dc_req_buf`, `dc_sign_buf`, `dc_req_publikey`, `dc_req_publickey_hash`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modifier_id`, `remove_flag`, `remove_date`, `remover_id`, `dc_revoke_date`, `dc_active_flag`, `dc_sign_bufp7`, `cert_type`, `bound_seal`)
VALUES ('2186', NULL, NULL, '20190307', NULL, '365', NULL, NULL, NULL, NULL, '20190307', '103609', '186', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, '1', NULL);
INSERT INTO `haier`.`eb_user_verification` (`euser_id`, `user_active_code`, `dc_serial_no`, `dc_download_date`, `dc_pass_code`, `dc_validate`, `dc_req_buf`, `dc_sign_buf`, `dc_req_publikey`, `dc_req_publickey_hash`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modifier_id`, `remove_flag`, `remove_date`, `remover_id`, `dc_revoke_date`, `dc_active_flag`, `dc_sign_bufp7`, `cert_type`, `bound_seal`)
VALUES ('2187', NULL, NULL, '20190307', NULL, '365', NULL, NULL, NULL, NULL, '20190307', '103640', '186', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, '1', NULL);



--------------
-- 江苏华东电力冶金机械总厂有限公司    新的 经办员-杨鹏兴 和 复核员-张静
新经办员：杨朋兴 身份证 321281199209104210 电话 1529557850 邮箱 jstz-101.com@163.com
新复核员：张静 身份证 321202198709184528 电话 15850889845 邮箱 jstz-101.com@163.com


---------------
---------------
INSERT INTO `haier`.`eb_euser` ( `ent_id`, `login_name`, `login_password`, `ent_code`, `user_name`, `state`, `frozen_state`, `logged_state`, `office_no`, `mobile_no`, `email`, `weixin_no`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modifier_id`, `remove_flag`, `remove_date`, `remover_id`, `notes`, `count`, `review_date`, `reviewer_id`, `audit_date`, `auditor_id`, `reject`)
VALUES ( '261', 'yangpengxing', 'E10ADC3949BA59ABBE56E057F20F883E', 'SCM00376530', '杨朋兴', '2', '0', '1', '0523-86848304', '1529557850', 'jstz-101.com@163.com', '', '20190307', '141514', '0', NULL, NULL, '0', NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `haier`.`eb_euser` ( `ent_id`, `login_name`, `login_password`, `ent_code`, `user_name`, `state`, `frozen_state`, `logged_state`, `office_no`, `mobile_no`, `email`, `weixin_no`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modifier_id`, `remove_flag`, `remove_date`, `remover_id`, `notes`, `count`, `review_date`, `reviewer_id`, `audit_date`, `auditor_id`, `reject`)
VALUES ( '261', 'zhangjing', 'E10ADC3949BA59ABBE56E057F20F883E', 'SCM00376530', '张静', '2', '0', '0', '0523-86848329', '15850889845', 'jstz-101.com@163.com', '', '20190307', '142540', '1733', NULL, NULL, '0', NULL, NULL, '', '0', NULL, NULL, NULL, NULL, NULL);

INSERT INTO `haier`.`eb_euser_ext` (`euser_id`, `icno`, `cert_type`, `cert_a_path`, `cert_b_path`, `proxy_path`, `post_flag`, `shortcut_menu`, `euser_ip`) VALUES ('2189', '321281199209104210', '01', '', '', '', '2', NULL, NULL);
INSERT INTO `haier`.`eb_euser_ext` (`euser_id`, `icno`, `cert_type`, `cert_a_path`, `cert_b_path`, `proxy_path`, `post_flag`, `shortcut_menu`, `euser_ip`) VALUES ('2190', '321202198709184528', '01', '', '', '', '2', NULL, NULL);


INSERT INTO `haier`.`eb_r_euser_role` (`euser_id`, `role_id`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ( '2189', '23', NULL, '20190307', NULL, '0', NULL, NULL, NULL);
INSERT INTO `haier`.`eb_r_euser_role` (`euser_id`, `role_id`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ( '2190', '24', NULL, '20190307', NULL, '1681', NULL, NULL, NULL);




