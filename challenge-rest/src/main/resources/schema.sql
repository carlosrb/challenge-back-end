/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  carlos
 * Created: 28/09/2019
 */

create table category (id Long, name Varchar(80));

create table product (id Long, name Varchar(80));

create table category_product (
    category_id Long, 
    product_id Long, 
    FOREIGN KEY (category_id) REFERENCES category(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);