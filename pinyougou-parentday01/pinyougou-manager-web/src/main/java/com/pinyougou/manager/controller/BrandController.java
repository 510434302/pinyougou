package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.Page;
import com.pinyougou.entity.Result;
import com.pinyougou.entity.pageResult;
import com.pinyougou.pojo.TbBrand;

import com.pinyougou.sellergoods.service.BrandService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    /**
     * 查询品牌列表,不分页
     *
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

    /**
     * 分页查询品牌列表
     *
     * @param page :当前页码
     * @param size :每页显示的记录数
     * @return
     */
    @RequestMapping("/findPage")
    @ResponseBody
    public pageResult findPage(int page, int size) {
        return brandService.findPage(page, size);
    }

    /**
     * 新增一条品牌信息
     *
     * @param brand:品牌
     * @return
     */
    @RequestMapping("/addBrand")
    public Result addBrand(@RequestBody TbBrand brand) {
        return brandService.addBrand(brand);

    }
}
