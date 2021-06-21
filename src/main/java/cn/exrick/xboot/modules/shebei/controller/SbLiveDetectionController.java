package cn.exrick.xboot.modules.shebei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.shebei.entity.SbLiveDetection;
import cn.exrick.xboot.modules.shebei.query.SbLiveDetectionQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.shebei.service.SbLiveDetectionService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 设备带电测试记录表 controller
 * @author chenfeixiang
 * @since 2021-06-21
 */
@RestController
@RequestMapping("/shebei/sbLiveDetection")
@Slf4j
@ApiModel(value="SbLiveDetection对象", description="设备带电测试记录表")
@Api(tags = "shebei-设备带电测试记录表")
public class SbLiveDetectionController {

    @Autowired
    private SbLiveDetectionService sbLiveDetectionService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbLiveDetection> saveOrUpdate(@Valid @RequestBody SbLiveDetection sbLiveDetection){
        try {
            sbLiveDetectionService.saveOrUpdate(sbLiveDetection);
            return  ResultUtil.data(sbLiveDetection);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
    /**
     * @desc 分页列表查询
     * @param query 分页查询对象
     * @return 分页结果集
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    public Result<Page<SbLiveDetection>> list(PageVo pageVo,SbLiveDetectionQuery query) {
        QueryWrapper<SbLiveDetection> queryWrapper = new QueryWrapper<SbLiveDetection>() ;
        //TODO 条件待填写
        Page page = sbLiveDetectionService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbLiveDetectionService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbLiveDetection> getById(BaseReqVO request) {
        try {
            SbLiveDetection sbLiveDetection = sbLiveDetectionService.getById(request.getId());
            return  ResultUtil.data(sbLiveDetection);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

