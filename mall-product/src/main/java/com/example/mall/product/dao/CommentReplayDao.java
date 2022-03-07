package com.example.mall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.product.entity.CommentReplayEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 *
 * @author Coir
 * @email chrisleejing0710@gmail.com
 * @date 2022-03-05 17:04:51
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {

}
