package com.example.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mall.common.utils.PageUtils;
import com.example.mall.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author Coir
 * @email chrisleejing0710@gmail.com
 * @date 2022-03-05 17:04:51
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

