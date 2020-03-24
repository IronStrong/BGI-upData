package com.formssi.fisco.bcos.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@ApiModel(value = "com-formssi-fisco-bcos-domain-TaskMember")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskMember {
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 任务编号
     */
    @ApiModelProperty(value = "任务编号")
    private String taskNo;

    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号")
    private Integer userId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 角色 0 发起方 1 参与方
     */
    @ApiModelProperty(value = "角色 0 发起方 1 参与方")
    private Integer role;

    /**
     * 状态  0 等待 1 准备好  -2 拒绝 -1 文件校验
     */
    @ApiModelProperty(value = "状态  0 等待 1 准备好  -2 拒绝 -1 文件校验")
    private Integer status;

    /**
     * 历史计算任务的编号， 如果是单方计算的为空， 多方计算的话，必须指定
     */
    @ApiModelProperty(value = "历史计算任务的编号， 如果是单方计算的为空， 多方计算的话，必须指定")
    private String hisoryTaskNo;

    /**
     * 是否保留数据,默认保留   0 保留为个人私有数据 1 保留为共有数据，且他人可见 2 不保留
     */
    @ApiModelProperty(value = "是否保留数据,默认保留   0 保留为个人私有数据 1 保留为共有数据，且他人可见 2 不保留")
    private Integer hisoryDataStatus;

    /**
     * 是否使用历史数据
     */
    @ApiModelProperty(value = "是否使用历史数据")
    private Integer useHisoryData;

    /**
     * fasta文件编号
     */
    @ApiModelProperty(value = "fasta文件编号")
    private String fastaFileUuid;

    /**
     * fasta文件名称
     */
    @ApiModelProperty(value = "fasta文件名称")
    private String fastaFileName;

    /**
     * fasta文件hash
     */
    @ApiModelProperty(value = "fasta文件hash")
    private String fastaFileHash;

    /**
     * 检查状态 0 校验失败  1 检查成功
     */
    @ApiModelProperty(value = "检查状态 0 校验失败  1 检查成功")
    private Integer fastaCheckStatus;

    /**
     * 校验结果，如果成功的话，结果为空，失败的话，记录失败的原因
     */
    @ApiModelProperty(value = "校验结果，如果成功的话，结果为空，失败的话，记录失败的原因")
    private String fastaCheckResult;

    /**
     * 数据量，fasta文件里面包含的序列的数量
     */
    @ApiModelProperty(value = "数据量，fasta文件里面包含的序列的数量")
    private Integer fastaDataAmount;

    /**
     * tsv文件uuid
     */
    @ApiModelProperty(value = "tsv文件uuid")
    private String tsvFileUuid;

    /**
     * tsv文件名称
     */
    @ApiModelProperty(value = "tsv文件名称")
    private String tsvFileName;

    /**
     * tsv文件hash
     */
    @ApiModelProperty(value = "tsv文件hash")
    private String tsvFileHash;

    /**
     * tsv 文件校验状态 0 异常 1 正常
     */
    @ApiModelProperty(value = "tsv 文件校验状态 0 异常 1 正常")
    private Integer tsvCheckStatus;

    /**
     * tsv文件校验结果，如果成功的话，结果为空，失败的话，记录失败的原因
     */
    @ApiModelProperty(value = "tsv文件校验结果，如果成功的话，结果为空，失败的话，记录失败的原因")
    private String tsvCheckResult;

    /**
     * 数据量，tsv文件里面包含的序列的数量
     */
    @ApiModelProperty(value = "数据量，tsv文件里面包含的序列的数量")
    private Integer tsvDataAmount;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 加入时间
     */
    @ApiModelProperty(value = "加入时间")
    private Date joinTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date toChainTime;

    /**
     * 上链状态 0 未上链 1 已上链，但是为回调 2.上链成功
     */
    @ApiModelProperty(value = " 上链状态 0 未上链 1 已上链，但是为回调 2.上链成功 ")
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
     * 是否保留数据,默认保留   0 保留为个人私有数据 1 保留为共有数据，且他人可见 2 不保留
     */
    @ApiModelProperty(value = "是否保留数据,默认保留   0 保留为个人私有数据 1 保留为共有数据，且他人可见 2 不保留")
    private Integer saveData;

    /**
     * 是否保留结果,默认保留 0 不保留 1 保留
     */
    @ApiModelProperty(value = "是否保留结果,默认保留 0 不保留 1 保留")
    private Integer saveResult;
}