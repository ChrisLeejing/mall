package com.example.mall.product;

// import org.junit.jupiter.api.Test;
import com.example.mall.product.entity.BrandEntity;
import com.example.mall.product.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("huawei");
        brandService.save(brandEntity);
        System.out.println("保存成功..");
    }

}
