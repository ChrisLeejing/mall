package com.example.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mall.common.utils.PageUtils;
import com.example.mall.common.utils.Query;
import com.example.mall.product.dao.CategoryDao;
import com.example.mall.product.entity.CategoryEntity;
import com.example.mall.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryEntities = super.baseMapper.selectList(null);

        // 找出第一级父节点(parentId=0)
        List<CategoryEntity> entities = categoryEntities.stream()
                .filter(item -> item.getParentCid() == 0)
                .map((parent) -> {
                    parent.setChildren(getChildren(parent, categoryEntities));
                    return parent;
                })
                .sorted((e1, e2) -> (e1.getSort() == null ? 0 : e1.getSort()) - (e2.getSort() == null ? 0 : e2.getSort())) // 升序
                // .sorted((e1, e2) -> (e2.getSort() == null ? 0 : e2.getSort()) - (e1.getSort() == null ? 0 : e1.getSort())) // 降序
                // .sorted(Comparator.comparingInt(e -> (e.getSort() == null ? 0 : e.getSort()))) // 升序
                // .sorted(Comparator.comparing((CategoryEntity::getSort)).reversed()) //降序
                .collect(Collectors.toList());

        return entities;
    }

    /**
     * @param parent           父节点
     * @param categoryEntities 所有节点
     * @return
     */
    private List<CategoryEntity> getChildren(CategoryEntity parent, List<CategoryEntity> categoryEntities) {
        List<CategoryEntity> children = categoryEntities.stream()
                .filter((entity) -> entity.getParentCid().equals(parent.getCatId()))
                .map(root -> {
                    root.setChildren(getChildren(root, categoryEntities));
                    return root;
                })
                // .sorted((e1, e2) -> (e1.getSort() == null ? 0 : e1.getSort()) - (e2.getSort() == null ? 0 : e2.getSort())) // 升序
                // .sorted((e1, e2) -> (e2.getSort() == null ? 0 : e2.getSort()) - (e1.getSort() == null ? 0 : e1.getSort())) // 降序
                .sorted(Comparator.comparingInt(e -> (e.getSort() == null ? 0 : e.getSort())))
                .collect(Collectors.toList());

        return children;
    }

}