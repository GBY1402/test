drop table if exists sys_user;
drop table if exists sys_organization;
drop table if exists sys_resource;
drop table if exists sys_role;

create table sys_user (
  id bigint auto_increment,
  organization_id bigint,
  username varchar(100),
  password varchar(100),
  salt varchar(100),
  role_ids varchar(100),
  locked bool default false,
  constraint pk_sys_user primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_sys_user_username on sys_user(username);
create index idx_sys_user_organization_id on sys_user(organization_id);

create table sys_organization (
  id bigint auto_increment,
  name varchar(100),
  parent_id bigint,
  parent_ids varchar(100),
  available bool default false,
  constraint pk_sys_organization primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_sys_organization_parent_id on sys_organization(parent_id);
create index idx_sys_organization_parent_ids on sys_organization(parent_ids);


create table sys_resource (
  id bigint auto_increment,
  name varchar(100),
  type varchar(50),
  url varchar(200),
  parent_id bigint,
  parent_ids varchar(100),
  permission varchar(100),
  available bool default false,
  constraint pk_sys_resource primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_sys_resource_parent_id on sys_resource(parent_id);
create index idx_sys_resource_parent_ids on sys_resource(parent_ids);

create table sys_role (
  id bigint auto_increment,
  role varchar(100),
  description varchar(100),
  resource_ids varchar(100),
  available bool default false,
  constraint pk_sys_role primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_sys_role_resource_ids on sys_role(resource_ids);

/*员工信息表
drop table if exists EMPLOYEE;
*/
/*==============================================================*/
/* Table: EMPLOYEE                                              */
/*==============================================================*/
CREATE TABLE `core_employee` (
  `PKID` varchar(128) NOT NULL COMMENT '编号编号',
  `JOBNUM` varchar(20) NOT NULL COMMENT '工号',
  `NAME` varchar(20) NOT NULL COMMENT '名称',
  `SEX` varchar(10) NOT NULL COMMENT '性别',
  `AGE` int(11) NOT NULL COMMENT '年龄',
  `DEPT` int(11) NOT NULL,
  `CONTRACTID` varchar(40) DEFAULT NULL COMMENT '合同编号',
  `PHONE` varchar(20) NOT NULL COMMENT '联系方式',
  `CARDID` varchar(18) NOT NULL COMMENT '身份证号',
  `ENTRYTIME` date NOT NULL COMMENT '入职时间',
  `REGULARTIME` date DEFAULT NULL COMMENT '转正时间',
  `ISORREGULAR` int(11) NOT NULL COMMENT '是否转正',
  `CONTRACTSTARTTIME` date DEFAULT NULL COMMENT '合同起始时间',
  `CONTRACTENDTIME` date DEFAULT NULL COMMENT '合同终止时间',
  `JOB` varchar(20) NOT NULL COMMENT '岗位',
  `SKILL` varchar(100) NOT NULL COMMENT '技能',
  `TOSCHOOL` varchar(50) DEFAULT NULL COMMENT '毕业院校',
  `MAJOR` varchar(30) DEFAULT NULL COMMENT '专业',
  `BIRTHDAY` date NOT NULL COMMENT '出生年月',
  `MARITALSTATUS` int(11) NOT NULL COMMENT '婚姻状况',
  `DOMICILEPLACE` varchar(100) NOT NULL COMMENT '户口所在地',
  `HOMEADDRESS` varchar(100) NOT NULL COMMENT '家庭地址',
  `EMERGENCYCONTACT` varchar(20) DEFAULT NULL COMMENT '紧急联络人',
  `EMERGENCYCONTACTPHONE` varchar(20) DEFAULT NULL COMMENT '紧急联络方式',
  `RECRUITMENTCHANNEL` int(11) NOT NULL COMMENT '招聘渠道',
  `STATETYPE` int(11) NOT NULL,
  `ISYEARLEAVE` int(11) DEFAULT NULL COMMENT '是否有年假',
  PRIMARY KEY (`PKID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*通知公告表
drop table if exists EMPLOYEE;
*/
/*==============================================================*/
/* Table: INFORMNOTICE                                              */
/*==============================================================*/
CREATE TABLE `core_informnotice` (
  `id` varchar(128) NOT NULL DEFAULT '',
  `title` varchar(20) NOT NULL,
  `content` varchar(5000) NOT NULL,
  `creater` varchar(20) DEFAULT NULL,
  `createDateTime` varchar(20) DEFAULT NULL,
  `isPublishState` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

