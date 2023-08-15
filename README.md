# apia-aplicacion
2-
  alter table tarjetacredito add constraint FKpuymbt9it5gd8qpw6obwcpdf foreign key (persona_id) references persona (persona_id);
  
 DROP TABLE IF EXISTS `pruebas`.`tarjetacredito`;
CREATE TABLE `tarjetacredito` (
  `tarjeta_credito_id` int(10) unsigned NOT NULL auto_increment ,
  `marca_tarjeta` varchar(45) ,
  `numero_tarjeta` varchar(45),
  `importe` double,
  `fecha_vencimiento` datetime,
  `fecha_actual` datetime,
  `persona_id` int ,
  PRIMARY KEY  (`tarjeta_credito_id`),
  foreign key (`persona_id`) references `pruebas`.persona(`persona_id`)
) ENGINE=MyISAM;  


commit;


DROP TABLE IF EXISTS `pruebas`.`persona`;
CREATE TABLE `persona` (
  `persona_id` int(10) unsigned NOT NULL auto_increment ,
  `nombre` varchar(45) ,
  `apellido` varchar(45),
  PRIMARY KEY  (`persona_id`)
) ENGINE=MyISAM;  

commit;
