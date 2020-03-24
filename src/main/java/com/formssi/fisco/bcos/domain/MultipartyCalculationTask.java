package com.formssi.fisco.bcos.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@ApiModel(value = "com-formssi-fisco.bcos-domain-MultipartyCalculationTask")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultipartyCalculationTask {
    @ApiModelProperty(value = "")
    private Integer id;

    private   List<TaskMember> taskMemberList;

    /**
     * 多方计算任务的名称
     */
    @ApiModelProperty(value = "多方计算任务的名称")
    private String name;

    /**
     * 任务编号
     */
    @ApiModelProperty(value = "任务编号")
    private String no;

    /**
     * 多方计算任务的参与方的数量，如果数量为1 是单方参与的， 如果参数的数量大于1 为多方参与计算
     */
    @ApiModelProperty(value = "多方计算任务的参与方的数量，如果数量为1 是单方参与的， 如果参数的数量大于1 为多方参与计算")
    private Integer joinCount;

    /**
     * 数据量，成功参与的才有数据量
     */
    @ApiModelProperty(value = "数据量，成功参与的才有数据量")
    private Integer dataAmount;

    /**
     * 数据来源
     */
    @ApiModelProperty(value = "数据来源")
    private Integer dataSource;

    /**
     * 额外数据集的名称
     */
    @ApiModelProperty(value = "额外数据集的名称")
    private String dataName;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private Integer createUserId;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createUserName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 任务完成时间
     */
    @ApiModelProperty(value = "任务完成时间")
    private Date finishTime;

    /**
     * 上链时间
     */
    @ApiModelProperty(value = "上链时间")
    private Date toChainTime;

    /**
     * 0 等待中  1 正在进行 2 成功 -1 失败 -2 有人拒绝了 -3 为草稿
     */
    @ApiModelProperty(value = " 0 等待中  1 正在进行 2 成功 -1 失败 -2 有人拒绝了")
    private Integer status;

    /**
     * 结果文件的路径
     */
    @ApiModelProperty(value = " 结果文件的路径")
    private String resultFilePath;

    /**
     * 0 未上链 1 已上链，但是未回调 2.上链成功
     */
    @ApiModelProperty(value = " 0 未上链 1 已上链，但是未回调 2.上链成功 ")
    private Integer toChainStatus;

    /**
     * 存证地址
     */
    @ApiModelProperty(value = "存证地址")
    private String certificate;

    /**
     * 区块高度
     */
    @ApiModelProperty(value = "区块高度")
    private Integer chainHight;

    /**
     * 描述信息
     */
    @ApiModelProperty(value = "描述信息")
    private String desription;
}