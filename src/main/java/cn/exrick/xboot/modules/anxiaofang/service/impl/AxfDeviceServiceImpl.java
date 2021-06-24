package cn.exrick.xboot.modules.anxiaofang.service.impl;


import cn.exrick.xboot.common.enums.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.anxiaofang.dto.AccessControlInformationDTO;
import cn.exrick.xboot.modules.anxiaofang.dto.ElectronicFenceDTO;
import cn.exrick.xboot.modules.anxiaofang.dto.FirefightovweviewDTO;
import cn.exrick.xboot.modules.anxiaofang.dto.InfraredRadiationCountDTO;
import cn.exrick.xboot.modules.anxiaofang.service.AxfDeviceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.anxiaofang.entity.AxfDevice;
import cn.exrick.xboot.modules.anxiaofang.dao.AxfDeviceDao;

/**
 * @desc 安消防设备监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class AxfDeviceServiceImpl extends ServiceImpl<AxfDeviceDao, AxfDevice> implements AxfDeviceService {

    @Autowired
    AxfDeviceDao axfDeviceDao;

    @Override
    public FirefightovweviewDTO fireFightingOvweview(BaseReqVO request) {
    try {
        //
        FirefightovweviewDTO firefightovweviewDTO = new FirefightovweviewDTO();
        int total = this.count(new QueryWrapper<AxfDevice>().lambda()
                .eq(AxfDevice::getSiteId, request.getSiteId()));
        this.count(new QueryWrapper<AxfDevice>().lambda()
                .eq(AxfDevice::getSiteId, request.getSiteId())
        );
        firefightovweviewDTO.setTotalFireFightingNum(total);
        return firefightovweviewDTO;
    }catch (Exception e){
        e.printStackTrace();
        return null;
    }
    }

    @Override
    public InfraredRadiationCountDTO infraredRadiationCount(BaseReqVO request) {
        InfraredRadiationCountDTO infraredRadiationCountDTO = new InfraredRadiationCountDTO();
        int count = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.InfraredRadiationInformation.getValue()));
        infraredRadiationCountDTO.setTotalNum(count);
        int alarmNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.InfraredRadiationInformation.getValue()).eq(AxfDevice::getAlarmState, EnumAlarmStateType.Processed.getValue()));
        infraredRadiationCountDTO.setAlarmNum(alarmNum);
        int deviceFailueNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.InfraredRadiationInformation.getValue()).eq(AxfDevice::getDeviceState, EnumInfraredRadiationState.DeviceFailure.getValue()));
        infraredRadiationCountDTO.setDeviceFailureNum(deviceFailueNum);
        int abnormalCommunicationNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.InfraredRadiationInformation.getValue()).eq(AxfDevice::getDeviceState, EnumInfraredRadiationState.AbnormalCommunication.getValue()));
        infraredRadiationCountDTO.setAbnormalPowerSupplyNum(abnormalCommunicationNum);
        return infraredRadiationCountDTO;
    }

    @Override
    public InfraredRadiationCountDTO infraredDoubleDetector(BaseReqVO request) {
        InfraredRadiationCountDTO infraredRadiationCountDTO = new InfraredRadiationCountDTO();
        int count = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.InfraredDoubleDetector.getValue()));
        infraredRadiationCountDTO.setTotalNum(count);
        int alarmNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.InfraredDoubleDetector.getValue()).eq(AxfDevice::getAlarmState, EnumAlarmStateType.Processed.getValue()));
        infraredRadiationCountDTO.setAlarmNum(alarmNum);
        int deviceFailueNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.InfraredDoubleDetector.getValue()).eq(AxfDevice::getDeviceState, EnumInfraredRadiationState.DeviceFailure.getValue()));
        infraredRadiationCountDTO.setDeviceFailureNum(deviceFailueNum);
        int abnormalCommunicationNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.InfraredDoubleDetector.getValue()).eq(AxfDevice::getDeviceState, EnumInfraredRadiationState.AbnormalCommunication.getValue()));
        infraredRadiationCountDTO.setAbnormalPowerSupplyNum(abnormalCommunicationNum);
        return infraredRadiationCountDTO;
    }

    @Override
    public InfraredRadiationCountDTO cameraInfoCount(BaseReqVO request) {
        InfraredRadiationCountDTO infraredRadiationCountDTO = new InfraredRadiationCountDTO();
        int count = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.Camera.getValue()));
        infraredRadiationCountDTO.setTotalNum(count);
       /* int alarmNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.Camera.getValue()).eq(AxfDevice::getAlarmState, EnumAlarmStateType.Processed.getValue()));
        infraredRadiationCountDTO.setAlarmNum(alarmNum);*/
        int deviceFailueNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.Camera.getValue()).eq(AxfDevice::getDeviceState, EnumInfraredRadiationState.DeviceFailure.getValue()));
        infraredRadiationCountDTO.setDeviceFailureNum(deviceFailueNum);
        int abnormalCommunicationNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.Camera.getValue()).eq(AxfDevice::getDeviceState, EnumInfraredRadiationState.AbnormalCommunication.getValue()));
        infraredRadiationCountDTO.setAbnormalPowerSupplyNum(abnormalCommunicationNum);
        return infraredRadiationCountDTO;
    }

    @Override
    public ElectronicFenceDTO electronicFenceNum(BaseReqVO request) {
        ElectronicFenceDTO electronicFenceDTO = new ElectronicFenceDTO();
        int count = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.ElectricFence.getValue()));
        electronicFenceDTO.setTotalNum(count);
       /* int alarmNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.Camera.getValue()).eq(AxfDevice::getAlarmState, EnumAlarmStateType.Processed.getValue()));
        infraredRadiationCountDTO.setAlarmNum(alarmNum);*/
        int deploymentStatusNuM = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.ElectricFence.getValue()).eq(AxfDevice::getNodeType, EnumNodeType.DeploymentStatus.getValue()));
        electronicFenceDTO.setDeploymentNum(deploymentStatusNuM);
        int theStateOfWithdrawal = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.ElectricFence.getValue()).eq(AxfDevice::getNodeType, EnumNodeType.TheStateOfWithdrawal.getValue()));
        electronicFenceDTO.setWithdrawalNum(theStateOfWithdrawal);
        int deviceFailueNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.ElectricFence.getValue()).eq(AxfDevice::getDeviceState, EnumInfraredRadiationState.AbnormalCommunication.getValue()));
        electronicFenceDTO.setCommunicationNum(deviceFailueNum);
        int abnormalCommunicationNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.ElectricFence.getValue()).eq(AxfDevice::getDeviceState, EnumInfraredRadiationState.AbnormalPowerSupply.getValue()));
        electronicFenceDTO.setAbnormalNum(abnormalCommunicationNum);
        int alarmNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.ElectricFence.getValue()).eq(AxfDevice::getAlarmState, EnumAlarmStateType.Processed.getValue()));
        electronicFenceDTO.setAlarmNum(alarmNum);
        return electronicFenceDTO;
    }

    @Override
    public AccessControlInformationDTO accessControlInformation(BaseReqVO request) {
        AccessControlInformationDTO accessControlInformationDTO = new AccessControlInformationDTO();
        int count = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.AccessControlInformationMonitoring.getValue()));
        accessControlInformationDTO.setTotalNum(count);
        int openNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.AccessControlInformationMonitoring.getValue()).eq(AxfDevice::getOpenFlag, EnumOpenFlag.Open.getValue()));
        accessControlInformationDTO.setOpenFlag(openNum);
        int controllerFailureNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.AccessControlInformationMonitoring.getValue()).eq(AxfDevice::getDeviceState, EnumInfraredRadiationState.ControllerFailure.getValue()));
        accessControlInformationDTO.setControllerFailure(controllerFailureNum);
        int abnormalCommunicationNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.AccessControlInformationMonitoring.getValue()).eq(AxfDevice::getDeviceState, EnumInfraredRadiationState.AbnormalCommunication.getValue()));
        accessControlInformationDTO.setCommunicationNum(abnormalCommunicationNum);
        int alarmNum = this.count(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getSiteId, request.getSiteId()).eq(AxfDevice::getDeviceType, EnumAxfDeviceType.AccessControlInformationMonitoring.getValue()).eq(AxfDevice::getAlarmState, EnumAlarmStateType.Processed.getValue()));
        accessControlInformationDTO.setAlarmNum(alarmNum);
        return accessControlInformationDTO;
    }
}
