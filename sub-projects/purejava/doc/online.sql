START TRANSACTION;
#新增res
INSERT INTO `haier_mgt`.`eb_res` (`name`, `url`, `descr`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ('付款方式设置-新增付款方式信息', 'pay-type-dictionary/add-pay-type-dictionary.json', '付款方式设置-新增付款方式信息', '1', '20190124', '120000', '0', '20190124', '120000', '0');
set @resId1=(select last_insert_id());
INSERT INTO `haier_mgt`.`eb_res` (`name`, `url`, `descr`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ('付款方式设置-根据id修改付款方式信息', 'pay-type-dictionary/update-pay-type-dictionary-by-id.json', '付款方式设置-根据id修改付款方式信息', '1', '20190124', '120000', '0', '20190124', '120000', '0');
set @resId2=(select last_insert_id());
INSERT INTO `haier_mgt`.`eb_res` (`name`, `url`, `descr`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ('付款方式设置-根据id删除付款方式信息', 'pay-type-dictionary/delete-pay-type-dictionary-by-id.json', '付款方式设置-根据id删除付款方式信息', '1', '20190124', '120000', '0', '20190124', '120000', '0');
set @resId3=(select last_insert_id());

#新增权限码
INSERT INTO `haier`.`eb_power` (`code`, `name`, `notes`, `type`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ('MGT00423', '付款方式设置-新增', '付款方式设置-新增', '02', '1', '20190124', '120000', '0', '20190124', '120000', '0');
INSERT INTO `haier`.`eb_power` (`code`, `name`, `notes`, `type`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ('MGT00424', '付款方式设置-修改', '付款方式设置-修改', '02', '1', '20190124', '120000', '0', '20190124', '120000', '0');
INSERT INTO `haier`.`eb_power` (`code`, `name`, `notes`, `type`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ('MGT00425', '付款方式设置-删除', '付款方式设置-删除', '02', '1', '20190124', '120000', '0', '20190124', '120000', '0');

#新增res与权限关系
INSERT INTO `haier_mgt`.`eb_r_res_power` (`res_id`, `power_code`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES (@resId1, 'MGT00423', '1', '20190124', '120000', '0', '20190124', '120000', '0');
INSERT INTO `haier_mgt`.`eb_r_res_power` (`res_id`, `power_code`, `is_e n  nable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES (@resId2, 'MGT00424', '1', '20190124', '120000', '0', '20190124', '120000', '0');
INSERT INTO `haier_mgt`.`eb_r_res_power` (`res_id`, `power_code`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES (@resId3, 'MGT00425', '1', '20190124', '120000', '0', '20190124', '120000', '0');

#新增权限分组关系
INSERT INTO `haier`.`eb_power_group` (`group_code`, `group_name`, `parent_group_code`, `power_code`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ('MGTPG054', '付款方式设置', 'MGTPG100', 'MGT00423', '1', '20190124', '120000', '0', '20190124', '120000', '0');
INSERT INTO `haier`.`eb_power_group` (`group_code`, `group_name`, `parent_group_code`, `power_code`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ('MGTPG054', '付款方式设置', 'MGTPG100', 'MGT00424', '1', '20190124', '120000', '0', '20190124', '120000', '0');
INSERT INTO `haier`.`eb_power_group` (`group_code`, `group_name`, `parent_group_code`, `power_code`, `is_enable`, `create_date`, `create_time`, `creator_id`, `modify_date`, `modify_time`, `modifier_id`) VALUES ('MGTPG054', '付款方式设置', 'MGTPG100', 'MGT00425', '1', '20190124', '120000', '0', '20190124', '120000', '0');
commit;