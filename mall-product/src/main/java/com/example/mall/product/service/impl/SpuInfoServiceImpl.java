package com.example.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mall.common.utils.PageUtils;
import com.example.mall.common.utils.Query;
import com.example.mall.product.dao.SpuInfoDao;
import com.example.mall.product.entity.SpuInfoEntity;
import com.example.mall.product.service.SpuInfoService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<SpuInfoEntity>()
        );

        return new PageUtils(page);
    }

}