package org.gosky.nga.common.config;

/**
 * Created by guozhong on 16/10/28.
 */

public interface DataConfig {
    String[] money = new String[]{"500元",
            "1000元", "2000元", "3000元", "4000元", "5000元", "6000元", "7000元", "8000元", "9000元", "10000元", "15000元", "20000元", "25000元", "30000元", "40000元", "50000元", "10万元", "50万元", "100万元",};
    String[] months = new String[]{"1个月", "2个月", "3个月", "4个月", "5个月", "6个月", "7个月", "8个月", "9个月", "10个月", "11个月", "12个月", "24个月", "36个月"};
    String[] jobs = new String[]{"上班族", "个体户", "学生"};
    String[] yesORno = new String[]{"是", "否"};
    String[] mobilelong = new String[]{"1-5个月", "6个月以上"};
    String[] loanNames = new String[]{"飞贷-大额贷款", "闪银-学生贷", "闪银-信用贷", "闪电借款-小额现金贷", "钱站-白领贷", "量化派-信用钱包",
            "还呗-信用卡代还", "贷款王-现金贷", "融360-信用贷", "给你花-学生贷", "给你花-信用贷", "积木盒子-读秒", "现金巴士-十万火急", "拍拍贷-极速贷",
            "拍拍贷-学生贷", "手机贷-小额贷", "我来贷-极速贷", "平安普惠-应急贷", "平安普惠-i贷", "宜人贷-大额贷", "好贷-贷款专家", "名校贷-小额极速贷",
            "名校贷-小额低息贷", "名校贷-大额极速贷", "叮当贷-极速贷", "发薪贷-小额应急贷", "卡卡贷-信用卡代还", "功夫贷-信用贷", "信而富-现金贷", "你我贷-嘉英贷", "你我贷-嘉卡贷"};
    String[] loanTels = new String[]{"134", "135", "136", "137", "138", "139", "147", "150", "151",
            "152", "157", "158", "159", "178", "182", "183", "184", "187", "188", "130", "131", "132",
            "145", "155", "156", "175", "176", "185", "186", "133", "134", "149", "153", "173", "177", "180", "181", "189"};
    String bannerDatas = "[\n" +
            "    {\n" +
            "      \"autokid\": 5,\n" +
            "      \"id\": 29,\n" +
            "      \"bak\": \"\",\n" +
            "      \"createtime\": \"\",\n" +
            "      \"imagepath\": \"\",\n" +
            "      \"iostarget\": \"\",\n" +
            "      \"reamrk\": \"\",\n" +
            "      \"sort\": \"30\",\n" +
            "      \"type\": \"\",\n" +
            "      \"version\": \"\",\n" +
            "      \"is_deleted\": 0,\n" +
            "      \"row_created_at\": \"2016-10-25 22:20:09\",\n" +
            "      \"row_updated_at\": \"2016-11-14 21:19:12\"\n" +
            "    }\n" +
            "  ]";
    String loanDatas = "[\n" +
            "    {\n" +
            "      \"autokid\": \"60\",\n" +
            "      \"id\": \"64\",\n" +
            "      \"androidpaymenturl\": \"\",\n" +
            "      \"androidtarget\": \"0\",\n" +
            "      \"apply\": \"有信用卡即可申请\",\n" +
            "      \"applycondition\": \"信用卡用户皆可申请\",\n" +
            "      \"applyexplain\": \"审核方式：纯线上审核，无人工参与\\r\\n审核周期：2天内审核，最快1小时\\r\\n放款时间：3天内放款，最快当天放款\\r\\n还款方式：绑定储蓄卡自动划扣，支持提前还款\",\n" +
            "      \"applyimagepath\": \"http://ai.jielema.com:10080/iotglb-openapi/images/\",\n" +
            "      \"applyprocess\": \"\",\n" +
            "      \"buttonname\": \"快速进入\",\n" +
            "      \"category\": \"\",\n" +
            "      \"click\": \"516061\",\n" +
            "      \"comment\": \"1341****323-利率真心挺低|1837****321-刚好要还信用卡，试了下还真借到了|1532****683-能借到钱真心挺haapy\\r\\n\",\n" +
            "      \"company\": \"http://game.kkcredit.cn/download/kdjz/kakaadv1\",\n" +
            "      \"url_h5\": \"http://game.kkcredit.cn/download/kdjzFlow/kakaadv1\",\n" +
            "      \"url_h5_xiaoyu\": \"http://game.kkcredit.cn/download/kdjzlandie/kakaadv1\",\n" +
            "      \"createdate\": \"06月20日\",\n" +
            "      \"createtime\": \"06-20 15:48\",\n" +
            "      \"creditdate\": \"12\",\n" +
            "      \"creditdates\": \",6,12,18,24,\",\n" +
            "      \"creditmaxamount\": \"10000\",\n" +
            "      \"creditminamount\": \"2000\",\n" +
            "      \"defalutcreditdate\": \"12\",\n" +
            "      \"defaultmoney\": \"6000\",\n" +
            "      \"defaulttarget\": \"\",\n" +
            "      \"fitpeople\": \"1\",\n" +
            "      \"grouptype\": \"2,9\",\n" +
            "      \"home\": \"1\",\n" +
            "      \"imagepath\": \"https://dn-kdjz.qbox.me/jiedai/icon/64/1479137575.png\",\n" +
            "      \"interest\": \"[\\n    {\\n        \\\"creditdate\\\": 6, \\n        \\\"id\\\": 670, \\n        \\\"monthinterest\\\": \\\"0.9\\\", \\n        \\\"productid\\\": \\\"64\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 12, \\n        \\\"id\\\": 671, \\n        \\\"monthinterest\\\": \\\"0.9\\\", \\n        \\\"productid\\\": \\\"64\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 18, \\n        \\\"id\\\": 672, \\n        \\\"monthinterest\\\": \\\"0.9\\\", \\n        \\\"productid\\\": \\\"64\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 24, \\n        \\\"id\\\": 673, \\n        \\\"monthinterest\\\": \\\"0.9\\\", \\n        \\\"productid\\\": \\\"64\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }\\n]\",\n" +
            "      \"interesttype\": \"2\",\n" +
            "      \"iospaymenturl\": \"\",\n" +
            "      \"iostarget\": \"8\",\n" +
            "      \"iosweixinhome\": \"2$3\",\n" +
            "      \"joincount\": \"639540\",\n" +
            "      \"jumptype\": \"15\",\n" +
            "      \"largeloan\": \"0\",\n" +
            "      \"modifytime\": \"1472912992000\",\n" +
            "      \"money\": \".00\",\n" +
            "      \"monthinterest\": \"0.9\",\n" +
            "      \"monthmoney\": \"184\",\n" +
            "      \"name\": \"卡卡贷-信用卡代还\",\n" +
            "      \"othercomment\": \"申请其他产品,提高成功率\",\n" +
            "      \"otherurl\": \"\",\n" +
            "      \"phone\": \"4001809860\",\n" +
            "      \"process\": \"[\\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_jbxx.png\\\", \\n        \\\"name\\\": \\\"身份认证\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_zxbg.png\\\", \\n        \\\"name\\\": \\\"征信报告\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_bdyhk.png\\\", \\n        \\\"name\\\": \\\"信用卡绑定\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_bdyhk.png\\\", \\n        \\\"name\\\": \\\"银行卡认证\\\"\\n    }\\n]\",\n" +
            "      \"producttype\": \"2\",\n" +
            "      \"producttypeid\": \"0\",\n" +
            "      \"proof\": \"1.手机号实名认证\\r\\n2.信用卡\",\n" +
            "      \"rate\": \"0.9\",\n" +
            "      \"ratearea\": \"0.9%-1.6%\",\n" +
            "      \"ratetype\": \"1\",\n" +
            "      \"refproductid\": \"\",\n" +
            "      \"remark\": \"超低费率代还信用卡，费率低至0.55%，7天免息金，老用户再贷手续费对折，福利多多，还不来贷！\",\n" +
            "      \"repaymenttype\": \"1\",\n" +
            "      \"serial\": \"\",\n" +
            "      \"strategyurl\": \"http://ai.jielema.com:10080/iotglb-openapi/html/raiders_dk2_kkd.html\",\n" +
            "      \"target\": \"1\",\n" +
            "      \"templet\": \"\",\n" +
            "      \"templetid\": \"\",\n" +
            "      \"tips\": \"尝试多种贷款产品，能大大提高您的贷款成功率|请确保信息完整准确，可以减少审核时间，快速放款|信用是一个人最大的无形资产，请珍惜您的信用\",\n" +
            "      \"totalinterest\": \"216\",\n" +
            "      \"usetime\": \"60\",\n" +
            "      \"version\": \"0\",\n" +
            "      \"weixindetail\": \"公积金/社保授权，无不良记录\",\n" +
            "      \"weixinno\": \"\",\n" +
            "      \"weixinserial\": \"45\",\n" +
            "      \"weixintarget\": \"\",\n" +
            "      \"order_\": \"1500\",\n" +
            "      \"order_home\": \"1000\",\n" +
            "      \"havacreditcard\": \"1\",\n" +
            "      \"is_deleted\": \"0\",\n" +
            "      \"row_created_at\": \"2016-09-03 22:30:06\",\n" +
            "      \"row_updated_at\": \"2016-11-24 22:32:45\",\n" +
            "      \"order_group_0\": \"0\",\n" +
            "      \"order_group_1\": \"0\",\n" +
            "      \"order_group_2\": \"50\",\n" +
            "      \"order_group_3\": \"0\",\n" +
            "      \"order_group_4\": \"0\",\n" +
            "      \"order_group_6\": \"0\",\n" +
            "      \"order_group_7\": \"0\",\n" +
            "      \"order_group_8\": \"0\",\n" +
            "      \"order_group_9\": \"0\",\n" +
            "      \"is_hot\": \"1\",\n" +
            "      \"success_rate\": \"98.00\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"autokid\": \"49\",\n" +
            "      \"id\": \"53\",\n" +
            "      \"androidpaymenturl\": \"\",\n" +
            "      \"androidtarget\": \"0\",\n" +
            "      \"apply\": \"1、申请人年龄需在20周岁（含）至45周岁之间；\\r\\n2、申请人所在户籍或居住地不限（新疆、西藏除外）；\\r\\n3、申请人须收入稳定但工作内容不限\",\n" +
            "      \"applycondition\": \"收入稳定的上班族，年龄在20岁至45岁之间\",\n" +
            "      \"applyexplain\": \"审核周期：纯线上自动审核，最快30分钟\\r\\n放款时间：审核通过后2分钟内放款\\r\\n还款方式：自动扣款或去平台还款，支持提前还款\\r\\n\",\n" +
            "      \"applyimagepath\": \"http://ai.jielema.com:10080/iotglb-openapi/images/\",\n" +
            "      \"applyprocess\": \"\",\n" +
            "      \"buttonname\": \"快速进入\",\n" +
            "      \"category\": \"1\",\n" +
            "      \"click\": \"653681\",\n" +
            "      \"comment\": \"1867****472-随时随地随心贷|1361****414-客服蛮耐心的，给我很多建议，帮我完成贷款申请|1594****536-不错的产品\",\n" +
            "      \"company\": \"http://m.daikuan.2345.com/register?channel=hj-kdjz01_cpk_zyn\",\n" +
            "      \"url_h5\": \"http://m.daikuan.2345.com/register?channel=hj-kdjz02_cpk_zyn\",\n" +
            "      \"url_h5_xiaoyu\": \"http://m.daikuan.2345.com/register?channel=hj-kdjz03_cpk_zyn\",\n" +
            "      \"createdate\": \"03月16日\",\n" +
            "      \"createtime\": \"03-16 17:35\",\n" +
            "      \"creditdate\": \"30\",\n" +
            "      \"creditdates\": \",30,\",\n" +
            "      \"creditmaxamount\": \"5000\",\n" +
            "      \"creditminamount\": \"500\",\n" +
            "      \"defalutcreditdate\": \"30\",\n" +
            "      \"defaultmoney\": \"3000\",\n" +
            "      \"defaulttarget\": \"\",\n" +
            "      \"fitpeople\": \"1$2\",\n" +
            "      \"grouptype\": \"0,3\",\n" +
            "      \"home\": \"1\",\n" +
            "      \"imagepath\": \"https://dn-kdjz.qbox.me/jiedai/icon/53/1479137573.png\",\n" +
            "      \"interest\": \"[\\n    {\\n        \\\"creditdate\\\": 30, \\n        \\\"id\\\": 600, \\n        \\\"monthinterest\\\": \\\"0.1\\\", \\n        \\\"productid\\\": \\\"53\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }\\n]\",\n" +
            "      \"interesttype\": \"\",\n" +
            "      \"iospaymenturl\": \"\",\n" +
            "      \"iostarget\": \"8\",\n" +
            "      \"iosweixinhome\": \"3\",\n" +
            "      \"joincount\": \"602183\",\n" +
            "      \"jumptype\": \"0\",\n" +
            "      \"largeloan\": \"0\",\n" +
            "      \"modifytime\": \"1472912997000\",\n" +
            "      \"money\": \".00\",\n" +
            "      \"monthinterest\": \"\",\n" +
            "      \"monthmoney\": \"168\",\n" +
            "      \"name\": \"贷款王-现金贷\",\n" +
            "      \"othercomment\": \"申请其他产品,提高成功率\",\n" +
            "      \"otherurl\": \"\",\n" +
            "      \"phone\": \"400-839-8687\",\n" +
            "      \"process\": \"[\\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_jbxx.png\\\", \\n        \\\"name\\\": \\\"身份认证\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_bdyhk.png\\\", \\n        \\\"name\\\": \\\"银行卡认证\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_sfz.png\\\", \\n        \\\"name\\\": \\\"基本信息\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_sprz.png\\\", \\n        \\\"name\\\": \\\"视频认证\\\"\\n    }\\n]\",\n" +
            "      \"producttype\": \"1\",\n" +
            "      \"producttypeid\": \"0\",\n" +
            "      \"proof\": \"1、个人工作基本信息；\\r\\n2、需实名验证；\",\n" +
            "      \"rate\": \"0.1\",\n" +
            "      \"ratearea\": \"0.1%\",\n" +
            "      \"ratetype\": \"2\",\n" +
            "      \"refproductid\": \"\",\n" +
            "      \"remark\": \"1、只需身份证，立即享有5000元现金贷款\\r\\n2、极速30分钟审批，立即拿到借款额度\\r\\n3、提现2分钟到账，直接打入绑定银行卡\\r\\n4、有借有还，额度将持续提升\",\n" +
            "      \"repaymenttype\": \"2\",\n" +
            "      \"serial\": \"\",\n" +
            "      \"strategyurl\": \"http://ai.jielema.com:10080/iotglb-openapi/html/raiders_dk2_dkw.html\",\n" +
            "      \"target\": \"1\",\n" +
            "      \"templet\": \"\",\n" +
            "      \"templetid\": \"\",\n" +
            "      \"tips\": \"\",\n" +
            "      \"totalinterest\": \"24\",\n" +
            "      \"usetime\": \"60\",\n" +
            "      \"version\": \"0\",\n" +
            "      \"weixindetail\": \"手持身份证，银行借记卡，3分钟审核\",\n" +
            "      \"weixinno\": \"\",\n" +
            "      \"weixinserial\": \"\",\n" +
            "      \"weixintarget\": \"\",\n" +
            "      \"order_\": \"3000\",\n" +
            "      \"order_home\": \"900\",\n" +
            "      \"havacreditcard\": \"0\",\n" +
            "      \"is_deleted\": \"0\",\n" +
            "      \"row_created_at\": \"2016-09-03 22:30:04\",\n" +
            "      \"row_updated_at\": \"2016-11-24 22:04:07\",\n" +
            "      \"order_group_0\": \"600\",\n" +
            "      \"order_group_1\": \"0\",\n" +
            "      \"order_group_2\": \"0\",\n" +
            "      \"order_group_3\": \"600\",\n" +
            "      \"order_group_4\": \"0\",\n" +
            "      \"order_group_6\": \"0\",\n" +
            "      \"order_group_7\": \"0\",\n" +
            "      \"order_group_8\": \"0\",\n" +
            "      \"order_group_9\": \"0\",\n" +
            "      \"is_hot\": \"0\",\n" +
            "      \"success_rate\": \"99.00\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"autokid\": \"78\",\n" +
            "      \"id\": \"85\",\n" +
            "      \"androidpaymenturl\": \"\",\n" +
            "      \"androidtarget\": \"0\",\n" +
            "      \"apply\": \"18-35岁公民\",\n" +
            "      \"applycondition\": \"18-35岁公民\",\n" +
            "      \"applyexplain\": \"审核周期：纯线上自动审核\\r\\n放款时间：1个工作日之内\\r\\n还款方式：自动划扣／去平台还款\\r\\n\",\n" +
            "      \"applyimagepath\": \"http://112.74.67.63:10080/iotglb-openapi/images/\",\n" +
            "      \"applyprocess\": \"\",\n" +
            "      \"buttonname\": \"立即申请\",\n" +
            "      \"category\": \"1\",\n" +
            "      \"click\": \"140881\",\n" +
            "      \"comment\": \"1867****472-随时随地随心贷|1361****414-客服蛮耐心的，给我很多建议，帮我完成贷款申请|1594****536-不错的产品\",\n" +
            "      \"company\": \"https://www.yangqianguan.com/flexible/index?act=A0mHG\",\n" +
            "      \"url_h5\": \"https://www.yangqianguan.com/flexible/index?act=AelniG\",\n" +
            "      \"url_h5_xiaoyu\": \"https://www.yangqianguan.com/flexible/index?act=pQxQtz\",\n" +
            "      \"createdate\": \"11月01日\",\n" +
            "      \"createtime\": \"11-01 17:46\",\n" +
            "      \"creditdate\": \"28\",\n" +
            "      \"creditdates\": \",1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,\",\n" +
            "      \"creditmaxamount\": \"1000\",\n" +
            "      \"creditminamount\": \"100\",\n" +
            "      \"defalutcreditdate\": \"28\",\n" +
            "      \"defaultmoney\": \"1000\",\n" +
            "      \"defaulttarget\": \"\",\n" +
            "      \"fitpeople\": \"1\",\n" +
            "      \"grouptype\": \"1,6\",\n" +
            "      \"home\": \"1\",\n" +
            "      \"imagepath\": \"https://dn-kdjz.qbox.me/jiedai/icon/85/1479137576.png\",\n" +
            "      \"interest\": \"[\\n    {\\n        \\\"creditdate\\\": 1, \\n        \\\"id\\\": 889, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 2, \\n        \\\"id\\\": 890, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 3, \\n        \\\"id\\\": 891, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 4, \\n        \\\"id\\\": 892, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 5, \\n        \\\"id\\\": 893, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 6, \\n        \\\"id\\\": 894, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 7, \\n        \\\"id\\\": 895, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 8, \\n        \\\"id\\\": 896, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 9, \\n        \\\"id\\\": 897, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 10, \\n        \\\"id\\\": 898, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 11, \\n        \\\"id\\\": 899, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 12, \\n        \\\"id\\\": 900, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 13, \\n        \\\"id\\\": 901, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 14, \\n        \\\"id\\\": 902, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 15, \\n        \\\"id\\\": 903, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 16, \\n        \\\"id\\\": 904, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 17, \\n        \\\"id\\\": 905, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 18, \\n        \\\"id\\\": 906, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 19, \\n        \\\"id\\\": 907, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 20, \\n        \\\"id\\\": 908, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 21, \\n        \\\"id\\\": 909, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 22, \\n        \\\"id\\\": 910, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 23, \\n        \\\"id\\\": 911, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 24, \\n        \\\"id\\\": 912, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 25, \\n        \\\"id\\\": 913, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 26, \\n        \\\"id\\\": 914, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 27, \\n        \\\"id\\\": 915, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 28, \\n        \\\"id\\\": 916, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 29, \\n        \\\"id\\\": 917, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 30, \\n        \\\"id\\\": 918, \\n        \\\"monthinterest\\\": \\\"0.3\\\", \\n        \\\"productid\\\": \\\"85\\\", \\n        \\\"remark\\\": \\\"\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }\\n]\",\n" +
            "      \"interesttype\": \"2\",\n" +
            "      \"iospaymenturl\": \"\",\n" +
            "      \"iostarget\": \"9\",\n" +
            "      \"iosweixinhome\": \"3\",\n" +
            "      \"joincount\": \"542171\",\n" +
            "      \"jumptype\": \"0\",\n" +
            "      \"largeloan\": \"0\",\n" +
            "      \"modifytime\": \"1478758989000\",\n" +
            "      \"money\": \".00\",\n" +
            "      \"monthinterest\": \"0.3\",\n" +
            "      \"monthmoney\": \"172\",\n" +
            "      \"name\": \"现金借款-小额贷\",\n" +
            "      \"othercomment\": \"申请其他产品,提高成功率\",\n" +
            "      \"otherurl\": \"\",\n" +
            "      \"phone\": \"010-52284818\",\n" +
            "      \"process\": \"[\\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_jbxx.png\\\", \\n        \\\"name\\\": \\\"身份认证\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_sprz.png\\\", \\n        \\\"name\\\": \\\"人脸识别\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_bdyhk.png\\\", \\n        \\\"name\\\": \\\"联系人信息\\\"\\n    }\\n]\",\n" +
            "      \"producttype\": \"1\",\n" +
            "      \"producttypeid\": \"0\",\n" +
            "      \"proof\": \"1身份证实名认证\\n2人脸识别\\n3联系人信息\",\n" +
            "      \"rate\": \"0.3\",\n" +
            "      \"ratearea\": \"0.3%\",\n" +
            "      \"ratetype\": \"2\",\n" +
            "      \"refproductid\": \"\",\n" +
            "      \"remark\": \"【现金借款4大优势】\\n【灵活】1-30天自选借款期限，按日计算费用！ \\n【轻松】无需实物抵押，全程线上操作！ \\n【快速】3分钟提交资料，3小时审核完毕！ \\n【便捷】有借有还，再借不难。一次申请成功，永久自动放款！\",\n" +
            "      \"repaymenttype\": \"2\",\n" +
            "      \"serial\": \"97\",\n" +
            "      \"strategyurl\": \"\",\n" +
            "      \"target\": \"1\",\n" +
            "      \"templet\": \"\",\n" +
            "      \"templetid\": \"\",\n" +
            "      \"tips\": \"尝试多种贷款产品，能大大提高您的贷款成功率|请确保信息完整，可减少审核时间，快速放款|信用是一个人最大的无形资产，请珍惜您的信用\",\n" +
            "      \"totalinterest\": \"72\",\n" +
            "      \"usetime\": \"60\",\n" +
            "      \"version\": \"0\",\n" +
            "      \"weixindetail\": \"实名认证，银行卡绑定，手机联系人认证\",\n" +
            "      \"weixinno\": \"\",\n" +
            "      \"weixinserial\": \"\",\n" +
            "      \"weixintarget\": \"\",\n" +
            "      \"order_\": \"2500\",\n" +
            "      \"order_home\": \"600\",\n" +
            "      \"havacreditcard\": \"0\",\n" +
            "      \"is_deleted\": \"0\",\n" +
            "      \"row_created_at\": \"2016-11-10 14:23:19\",\n" +
            "      \"row_updated_at\": \"2016-11-24 22:15:05\",\n" +
            "      \"order_group_0\": \"0\",\n" +
            "      \"order_group_1\": \"600\",\n" +
            "      \"order_group_2\": \"0\",\n" +
            "      \"order_group_3\": \"0\",\n" +
            "      \"order_group_4\": \"0\",\n" +
            "      \"order_group_6\": \"0\",\n" +
            "      \"order_group_7\": \"0\",\n" +
            "      \"order_group_8\": \"0\",\n" +
            "      \"order_group_9\": \"0\",\n" +
            "      \"is_hot\": \"0\",\n" +
            "      \"success_rate\": \"99.00\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"autokid\": \"80\",\n" +
            "      \"id\": \"601\",\n" +
            "      \"androidpaymenturl\": \"\",\n" +
            "      \"androidtarget\": \"0\",\n" +
            "      \"apply\": \"拥有居民身份证公民\",\n" +
            "      \"applycondition\": \"有稳定工作的上班族\",\n" +
            "      \"applyexplain\": \"审核方式：纯线上自动审核，秒出额度\\r\\n放款时间：当天放款，最快3分钟\\r\\n还款方式：自动扣款或去平台还款，随借随还\",\n" +
            "      \"applyimagepath\": \"http://ai.jielema.com:10080/iotglb-openapi/images/\",\n" +
            "      \"applyprocess\": \"\",\n" +
            "      \"buttonname\": \"快速进入\",\n" +
            "      \"category\": \"\",\n" +
            "      \"click\": \"681861\",\n" +
            "      \"comment\": \"1852****489-平安普惠大公司就是靠谱|1361****781-填完资料五分钟不到就开始审核了，速度真心快|1367****318-贷款成功了，开心\",\n" +
            "      \"company\": \"http://www.omsys.com.cn/Pinganwl/index.php?aid=UGluZ2Fud2xfNTE4Nl84MV95ZXM=\",\n" +
            "      \"url_h5\": \"http://www.10100000.com/m/iloan/apply1.html?utm_source=wxhnnxkida--m&utm_medium=cps&utm_campaign=m0018--iln&utm_content=m-KD002&WT.mc_id=CXX-WXHNNXKIDA-KD002-CSM-M0018ILN&\",\n" +
            "      \"url_h5_xiaoyu\": \"http://www.omsys.com.cn/Pinganwl/index.php?aid=UGluZ2Fud2xfNTI5Nl84MV95ZXM=\",\n" +
            "      \"createdate\": \"03月16日\",\n" +
            "      \"createtime\": \"03-16 17:35\",\n" +
            "      \"creditdate\": \"6\",\n" +
            "      \"creditdates\": \",1,3,6,12,18,24,36,\",\n" +
            "      \"creditmaxamount\": \"10000\",\n" +
            "      \"creditminamount\": \"2000\",\n" +
            "      \"defalutcreditdate\": \"6\",\n" +
            "      \"defaultmoney\": \"8000\",\n" +
            "      \"defaulttarget\": \"\",\n" +
            "      \"fitpeople\": \"1\",\n" +
            "      \"grouptype\": \"1,9\",\n" +
            "      \"home\": \"1\",\n" +
            "      \"imagepath\": \"https://dn-kdjz.qbox.me/jiedai/icon/601/1479137576.png\",\n" +
            "      \"interest\": \"[\\n    {\\n        \\\"creditdate\\\": 1, \\n        \\\"id\\\": 615, \\n        \\\"monthinterest\\\": \\\"1.3\\\", \\n        \\\"productid\\\": \\\"59\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 3, \\n        \\\"id\\\": 616, \\n        \\\"monthinterest\\\": \\\"1.3\\\", \\n        \\\"productid\\\": \\\"59\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 6, \\n        \\\"id\\\": 617, \\n        \\\"monthinterest\\\": \\\"1.3\\\", \\n        \\\"productid\\\": \\\"59\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 12, \\n        \\\"id\\\": 618, \\n        \\\"monthinterest\\\": \\\"1.3\\\", \\n        \\\"productid\\\": \\\"59\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 18, \\n        \\\"id\\\": 619, \\n        \\\"monthinterest\\\": \\\"1.3\\\", \\n        \\\"productid\\\": \\\"59\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 24, \\n        \\\"id\\\": 620, \\n        \\\"monthinterest\\\": \\\"1.3\\\", \\n        \\\"productid\\\": \\\"59\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 36, \\n        \\\"id\\\": 621, \\n        \\\"monthinterest\\\": \\\"1.3\\\", \\n        \\\"productid\\\": \\\"59\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }\\n]\",\n" +
            "      \"interesttype\": \"2\",\n" +
            "      \"iospaymenturl\": \"\",\n" +
            "      \"iostarget\": \"8\",\n" +
            "      \"iosweixinhome\": \"3\",\n" +
            "      \"joincount\": \"682133\",\n" +
            "      \"jumptype\": \"0\",\n" +
            "      \"largeloan\": \"0\",\n" +
            "      \"modifytime\": \"1472913003000\",\n" +
            "      \"money\": \".00\",\n" +
            "      \"monthinterest\": \"1.3\",\n" +
            "      \"monthmoney\": \"192\",\n" +
            "      \"name\": \"平安普惠-秒下款\",\n" +
            "      \"othercomment\": \"申请其他产品,提高成功率\",\n" +
            "      \"otherurl\": \"\",\n" +
            "      \"phone\": \"4008580580\",\n" +
            "      \"process\": \"[\\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_jbxx.png\\\", \\n        \\\"name\\\": \\\"实名认证\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_bdyhk.png\\\", \\n        \\\"name\\\": \\\"银行卡认证\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_sprz.png\\\", \\n        \\\"name\\\": \\\"人脸识别\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_ysysq.png\\\", \\n        \\\"name\\\": \\\"运营商授权\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_zxbg.png\\\", \\n        \\\"name\\\": \\\"征信报告\\\"\\n    }\\n]\",\n" +
            "      \"producttype\": \"1\",\n" +
            "      \"producttypeid\": \"0\",\n" +
            "      \"proof\": \"本人身份证、银行卡信息\",\n" +
            "      \"rate\": \"1.3\",\n" +
            "      \"ratearea\": \"1.3%-2.8%\",\n" +
            "      \"ratetype\": \"1\",\n" +
            "      \"refproductid\": \"\",\n" +
            "      \"remark\": \"门槛低，无需材料，不用上门服务\\r\\n速度快，提额易，最快6分钟放款\\r\\n还款易，按日计息，支持多笔借款\",\n" +
            "      \"repaymenttype\": \"1\",\n" +
            "      \"serial\": \"97\",\n" +
            "      \"strategyurl\": \"http://ai.jielema.com:10080/iotglb-openapi/html/raiders_dk2_paph.html\",\n" +
            "      \"target\": \"1\",\n" +
            "      \"templet\": \"\",\n" +
            "      \"templetid\": \"\",\n" +
            "      \"tips\": \"尝试多种贷款产品，能大大提高您的贷款成功率|请确保信息完整准确，可以减少审核时间，快速放款|信用是一个人最大的无形资产，请珍惜您的信用\",\n" +
            "      \"totalinterest\": \"312\",\n" +
            "      \"usetime\": \"60\",\n" +
            "      \"version\": \"0\",\n" +
            "      \"weixindetail\": \"18~55周岁，手持银行卡，最快3分钟放款\",\n" +
            "      \"weixinno\": \"\",\n" +
            "      \"weixinserial\": \"45\",\n" +
            "      \"weixintarget\": \"\",\n" +
            "      \"order_\": \"2700\",\n" +
            "      \"order_home\": \"500\",\n" +
            "      \"havacreditcard\": \"0\",\n" +
            "      \"is_deleted\": \"0\",\n" +
            "      \"row_created_at\": \"2016-09-03 22:30:05\",\n" +
            "      \"row_updated_at\": \"2016-11-28 15:57:43\",\n" +
            "      \"order_group_0\": \"0\",\n" +
            "      \"order_group_1\": \"700\",\n" +
            "      \"order_group_2\": \"10000\",\n" +
            "      \"order_group_3\": \"10000\",\n" +
            "      \"order_group_4\": \"10000\",\n" +
            "      \"order_group_6\": \"0\",\n" +
            "      \"order_group_7\": \"0\",\n" +
            "      \"order_group_8\": \"0\",\n" +
            "      \"order_group_9\": \"0\",\n" +
            "      \"is_hot\": \"0\",\n" +
            "      \"success_rate\": \"100.00\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"autokid\": \"37\",\n" +
            "      \"id\": \"40\",\n" +
            "      \"androidpaymenturl\": \"\",\n" +
            "      \"androidtarget\": \"0\",\n" +
            "      \"apply\": \"18-55周岁，持中国居民身份证的中国大陆公民\",\n" +
            "      \"applycondition\": \"18-55周岁的大陆公民，手机号使用时间超过半年\",\n" +
            "      \"applyexplain\": \"审核周期：5分钟内纯线上自动审核\\r\\n放款时间：1小时内放款\\r\\n还款方式：自动扣款或去平台还款，支持提前还款\",\n" +
            "      \"applyimagepath\": \"http://ai.jielema.com:10080/iotglb-openapi/images/\",\n" +
            "      \"applyprocess\": \"\",\n" +
            "      \"buttonname\": \"快速进入\",\n" +
            "      \"category\": \"3&8\",\n" +
            "      \"click\": \"1463961\",\n" +
            "      \"comment\": \"1387****645-3小时内就放款了..|1860****681-资料填写少，反馈速度快|1860****765-这个速度值得表扬一下!\",\n" +
            "      \"company\": \"https://weixin.cashbus.com/#/events/promo/18101\",\n" +
            "      \"url_h5\": \"https://weixin.cashbus.com/#/events/promo/22301\",\n" +
            "      \"url_h5_xiaoyu\": \"https://weixin.cashbus.com/#/events/promo/26001\",\n" +
            "      \"createdate\": \"04月07日\",\n" +
            "      \"createtime\": \"04-07 16:00\",\n" +
            "      \"creditdate\": \"7\",\n" +
            "      \"creditdates\": \",7,14,\",\n" +
            "      \"creditmaxamount\": \"2000\",\n" +
            "      \"creditminamount\": \"500\",\n" +
            "      \"defalutcreditdate\": \"7\",\n" +
            "      \"defaultmoney\": \"1000\",\n" +
            "      \"defaulttarget\": \"\",\n" +
            "      \"fitpeople\": \"1$2\",\n" +
            "      \"grouptype\": \"0,3,6\",\n" +
            "      \"home\": \"1\",\n" +
            "      \"imagepath\": \"https://dn-kdjz.qbox.me/jiedai/icon/40/1479137572.png\",\n" +
            "      \"interest\": \"[\\n    {\\n        \\\"creditdate\\\": 7, \\n        \\\"id\\\": 497, \\n        \\\"monthinterest\\\": \\\"0.72\\\", \\n        \\\"productid\\\": \\\"40\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 14, \\n        \\\"id\\\": 499, \\n        \\\"monthinterest\\\": \\\"0.72\\\", \\n        \\\"productid\\\": \\\"40\\\", \\n        \\\"type\\\": \\\"2\\\", \\n        \\\"version\\\": 0\\n    }\\n]\",\n" +
            "      \"interesttype\": \"\",\n" +
            "      \"iospaymenturl\": \"\",\n" +
            "      \"iostarget\": \"8\",\n" +
            "      \"iosweixinhome\": \"2$3\",\n" +
            "      \"joincount\": \"826435\",\n" +
            "      \"jumptype\": \"16\",\n" +
            "      \"largeloan\": \"0\",\n" +
            "      \"modifytime\": \"1472912995000\",\n" +
            "      \"money\": \".00\",\n" +
            "      \"monthinterest\": \"\",\n" +
            "      \"monthmoney\": \"181\",\n" +
            "      \"name\": \"现金巴士-十万火急\",\n" +
            "      \"othercomment\": \"申请其他产品,提高成功率\",\n" +
            "      \"otherurl\": \"\",\n" +
            "      \"phone\": \"021-10101058\",\n" +
            "      \"process\": \"[\\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_ysysq.png\\\", \\n        \\\"name\\\": \\\"手机认证\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_jbxx.png\\\", \\n        \\\"name\\\": \\\"身份认证\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_ddfk.png\\\", \\n        \\\"name\\\": \\\"等待放款\\\"\\n    }\\n]\",\n" +
            "      \"producttype\": \"2\",\n" +
            "      \"producttypeid\": \"0\",\n" +
            "      \"proof\": \"身份证;\\r\\n手机运营商;\",\n" +
            "      \"rate\": \"0.72\",\n" +
            "      \"ratearea\": \"0.72%\",\n" +
            "      \"ratetype\": \"2\",\n" +
            "      \"refproductid\": \"\",\n" +
            "      \"remark\": \"1、短期小额应急借款，额度500/1000元，门槛低\\r\\n2、18-55周岁，有手机就能申请\",\n" +
            "      \"repaymenttype\": \"2\",\n" +
            "      \"serial\": \"94\",\n" +
            "      \"strategyurl\": \"http://ai.jielema.com:10080/iotglb-openapi/html/raiders_dk2_xjbs.html\",\n" +
            "      \"target\": \"1\",\n" +
            "      \"templet\": \"\",\n" +
            "      \"templetid\": \"\",\n" +
            "      \"tips\": \"尝试多种贷款产品，能大大提高您的贷款成功率|请确保信息完整，可减少审核时间，快速放款|信用是一个人最大的无形资产，请珍惜您的信用\",\n" +
            "      \"totalinterest\": \"172\",\n" +
            "      \"usetime\": \"60\",\n" +
            "      \"version\": \"0\",\n" +
            "      \"weixindetail\": \"只凭身份证，手机号验证，轻松借款2000\",\n" +
            "      \"weixinno\": \"\",\n" +
            "      \"weixinserial\": \"50\",\n" +
            "      \"weixintarget\": \"热门\",\n" +
            "      \"order_\": \"3100\",\n" +
            "      \"order_home\": \"300\",\n" +
            "      \"havacreditcard\": \"0\",\n" +
            "      \"is_deleted\": \"0\",\n" +
            "      \"row_created_at\": \"2016-09-03 22:30:02\",\n" +
            "      \"row_updated_at\": \"2016-11-24 22:03:31\",\n" +
            "      \"order_group_0\": \"700\",\n" +
            "      \"order_group_1\": \"0\",\n" +
            "      \"order_group_2\": \"0\",\n" +
            "      \"order_group_3\": \"700\",\n" +
            "      \"order_group_4\": \"0\",\n" +
            "      \"order_group_6\": \"0\",\n" +
            "      \"order_group_7\": \"0\",\n" +
            "      \"order_group_8\": \"0\",\n" +
            "      \"order_group_9\": \"0\",\n" +
            "      \"is_hot\": \"0\",\n" +
            "      \"success_rate\": \"98.00\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"autokid\": \"10\",\n" +
            "      \"id\": \"11\",\n" +
            "      \"androidpaymenturl\": \"\",\n" +
            "      \"androidtarget\": \"0\",\n" +
            "      \"apply\": \"1、借款人持有信用卡，并通过固定电子邮件地址来接受信用卡账单；\\r\\n2、22-55（不含）周岁；\\r\\n3、有淘宝账号；\\r\\n4、手机实名制；\\r\\n5、目前支持城市：安徽、北京、重庆、福建、广东、河北、黑龙江、湖北、湖南、江苏、辽宁、四川、山西、山东、浙江、上海、河南；\",\n" +
            "      \"applycondition\": \"1、信用卡使用时间超过4个月\\r\\n2、手机号需实名，有淘宝帐号\",\n" +
            "      \"applyexplain\": \"审核方式：纯线上自动审核，放款时需向本人电话确认\\r\\n审核周期：当天内审核\\r\\n放款时间：1个工作日，最快2小时放款\\r\\n还款方式：自动扣款或去平台还款，可提前还款\",\n" +
            "      \"applyimagepath\": \"http://ai.jielema.com:10080/iotglb-openapi/images/\",\n" +
            "      \"applyprocess\": \"\",\n" +
            "      \"buttonname\": \"快速进入\",\n" +
            "      \"category\": \"3$5$6\",\n" +
            "      \"click\": \"781743\",\n" +
            "      \"comment\": \"1581****168-平台信用不错，借款流程简单|1359****832-一次不错的借款体验，好评|1320****511-不亏为国内知名的借款平台，速度一流\",\n" +
            "      \"company\": \"http://wap.yirendai.com/new/?siteId=2229&source=1\",\n" +
            "      \"url_h5\": \"http://wap.yirendai.com/new/?siteId=2772&source=1\",\n" +
            "      \"url_h5_xiaoyu\": \"http://wap.yirendai.com/new/?siteId=2773&source=1\",\n" +
            "      \"createdate\": \"01月13日\",\n" +
            "      \"createtime\": \"01-13 16:59\",\n" +
            "      \"creditdate\": \"12\",\n" +
            "      \"creditdates\": \",12,24,36,\",\n" +
            "      \"creditmaxamount\": \"10000000\",\n" +
            "      \"creditminamount\": \"10000\",\n" +
            "      \"defalutcreditdate\": \"12\",\n" +
            "      \"defaultmoney\": \"30000\",\n" +
            "      \"defaulttarget\": \"\",\n" +
            "      \"fitpeople\": \"1$4\",\n" +
            "      \"grouptype\": \"4,7\",\n" +
            "      \"home\": \"1\",\n" +
            "      \"imagepath\": \"https://dn-kdjz.qbox.me/jiedai/icon/11/1479137570.png\",\n" +
            "      \"interest\": \"[\\n    {\\n        \\\"creditdate\\\": 12, \\n        \\\"id\\\": 155, \\n        \\\"monthinterest\\\": \\\"0.78\\\", \\n        \\\"productid\\\": \\\"11\\\", \\n        \\\"type\\\": \\\"1\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 24, \\n        \\\"id\\\": 156, \\n        \\\"monthinterest\\\": \\\"0.78\\\", \\n        \\\"productid\\\": \\\"11\\\", \\n        \\\"type\\\": \\\"1\\\", \\n        \\\"version\\\": 0\\n    }, \\n    {\\n        \\\"creditdate\\\": 36, \\n        \\\"id\\\": 157, \\n        \\\"monthinterest\\\": \\\"0.78\\\", \\n        \\\"productid\\\": \\\"11\\\", \\n        \\\"type\\\": \\\"1\\\", \\n        \\\"version\\\": 0\\n    }\\n]\",\n" +
            "      \"interesttype\": \"1\",\n" +
            "      \"iospaymenturl\": \"\",\n" +
            "      \"iostarget\": \"8\",\n" +
            "      \"iosweixinhome\": \"2$3\",\n" +
            "      \"joincount\": \"617341\",\n" +
            "      \"jumptype\": \"17\",\n" +
            "      \"largeloan\": \"0\",\n" +
            "      \"modifytime\": \"1472912987000\",\n" +
            "      \"money\": \".00\",\n" +
            "      \"monthinterest\": \"0.78\",\n" +
            "      \"monthmoney\": \"174\",\n" +
            "      \"name\": \"宜人贷-大额贷\",\n" +
            "      \"othercomment\": \"申请其他产品,提高成功率\",\n" +
            "      \"otherurl\": \"\",\n" +
            "      \"phone\": \"400-6099-400\",\n" +
            "      \"process\": \"[\\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_bdyhk.png\\\", \\n        \\\"name\\\": \\\"信用卡验证\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_zxbg.png\\\", \\n        \\\"name\\\": \\\"征信报告\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_jbxx.png\\\", \\n        \\\"name\\\": \\\"身份认证\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_dssq.png\\\", \\n        \\\"name\\\": \\\"电商授权\\\"\\n    }, \\n    {\\n        \\\"comment\\\": \\\"\\\", \\n        \\\"image\\\": \\\"productdetail_btn_sqlc_ysysq.png\\\", \\n        \\\"name\\\": \\\"手机认证\\\"\\n    }\\n]\",\n" +
            "      \"producttype\": \"1\",\n" +
            "      \"producttypeid\": \"0$1\",\n" +
            "      \"proof\": \"1、提供单张信用卡连续4个月的账单。\\r\\n2、实名手机认证。\\r\\n3、淘宝账号信息。\",\n" +
            "      \"rate\": \"0.78\",\n" +
            "      \"ratearea\": \"0.78%-1.89%\",\n" +
            "      \"ratetype\": \"1\",\n" +
            "      \"refproductid\": \"56\",\n" +
            "      \"remark\": \"目前宜人贷有三款网贷产品：\\r\\n极速贷款：月利率最低0.78%，需信用卡才能办理；\\r\\n普通贷款：一周内审核，支持全国，需要征信报告；\\r\\n公积金贷：当天审核，需要公积金开户一年以上，信用卡开卡时间4个月以上，提供征信报告才能办理；\",\n" +
            "      \"repaymenttype\": \"1\",\n" +
            "      \"serial\": \"\",\n" +
            "      \"strategyurl\": \"http://ai.jielema.com:10080/iotglb-openapi/html/raiders_dk2_yrd.html\",\n" +
            "      \"target\": \"1\",\n" +
            "      \"templet\": \"\",\n" +
            "      \"templetid\": \"\",\n" +
            "      \"tips\": \"尝试多种贷款产品，能大大提高您的贷款成功率|请确保信息完整，可减少审核时间，快速放款|信用是一个人最大的无形资产，请珍惜您的信用\",\n" +
            "      \"totalinterest\": \"96\",\n" +
            "      \"usetime\": \"60\",\n" +
            "      \"version\": \"0\",\n" +
            "      \"weixindetail\": \"手持信用卡，淘宝消费记录，手机实名认证\",\n" +
            "      \"weixinno\": \"\",\n" +
            "      \"weixinserial\": \"43\",\n" +
            "      \"weixintarget\": \"\",\n" +
            "      \"order_\": \"1000\",\n" +
            "      \"order_home\": \"100\",\n" +
            "      \"havacreditcard\": \"1\",\n" +
            "      \"is_deleted\": \"0\",\n" +
            "      \"row_created_at\": \"2016-09-03 22:29:59\",\n" +
            "      \"row_updated_at\": \"2016-11-24 22:34:37\",\n" +
            "      \"order_group_0\": \"0\",\n" +
            "      \"order_group_1\": \"0\",\n" +
            "      \"order_group_2\": \"0\",\n" +
            "      \"order_group_3\": \"0\",\n" +
            "      \"order_group_4\": \"600\",\n" +
            "      \"order_group_6\": \"0\",\n" +
            "      \"order_group_7\": \"0\",\n" +
            "      \"order_group_8\": \"0\",\n" +
            "      \"order_group_9\": \"0\",\n" +
            "      \"is_hot\": \"0\",\n" +
            "      \"success_rate\": \"98.00\"\n" +
            "    }\n" +
            "  ]";

}
