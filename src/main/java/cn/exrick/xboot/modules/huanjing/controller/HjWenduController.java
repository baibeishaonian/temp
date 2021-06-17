package cn.exrick.xboot.modules.huanjing.controller;

import cn.exrick.xboot.common.enums.EnumLinkState;
import cn.exrick.xboot.common.enums.EnumTemperatureAlarmState;
import cn.exrick.xboot.modules.huanjing.dto.HjWenduDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.huanjing.entity.HjWendu;
import cn.exrick.xboot.modules.huanjing.query.HjWenduQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.huanjing.service.HjWenduService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 温度监视表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/huanjing/hjWendu")
@Slf4j
@ApiModel(value="HjWendu对象", description="温度监视表")
@Api(tags = "huanjing-温度监视表")
public class HjWenduController {

    @Autowired
    private HjWenduService hjWenduService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<HjWendu> saveOrUpdate(@Valid @RequestBody HjWendu hjWendu){
        try {
            hjWenduService.saveOrUpdate(hjWendu);
            return  ResultUtil.data(hjWendu);
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
    public Result<Page<HjWendu>> list(PageVo pageVo,HjWenduQuery query) {
        QueryWrapper<HjWendu> queryWrapper = new QueryWrapper<HjWendu>() ;
        //TODO 条件待填写
        Page page = hjWenduService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             hjWenduService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<HjWendu> getById(BaseReqVO request) {
        try {
            HjWendu hjWendu = hjWenduService.getById(request.getId());
            return  ResultUtil.data(hjWendu);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "温度首页统计",notes = "参数 变电站id")
    @GetMapping("/temperatureCount")
    public Result<HjWenduDTO> temperatureCount(BaseReqVO request) {
        try {
            HjWenduDTO hjWenduDTO = new HjWenduDTO();
            Integer totalNum = hjWenduService.count(new QueryWrapper<HjWendu>().lambda().eq(HjWendu::getSiteId, request.getSiteId()));
            hjWenduDTO.setTotalNum(totalNum);
            Integer alarmNum = hjWenduService.count(new QueryWrapper<HjWendu>().lambda()
                    .eq(HjWendu::getSiteId, request.getSiteId())
                    .eq(HjWendu::getAlarmState, EnumTemperatureAlarmState.Alarm.getValue())
            );
            hjWenduDTO.setAlarmNum(alarmNum);
            HjWendu hjWendus = hjWenduService.getBaseMapper().selectOne(new QueryWrapper<HjWendu>().lambda().eq(HjWendu::getSiteId, request.getSiteId()).orderByAsc(HjWendu::getWenduValue).last("limit 1"));
            hjWenduDTO.setMaximumTemperature(hjWendus.getWenduValue());
            Integer abnormalCommunication = hjWenduService.count(new QueryWrapper<HjWendu>().lambda().eq(HjWendu::getSiteId, request.getSiteId()).eq(HjWendu::getLinkState, EnumLinkState.Processed.getValue()));
            hjWenduDTO.setAbnormalCommunication(abnormalCommunication);
            return  ResultUtil.data(hjWenduDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

