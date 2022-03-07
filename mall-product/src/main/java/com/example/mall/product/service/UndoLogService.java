package com.example.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mall.common.utils.PageUtils;
import com.example.mall.product.entity.UndoLogEntity;

import java.util.Map;

/**
 * @author Coir
 * @email chrisleejing0710@gmail.com
 * @date 2022-03-05 17:04:51
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

