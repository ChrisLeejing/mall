package com.example.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mall.common.utils.PageUtils;
import com.example.mall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author Coir
 * @email chrisleejing0710@gmail.com
 * @date 2022-03-05 17:04:51
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

