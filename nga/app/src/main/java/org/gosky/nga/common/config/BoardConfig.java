package org.gosky.nga.common.config;

import org.gosky.nga.R;
import org.gosky.nga.data.entity.Board;
import org.gosky.nga.data.entity.BoardHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zohar on 2017/6/18.
 * desc:
 */

public class BoardConfig {

    public List<BoardHolder> buildBoardData() {
        int i = 0;
        List<BoardHolder> boardHolders = new ArrayList<>();

        List<Board> boards = new ArrayList<>();
        boards.add(new Board(i, "7", "议事厅", R.drawable.oldp7));
        boards.add(new Board(i, "323", "国服以外讨论", R.drawable.oldp323));
        boards.add(new Board(i, "10", "银色黎明", R.drawable.oldp10));
        boards.add(new Board(i, "230", "艾泽拉斯风纪委员会", R.drawable.oldp230));
        boards.add(new Board(i, "387", "潘大力亚之迷雾", R.drawable.oldp387));
        boards.add(new Board(i, "430", "德拉诺之王", R.drawable.oldp430));
        boards.add(new Board(i, "305", "305权贵区", R.drawable.oldpdefault));
        boards.add(new Board(i, "11", "诺森德埋骨地", R.drawable.oldpdefault));
        boardHolders.add(new BoardHolder("综合讨论",boards));
        i++;

        List<Board> boards2 = new ArrayList<>();
        boards2.add(new Board(i, "-7", "大漩涡", R.drawable.oldp354));
        boards2.add(new Board(i, "-343809", "汽车俱乐部", R.drawable.oldpdefault));
        boards2.add(new Board(i, "-81981", "生命之杯", R.drawable.oldpdefault));
        boards2.add(new Board(i, "-576177", "影音讨论区", R.drawable.oldpdefault));
        boards2.add(new Board(i, "497", "魔兽世界电影", R.drawable.oldpdefault));
        boards2.add(new Board(i, "-43", "军事历史", R.drawable.oldpdefault));
        boards2.add(new Board(i, "414", "游戏综合讨论", R.drawable.oldp414));
        boards2.add(new Board(i, "415", "主机游戏综合讨论", R.drawable.oldpdefault));
        boards2.add(new Board(i, "427", "怪物猎人", R.drawable.oldp427));
        boards2.add(new Board(i, "431", "风暴英雄", R.drawable.oldp431));
        boards2.add(new Board(i, "436", "消费电子 IT新闻", R.drawable.oldpdefault));
        boards2.add(new Board(i, "498", "二手交易", R.drawable.oldpdefault));
        boards2.add(new Board(i, "340", "无聊图", R.drawable.oldpdefault));
        boards2.add(new Board(i, "456", "冲水区", R.drawable.oldpdefault));
        boards2.add(new Board(i, "-187579", "大漩涡历史博物馆", R.drawable.oldpdefault));
        boards2.add(new Board(i, "485", "篮球", R.drawable.oldpdefault));
        boards2.add(new Board(i, "491", "议会", R.drawable.oldpdefault));
        boardHolders.add(new BoardHolder("大漩涡系列",boards2));
        i++;
        return boardHolders;
//        boards.add(new Board(i, "390", "五晨寺", R.drawable.oldp390));
//        boards.add(new Board(i, "320", "黑锋要塞", R.drawable.oldp320));
//        boards.add(new Board(i, "181", "铁血沙场", R.drawable.oldp181));
//        boards.add(new Board(i, "182", "魔法圣堂", R.drawable.oldp182));
//        boards.add(new Board(i, "183", "信仰神殿", R.drawable.oldp183));
//        boards.add(new Board(i, "185", "风暴祭坛", R.drawable.oldp185));
//        boards.add(new Board(i, "186", "翡翠梦境", R.drawable.oldp186));
//        boards.add(new Board(i, "187", "猎手大厅", R.drawable.oldp187));
//        boards.add(new Board(i, "184", "圣光之力", R.drawable.oldp184));
//        boards.add(new Board(i, "188", "恶魔深渊", R.drawable.oldp188));
//        boards.add(new Board(i, "189", "暗影裂口", R.drawable.oldp189));
//        boards.add(new Board(i, "477", "伊利达雷", R.drawable.oldp477));
//        boards.addCategoryName(i, "职业讨论区");
//        i++;
//
//        boards.add(new Board(i, "310", "精英议会", R.drawable.oldp310));
//        boards.add(new Board(i, "190", "任务讨论", R.drawable.oldp190));
//        boards.add(new Board(i, "213", "战争档案", R.drawable.oldp213));
//        boards.add(new Board(i, "218", "副本专区", R.drawable.oldp218));
//        boards.add(new Board(i, "258", "战场讨论", R.drawable.oldp258));
//        boards.add(new Board(i, "272", "竞技场", R.drawable.oldp272));
//        boards.add(new Board(i, "191", "地精商会", R.drawable.oldp191));
//        boards.add(new Board(i, "200", "插件研究", R.drawable.oldp200));
//        boards.add(new Board(i, "240", "BigFoot", R.drawable.oldp240));
//        boards.add(new Board(i, "460", "大脚综合", R.drawable.oldpdefault));
//        boards.add(new Board(i, "461", "大脚水区", R.drawable.oldpdefault));
//        boards.add(new Board(i, "458", "大脚LOL", R.drawable.oldpdefault));
//        boards.add(new Board(i, "274", "插件发布", R.drawable.oldp274));
//        boards.add(new Board(i, "315", "战斗统计", R.drawable.oldp315));
//        boards.add(new Board(i, "333", "DKP系统", R.drawable.oldp333));
//        boards.add(new Board(i, "327", "成就讨论", R.drawable.oldp327));
//        boards.add(new Board(i, "388", "幻化讨论", R.drawable.oldp388));
//        boards.add(new Board(i, "411", "宠物讨论", R.drawable.oldp411));
//        boards.add(new Board(i, "463", "要塞讨论", R.drawable.oldpdefault));
//        boards.add(new Board(i, "255", "公会管理", R.drawable.oldp10));
//        boards.add(new Board(i, "306", "人员招募", R.drawable.oldp10));
//        boards.addCategoryName(i, "冒险心得");
//        i++;
//
//        boards.add(new Board(i, "264", "卡拉赞剧院", R.drawable.oldp264));
//        boards.add(new Board(i, "8", "大图书馆", R.drawable.oldp8));
//        boards.add(new Board(i, "102", "作家协会", R.drawable.oldp102));
//        boards.add(new Board(i, "124", "壁画洞窟", R.drawable.oldpdefault));
//        boards.add(new Board(i, "254", "镶金玫瑰", R.drawable.oldp254));
//        boards.add(new Board(i, "355", "龟岩兄弟会", R.drawable.oldp355));
//        boards.add(new Board(i, "116", "奇迹之泉", R.drawable.oldp116));
//        boards.addCategoryName(i, "麦迪文之塔");
//        i++;
//
//        boards.add(new Board(i, "193", "帐号安全", R.drawable.oldp193));
//        boards.add(new Board(i, "334", "PC软硬件", R.drawable.oldp334));
//        boards.add(new Board(i, "201", "系统问题", R.drawable.oldp201));
//        boards.add(new Board(i, "335", "网站开发", R.drawable.oldp335));
//        boards.addCategoryName(i, "系统软硬件讨论");
//        i++;
//
//        boards.add(new Board(i, "414", "游戏综合讨论", R.drawable.oldp414));
//        boards.add(new Board(i, "428", "手机游戏", R.drawable.oldp428));
//        boards.add(new Board(i, "431", "风暴英雄", R.drawable.oldp431));
//        boards.add(new Board(i, "-452227", "口袋妖怪", R.drawable.oldp452227));
//        boards.add(new Board(i, "426", "智龙迷城", R.drawable.oldp426));
//        boards.add(new Board(i, "-51095", "部落冲突", R.drawable.oldp51095));
//        boards.add(new Board(i, "492", "部落冲突:皇室战争", R.drawable.oldp492));
//        boards.add(new Board(i, "-362960", "最终幻想14", R.drawable.oldp362960));
//        boards.add(new Board(i, "-6194253", "战争雷霆", R.drawable.oldp6194253));
//        boards.add(new Board(i, "427", "怪物猎人", R.drawable.oldp427));
//        boards.add(new Board(i, "-47218", "地下城与勇士", R.drawable.oldp4218));
//        boards.add(new Board(i, "425", "行星边际2", R.drawable.oldp425));
//        boards.add(new Board(i, "422", "炉石传说", R.drawable.oldp422));
//        boards.add(new Board(i, "-65653", "剑灵", R.drawable.oldp65653));
//        boards.add(new Board(i, "412", "巫师之怒", R.drawable.oldp412));
//        boards.add(new Board(i, "-235147", "激战2", R.drawable.oldp235147));
//        boards.add(new Board(i, "442", "逆战", R.drawable.oldp442));
//        boards.add(new Board(i, "-46468", "洛拉斯的战争世界", R.drawable.oldp46468));
//        boards.add(new Board(i, "483", "洛拉斯的战争世界:插件", R.drawable.oldp46468));
//        boards.add(new Board(i, "432", "战机世界", R.drawable.oldp432));
//        boards.add(new Board(i, "441", "战舰世界", R.drawable.oldpdefault));
//        boards.add(new Board(i, "321", "DotA", R.drawable.oldp321));
//        boards.add(new Board(i, "375", "DotA联赛饰品", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-2371813", "EVE", R.drawable.oldp2371813));
//        boards.add(new Board(i, "-7861121", "剑叁 ", R.drawable.oldp7861121));
//        boards.add(new Board(i, "448", "剑叁同人 ", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-793427", "斗战神", R.drawable.oldpdefault));
//        boards.add(new Board(i, "332", "战锤40K", R.drawable.oldp332));
//        boards.add(new Board(i, "416", "火炬之光2", R.drawable.oldpdefault));
//        boards.add(new Board(i, "406", "星际争霸2", R.drawable.oldpdefault));
//        boards.add(new Board(i, "420", "MT Online", R.drawable.oldp420));
//        boards.add(new Board(i, "424", "圣斗士星矢", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-1513130", "鲜血兄弟会", R.drawable.oldpdefault));
//        boards.add(new Board(i, "433", "神雕侠侣", R.drawable.oldpdefault));
//        boards.add(new Board(i, "434", "神鬼幻想", R.drawable.oldpdefault));
//        boards.add(new Board(i, "435", "上古卷轴Online", R.drawable.oldp435));
//        boards.add(new Board(i, "443", "FIFA Online 3", R.drawable.oldpdefault));
//        boards.add(new Board(i, "444", "刀塔传奇", R.drawable.oldp444));
//        boards.add(new Board(i, "445", "迷你西游", R.drawable.oldp445));
//        boards.add(new Board(i, "447", "锁链战记", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-532408", "沃土", R.drawable.oldp532408));
//        boards.add(new Board(i, "353", "纽沃斯英雄传", R.drawable.oldpdefault));
//        boards.add(new Board(i, "452", "天涯明月刀", R.drawable.oldp452));
//        boards.add(new Board(i, "453", "魔力宝贝", R.drawable.oldpdefault));
//        boards.add(new Board(i, "454", "神之浩劫", R.drawable.oldpdefault));
//        boards.add(new Board(i, "455", "鬼武者 魂", R.drawable.oldpdefault));
//        boards.add(new Board(i, "480", "百万亚瑟王", R.drawable.oldpdefault));
//        boards.add(new Board(i, "481", "Minecraft", R.drawable.oldpdefault));
//        boards.add(new Board(i, "482", "CS", R.drawable.oldpdefault));
//        boards.add(new Board(i, "484", "热血江湖传", R.drawable.oldpdefault));
//        boards.add(new Board(i, "486", "辐射", R.drawable.oldpdefault));
//        boards.add(new Board(i, "487", "刀剑魔药2", R.drawable.oldpdefault));
//        boards.add(new Board(i, "488", "村长打天下", R.drawable.oldpdefault));
//        boards.add(new Board(i, "493", "刀塔战纪", R.drawable.oldpdefault));
//        boards.add(new Board(i, "494", "魔龙之魂", R.drawable.oldpdefault));
//        boards.add(new Board(i, "495", "光荣三国志系列", R.drawable.oldpdefault));
//        boards.add(new Board(i, "496", "九十九姬", R.drawable.oldpdefault));
//        boards.addCategoryName(i, "其他游戏");
//        i++;
//
//        boards.add(new Board(i, "318", "暗黑破坏神3", R.drawable.oldp318));
//        boards.add(new Board(i, "403", "购买/安装/共享", R.drawable.oldp403));
//        boards.add(new Board(i, "393", "背景故事与文艺作品", R.drawable.oldp393));
//        boards.add(new Board(i, "400", "职业讨论区", R.drawable.oldp29));
//        boards.add(new Board(i, "395", "野蛮人", R.drawable.oldp395));
//        boards.add(new Board(i, "396", "猎魔人", R.drawable.oldp396));
//        boards.add(new Board(i, "397", "武僧", R.drawable.oldp397));
//        boards.add(new Board(i, "398", "巫医", R.drawable.oldp398));
//        boards.add(new Board(i, "399", "魔法师", R.drawable.oldp399));
//        boards.add(new Board(i, "446", "圣教军", R.drawable.oldpdefault));
//        boards.addCategoryName(i, "暗黑破坏神");
//        i++;
//
//        boards.add(new Board(i, "422", "炉石传说", R.drawable.oldp422));
//        boards.add(new Board(i, "429", "战术讨论", R.drawable.oldpdefault));
//        boards.add(new Board(i, "450", "文章存档", R.drawable.oldpdefault));
//        boards.add(new Board(i, "431", "风暴英雄", R.drawable.oldp431));
//        boards.add(new Board(i, "457", "视频资料", R.drawable.oldpdefault));
//        boards.add(new Board(i, "459", "守望先锋", R.drawable.oldp459));
//        boards.add(new Board(i, "490", "魔兽争霸", R.drawable.oldpdefault));
//        boards.addCategoryName(i, "暴雪游戏");
//        i++;
//
//        boards.add(new Board(i, "-152678", "英雄联盟", R.drawable.oldp152678));
//        boards.add(new Board(i, "418", "游戏视频", R.drawable.oldpdefault));
//        boards.add(new Board(i, "479", "赛事讨论", R.drawable.oldpdefault));
//        boards.addCategoryName(i, "英雄联盟");
//        i++;
//
//        boards.add(new Board(i, "-447601", "二次元国家地理", R.drawable.oldp447601));
//        boards.add(new Board(i, "-84", "模玩之魂", R.drawable.oldp84));
//        boards.add(new Board(i, "-8725919", "小窗视界", R.drawable.oldp8725919));
//        boards.add(new Board(i, "-965240", "树洞", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-131429", "红茶馆——小说馆", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-608808", "血腥厨房", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-469608", "影~视~秀", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-55912", "音乐讨论", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-522474", "综合体育讨论区", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-1068355", "晴风村", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-168888", "育儿版", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-54214", "时尚板", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-353371", "宠物养成", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-538800", "乙女向二次元", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-7678526", "麻将科学院", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-202020", "程序员职业交流", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-444012", "我们的骑迹", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-349066", "开心茶园", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-314508", "世界尽头的百货公司", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-2671", "耳机区", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-970841", "东方教主陈乔恩", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-3355501", "基腐版", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-403298", "怨灵图纸收藏室", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-3432136", "飘落的诗章", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-187628", "家居 装修", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-8627585", "牛头人酋长乐队", R.drawable.oldpdefault));
//        boards.add(new Board(i, "-17100", "全民健身中心", R.drawable.oldpdefault));
//        boards.addCategoryName(i, "个人版面");

    }
}
